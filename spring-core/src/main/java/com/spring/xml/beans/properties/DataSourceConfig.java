package com.spring.xml.beans.properties;

import org.springframework.stereotype.Component;

public class DataSourceConfig {

    private String url;
    private String userName;
    private String password;
    private String driverClassName;

    public DataSourceConfig(String url, String userName, String password, String driverClassName) {
        this.url = url;
        this.userName = userName;
        this.password = password;
        this.driverClassName = driverClassName;
    }

    @Override
    public String toString() {
        return "DataSourceConfig{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                '}';
    }
}
