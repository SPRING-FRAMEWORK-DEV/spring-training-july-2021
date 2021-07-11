package com.spring.stereo.main;

import com.spring.stereo.beans.injection.StudioService;
import com.spring.stereo.beans.properties.DataSourceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppMainAntnConfig {

    public static void main(String[] args) {

        componentScan();
//        injectingProperties();

        // stereoExecutions();


    }


    private static void stereoExecutions() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.spring.stereo.beans.hooks.executions");
        applicationContext.refresh(); // without this refresh beans wont be refreshed
        applicationContext.registerShutdownHook();
    }

    private static void injectingProperties() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.spring.stereo.beans.properties");
        DataSourceConfig dataSourceConfig = applicationContext.getBean(DataSourceConfig.class);
        System.out.println(dataSourceConfig.toString());
    }

    private static void componentScan() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.spring.stereo.beans.injection");
        StudioService service = applicationContext.getBean(StudioService.class);
        System.out.println(service.getStudio("abc"));
    }
}