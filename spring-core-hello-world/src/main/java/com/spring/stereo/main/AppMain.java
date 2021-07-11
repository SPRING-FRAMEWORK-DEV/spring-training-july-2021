package com.spring.stereo.main;

import com.spring.stereo.beans.injection.StudioService;
import com.spring.stereo.beans.properties.DataSourceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppMain {

    public static void main(String[] args) {

      //  xmlComponentScan();
       // injectingProperties();

       // stereoExecutions();

        stereoExecutionsWithContextConfig();

    }


    private static void stereoExecutionsWithContextConfig()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("stereo/hooks.config.executions/my-application-context-bean.xml");
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
//        context.registerShutdownHook();
        context.close();
    }

    private static void stereoExecutions()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("stereo/hooks.executions/my-application-context-bean.xml");
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.registerShutdownHook();
    }

    private static void injectingProperties()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("stereo/properties/my-application-context-bean.xml");

        DataSourceConfig dataSourceConfig = applicationContext.getBean(DataSourceConfig.class);

        System.out.println(dataSourceConfig.toString());
    }

    private static void xmlComponentScan() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("stereo/injection/my-application-context-bean.xml");
        StudioService service = applicationContext.getBean(StudioService.class);
        System.out.println(service.getStudio("abc"));

    }
}