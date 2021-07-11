package com.spring.stereo.beans.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Component used to have business logic
@Configuration
//@PropertySource("xml/config/mysql_database.properties")
// : use above alternatively of xml <context:property-placeholder location="xml/config/mysql_database.properties"/>
public class DataSourceConfig {

    @Value("${mysql.db.url:url1}")
    private String url;
    private String userName;

    @Value("${mysql.db.passward:defaultPassword!12#3}")
    private String password;
    private String driverClassName;

    public DataSourceConfig(@Value("${mysql.db.username:url1}") String userName) {
        this.userName = userName;
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
