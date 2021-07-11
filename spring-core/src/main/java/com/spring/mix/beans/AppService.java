package com.spring.mix.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AppService implements InitializingBean, DisposableBean {

    @Autowired
    private AppDao appDao;

    public AppService() {
        display(" constructor");
    }

    @PostConstruct
    public void init()
    {
        display(" custom init");
        System.out.println(appDao+" injected");
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
    public void setAppDao(AppDao appDao){
        System.out.println(this.getClass()+ " setter of "+appDao.getClass());
        this.appDao = appDao;
    }
}
