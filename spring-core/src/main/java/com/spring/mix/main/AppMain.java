package com.spring.mix.main;

import com.spring.mix.beans.AppBeanConfig;
import com.spring.xml.beans.properties.DataSourceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AppBeanConfig.class);
       // annotationConfigApplicationContext.scan(AppBeanConfig.class.getPackage().getName());
        annotationConfigApplicationContext.refresh();

        DataSourceConfig dataSourceConfig = annotationConfigApplicationContext.getBean(DataSourceConfig.class);

        System.out.println(dataSourceConfig);

        annotationConfigApplicationContext.close();
    }
}
