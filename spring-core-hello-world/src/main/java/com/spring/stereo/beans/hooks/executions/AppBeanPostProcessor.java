package com.spring.stereo.beans.hooks.executions;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class AppBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println(this.getClass()+ "postProcessBeforeInitialization for "+bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(this.getClass()+ "postProcessAfterInitialization for "+bean.getClass());
        return bean;
    }
}
