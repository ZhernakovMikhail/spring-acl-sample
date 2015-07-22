package com.zhernakov.samples.security.config;

import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.acls.AclPermissionEvaluator;
import org.springframework.security.acls.domain.*;
import org.springframework.security.acls.jdbc.BasicLookupStrategy;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.security.acls.jdbc.LookupStrategy;
import org.springframework.security.acls.model.AclCache;
import org.springframework.security.acls.model.AclService;
import org.springframework.security.acls.model.PermissionGrantingStrategy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import javax.sql.DataSource;

/**
 * Created by Misha on 21.07.2015.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({CachingConfig.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    CacheManager ehCacheManager;

    @Autowired
    public void registerSharedAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        final JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource);
        jdbcDao.setEnableAuthorities(true);
        jdbcDao.setEnableGroups(true);
        return jdbcDao;
    }

    @Bean
    public MethodSecurityExpressionHandler methodSecurityExpressionHandler() {
        final DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(aclPermissionEvaluator());
        return expressionHandler;
    }

    @Bean
    public AclPermissionEvaluator aclPermissionEvaluator() {
        final AclPermissionEvaluator aclPermissionEvaluator = new AclPermissionEvaluator(aclService());
        return aclPermissionEvaluator;
    }

    @Bean
    public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
        final DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setPermissionEvaluator(aclPermissionEvaluator());
        return handler;
    }

    @Bean
    public AclService aclService() {
        return new JdbcMutableAclService(dataSource, lookupStrategy(), aclCache());
    }

    @Bean
    public LookupStrategy lookupStrategy() {
        return new BasicLookupStrategy(dataSource, aclCache(), aclAuthorizationStrategy(), permissionGrantingStrategy());
    }

    @Bean
    public AclCache aclCache() {
        final EhCacheBasedAclCache cache = new EhCacheBasedAclCache(ehCacheManager.getCache("aclCache"), permissionGrantingStrategy(), aclAuthorizationStrategy());
        return cache;
    }

    @Bean
    public AclAuthorizationStrategy aclAuthorizationStrategy() {
        return new AclAuthorizationStrategyImpl(new SimpleGrantedAuthority("ADMIN"));
    }

    @Bean
    public PermissionGrantingStrategy permissionGrantingStrategy() {
        return new DefaultPermissionGrantingStrategy(auditLogger());
    }

    @Bean
    public AuditLogger auditLogger() {
        return new ConsoleAuditLogger();
    }
}
