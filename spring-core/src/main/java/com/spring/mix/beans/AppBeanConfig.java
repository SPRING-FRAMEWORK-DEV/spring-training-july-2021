package com.spring.mix.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("xml/properties/my-application-context-properties-file.xml") // for datasource bean
public class AppBeanConfig {

    @Bean
    public AppBeanPostProcessor appBeanPostProcessor() {
        return new AppBeanPostProcessor();
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
