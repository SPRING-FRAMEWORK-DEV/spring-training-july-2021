package com.spring.xml.main;

import com.spring.xml.beans.autowiring.PaymentService;
import com.spring.xml.beans.hooks.lifecycle.EmailNotificationService;
import com.spring.xml.beans.hooks.processors.DefaultCurrencyService;
import com.spring.xml.beans.properties.DataSourceConfig;
import com.spring.xml.beans.injection.WorkSpaceService;
import com.spring.xml.beans.injection.AppDao;
import com.spring.xml.beans.injection.AppService;
import com.spring.xml.beans.replacer.AppSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AppMain {

    public static void main(String[] args) {


        accessBeanWithoutDependency();

        beanScopes();

        accessBeanWithSetterInjection();

        accessBeanWithConstructorInjection();

        accessBeanWithConstructorAndSetterInjection();

        injectingPropertiesFileValues();

        importXmlFiles();

        multipleXmlFiles();

        lifecycleHooks();

        processorsBySpring();

        methodReplacement();

       autowiringByType();

        executions();
    }

    private static void executions()
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("xml/executions/my-application-context-bean.xml");


        String[] beans = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beans));

        ClassPathXmlApplicationContext context1 = (ClassPathXmlApplicationContext) context;
        context1.registerShutdownHook();

    }

    private static void autowiringByType()
    {
        // try other autowiring types: byType, byName, constructor, autodetect
        /**
         * <pre>
         *  byName: The byName mode injects the object dependency according to name of the bean.
         *     In such a case, the property and bean name should be the same.
         *     It internally calls the setter method.
         *
         * byType: The byType mode injects the object dependency according to type.
         * So it can have a different property and bean name.
         * It internally calls the setter method.
         *
         * constructor: The constructor mode injects the dependency by calling
         * the constructor of the class. It calls the constructor having a large number of parameters.
         *
         * autodetect: In this mode, Spring first tries to autowire by the constructor.
         * If this fails, it tries to autowire by using byType
         * </pre>
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/autowiring/my-application-context-bean.xml");
        PaymentService paymentService = context.getBean(PaymentService.class);
        System.out.println(paymentService.isPaymentSuccess("xyz"));
    }
    private static void methodReplacement() {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/replacer/my-application-context-replacement.xml");
        AppSingleton appSingleton = context.getBean(AppSingleton.class);
        appSingleton.display();
        appSingleton.display();
    }

    private static void processorsBySpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/hooks/my-application-context-processor.xml");
        DefaultCurrencyService defaultCurrencyService = context.getBean(DefaultCurrencyService.class);
        System.out.println(defaultCurrencyService.getDefaultCurrency());
        //   context.getBean(IndianCurrencyService.class);
    }

    private static void lifecycleHooks() {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/hooks/my-application-context-lifecycle.xml");

        EmailNotificationService service = context.getBean(EmailNotificationService.class);

        String[] toEmails = {"x@y.com", "a@b.com"};
        System.out.println(service.sendEmail(toEmails, "Welcome to OnBoarding at FICO"));

        ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext) context;
        applicationContext.registerShutdownHook();


    }

    private static void multipleXmlFiles() {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/injection/my-application-context-nested.xml", "xml/injection/my-application-context-bean.xml");

        AppService service = context.getBean(AppService.class);

        System.out.println(service.sayHello());

    }

    private static void importXmlFiles() {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/injection/my-application-context-import.xml");

        AppService service = context.getBean(AppService.class);

        System.out.println(service.sayHello());
    }

    private static void beanScopes() {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/injection/my-application-context-bean.xml");

        AppDao appDao = context.getBean("myAppDao1", AppDao.class);

        System.out.println(appDao);

        appDao = context.getBean("myAppDao1", AppDao.class);

        System.out.println(appDao);

        System.out.println("==================below is singleton===========================");

        appDao = context.getBean("myAppDao", AppDao.class);

        System.out.println(appDao);

        appDao = context.getBean("myAppDao", AppDao.class);

        System.out.println(appDao);

    }

    private static void injectingPropertiesFileValues() {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/properties/my-application-context-properties-file.xml");
        DataSourceConfig dataSourceConfig = context.getBean(DataSourceConfig.class);
        System.out.println(dataSourceConfig);
    }

    private static void accessBeanWithConstructorAndSetterInjection() {
        // dao injected into service
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/injection/my-application-context-setter-constructor.xml");

        WorkSpaceService service = context.getBean(WorkSpaceService.class);


        service.display();
    }


    private static void accessBeanWithConstructorInjection() {
        // dao injected into service
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/injection/my-application-context-constructor.xml");

        AppService service = context.getBean(AppService.class);

        System.out.println(service.sayHello());

    }

    private static void accessBeanWithSetterInjection() {
        // dao injected into service
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/injection/my-application-context-setter.xml");

        AppService service = context.getBean(AppService.class);

        System.out.println(service.sayHello());

    }

    private static void accessBeanWithoutDependency() {
        // dao has no dependency in this example
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/injection/my-application-context-bean.xml");
        AppDao appDao = context.getBean("myAppDao",AppDao.class);
        System.out.println(appDao.sayHello());
    }
}
