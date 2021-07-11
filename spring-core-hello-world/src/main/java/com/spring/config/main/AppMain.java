package com.spring.config.main;

import com.spring.config.beans.AppBeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppBeanConfig.class);
        context.refresh();
        context.close();
    }
}
