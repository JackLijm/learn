package com.ljm.springbootdemo.configuration;

import com.ljm.springbootdemo.listener.MyListenerDemo;
import com.ljm.springbootdemo.listener.MyListenerPublishDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfiguration {
    @Bean
    public MyListenerDemo myListenerDemo(){
        return  new MyListenerDemo();
    }
    @Bean
    public MyListenerPublishDemo myListenerPublishDemo(){
        return new MyListenerPublishDemo();
    }
}
