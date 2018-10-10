package com.ljm.springbootdemo.properteis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //使用配置加载器
@ConfigurationProperties(prefix = "loginvo.lijm") //指定属性前缀
@PropertySource("classpath:test.properties") //指定配置文件路径
public class LoginVo {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
