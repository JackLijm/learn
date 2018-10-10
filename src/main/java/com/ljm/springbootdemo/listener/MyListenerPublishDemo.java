package com.ljm.springbootdemo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//发布事件，利用ApplicationContext的publish来触发
public class MyListenerPublishDemo {
    @Autowired
    public ApplicationContext context;
    public void publish(String msg){
        context.publishEvent(new MyEventDemo(this,msg));
    }
}
