package com.spring.xml.beans.hooks.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class EmailNotificationService implements InitializingBean, DisposableBean {

    public EmailNotificationService() {

        System.out.println(this.getClass()+ " constructor");
    }

    private NotificationClient notificationClient;

    private String template;

    public boolean sendEmail(String toEmail[], String message) {
        String messageRequest = toEmail+message;
        return notificationClient.sendMessage(messageRequest, "EMAIL");
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass()+ " destroy ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass()+ " afterPropertiesSet ");
    }

    public void setNotificationClient(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }
}
