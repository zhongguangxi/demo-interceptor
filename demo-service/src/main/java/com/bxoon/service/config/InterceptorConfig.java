package com.bxoon.service.config;

import com.bxoon.service.interceptor.SystemInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2020/12/31 17:20
 * @description：拦截器注册
 * @modified By：
 * @version: 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private IgnoreUrlPropertiesConfig ignoreUrlPropertiesConfig;

    @Bean
    public SystemInterceptor sessionInterceptor() {
        return new SystemInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(sessionInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(ignoreUrlPropertiesConfig.getUrls());
    }
}
