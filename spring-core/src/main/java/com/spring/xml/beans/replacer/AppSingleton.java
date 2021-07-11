package com.spring.xml.beans.replacer;

public class AppSingleton {

    private AppPrototype appPrototype;

    public void display() {
        System.out.println(appPrototype.getEnvironmentName());
        System.out.println(getAppPrototype().getEnvironmentName());
    }

    public void setAppPrototype(AppPrototype appPrototype) {
        this.appPrototype = appPrototype;
    }

    public AppPrototype getAppPrototype()
    {
        return null;
    }
}
