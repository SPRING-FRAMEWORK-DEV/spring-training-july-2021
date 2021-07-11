package com.spring.xml.beans.injection;

public class WorkSpaceService {

    private AppService appService;

    private AppDao appDao;

    public WorkSpaceService(AppDao appDao) {
        this.appDao = appDao;
    }

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    public void display()
    {
        System.out.println(appService.sayHello());
        System.out.println(appDao.sayHello());
    }
}
