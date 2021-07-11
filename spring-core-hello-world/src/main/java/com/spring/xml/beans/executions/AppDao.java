package com.spring.xml.beans.executions;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AppDao implements InitializingBean, DisposableBean {

    public AppDao() {
        display();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass()+ " destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println(this.getClass()+" afterPropertiesSet");
    }

    private void display()
    {
        System.out.println(this.getClass()+ " constructor");
    }
}
