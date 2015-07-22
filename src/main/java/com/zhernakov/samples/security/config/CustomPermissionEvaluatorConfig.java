package com.zhernakov.samples.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.acls.AclPermissionEvaluator;
import org.springframework.security.acls.model.AclService;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

/**
 * Created by Misha on 22.07.2015.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomPermissionEvaluatorConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    AclService aclService;


    @Bean
    public MethodSecurityExpressionHandler methodSecurityExpressionHandler() {
        final DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(aclPermissionEvaluator());
        return expressionHandler;
    }

    @Bean
    public AclPermissionEvaluator aclPermissionEvaluator() {
        final AclPermissionEvaluator aclPermissionEvaluator = new AclPermissionEvaluator(aclService);
        return aclPermissionEvaluator;
    }

    @Bean
    public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
        final DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setPermissionEvaluator(aclPermissionEvaluator());
        return handler;
    }
}
