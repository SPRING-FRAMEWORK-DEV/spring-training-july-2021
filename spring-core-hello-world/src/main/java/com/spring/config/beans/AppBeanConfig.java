package com.spring.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeanConfig {

    @Bean
    public AppBeanPostProcessor appBeanPostProcessor() {
        return new AppBeanPostProcessor();
    }

    @Bean
    public AppBeanFactoryPostProcessor appBeanFactoryPostProcessor() {
        return new AppBeanFactoryPostProcessor();
    }

    @Bean
    public AppService appService()
    {
        return new AppService();
    }

    @Bean
    public AppDao appDao()
    {
     return new AppDao();
    }
}
