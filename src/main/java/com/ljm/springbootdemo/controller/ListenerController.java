package com.ljm.springbootdemo.controller;

import com.ljm.springbootdemo.listener.MyListenerPublishDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listener")
public class ListenerController {
    @Autowired
    public MyListenerPublishDemo listenerPublishDemo;
    @RequestMapping(value = "/targetEvent")
    public void publishEvent(){
        listenerPublishDemo.publish("你好呀");
//        return "";
    }
}
