package com.ljm.springbootdemo.configuration;

import com.ljm.springbootdemo.bean.BaseBeanDemo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class BeanConfigurationDemo {



    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    public BaseBeanDemo baseBeanDemo(){
        return new BaseBeanDemo();
    }

}
