package com.spring.xml.beans.hooks.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NotificationClient implements InitializingBean, DisposableBean {

    public NotificationClient() {

        System.out.println(this.getClass()+ " constructor");
    }

    private String template;

    public boolean sendMessage(String messageRequest, String messageType) {
        return true;
    }


    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass()+ " destroy ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass()+ " afterPropertiesSet ");
    }
}
