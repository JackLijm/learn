package com.ljm.springbootdemo.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName CommonConfig
 * @Description 定义一个阿里连接池的datasource，使用spring.druib前缀配置
 * @Author lijiaming
 * @Date 2018/9/28 16:26
 * @Version 1.0
 **/
@Configuration
@ConfigurationProperties(prefix = "spring.druid")
public class CommonConfig {

    private String url;
    private String username;
    private String password;

    @Bean(name = "druibDataSource")
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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
