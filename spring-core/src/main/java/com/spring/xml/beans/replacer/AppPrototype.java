package com.spring.xml.beans.replacer;

public class AppPrototype {

    public String getEnvironmentName() {
        System.out.println(this.hashCode());
        return "QA";
    }
}
