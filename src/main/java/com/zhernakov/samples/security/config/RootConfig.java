package com.zhernakov.samples.security.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Created by Misha on 21.07.2015.
 */
@Configuration
@ComponentScan("com.zhernakov")
@Import({DBConfig.class, SecurityConfig.class})
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RootConfig {
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
