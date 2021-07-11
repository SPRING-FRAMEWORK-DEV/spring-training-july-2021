package com.spring.xml.beans.hooks.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

public class AppBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // can customize bean factory before any bean creation
       boolean flag = configurableListableBeanFactory.containsBeanDefinition("default");
       if(flag)
           ((BeanDefinitionRegistry)(configurableListableBeanFactory)).removeBeanDefinition("indian");
       else{
           System.out.println("no bean definition found for default");
       }
    }
}
