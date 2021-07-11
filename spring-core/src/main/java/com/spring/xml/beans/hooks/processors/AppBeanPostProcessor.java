package com.spring.xml.beans.hooks.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class AppBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof DefaultCurrencyService)
        {
           DefaultCurrencyService defaultCurrencyService = (DefaultCurrencyService) bean;
           defaultCurrencyService.setDefaultCurrency("USD");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
