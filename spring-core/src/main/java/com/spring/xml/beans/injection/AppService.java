package com.spring.xml.beans.injection;

public class AppService {

    private AppDao appDao;

    public AppService() {
        System.out.println("default constructor running: "+this.getClass());
    }

    public AppService(AppDao appDao) {
        System.out.println("executing param constructor injection inside the class: "+this.getClass());
        this.appDao = appDao;
    }

    public String sayHello() {
        return appDao.sayHello();
    }

    public void setAppDao(AppDao appDao) {
        System.out.println("executing setter inside the class : "+this.getClass());
        this.appDao = appDao;
    }
}
