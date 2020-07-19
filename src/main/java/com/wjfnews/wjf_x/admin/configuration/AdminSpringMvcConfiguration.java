package com.wjfnews.wjf_x.admin.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration

public class AdminSpringMvcConfiguration extends WebMvcConfigurationSupport {

    /*@Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new InterceptorUser());
        interceptorRegistration.addPathPatterns("/admin/**");
        interceptorRegistration.excludePathPatterns("/admin/login");
        interceptorRegistration.excludePathPatterns("/admin/loginOn");
        super.addInterceptors(registry);
    }*/

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/admin/**","/admin/**").addResourceLocations("classpath:/static/admin/");
        registry.addResourceHandler("/static/user/**","/user/**","/user/singleNews/**").addResourceLocations("classpath:/static/user/");
        registry.addResourceHandler("/user/news/pic/**").addResourceLocations("classpath:../pic/");



        super.addResourceHandlers(registry);
    }
}
