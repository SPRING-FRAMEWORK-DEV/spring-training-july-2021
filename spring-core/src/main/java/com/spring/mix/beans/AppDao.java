package com.spring.mix.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AppDao implements InitializingBean, DisposableBean {

    public AppDao() {
        display(" constructor");
    }

    @PostConstruct
    public void init()
    {
        display(" custom init");
    }

    @PreDestroy
    public void destroy1()
    {
        display(" custom destroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass()+ " destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println(this.getClass()+" afterPropertiesSet");
    }

    private void display(String executionBlock)
    {
        System.out.println(this.getClass()+ executionBlock);
    }
}
