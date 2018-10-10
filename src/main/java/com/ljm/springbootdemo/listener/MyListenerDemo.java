package com.ljm.springbootdemo.listener;

import org.springframework.context.ApplicationListener;

//事件监听类，监听到事件之后执行代码
public class MyListenerDemo implements ApplicationListener<MyEventDemo> {

    @Override
    public void onApplicationEvent(MyEventDemo event) {
        String msg = event.getMsg();
        System.out.println("我(bean-demoListener)接收到了bean-demoPublisher 发布的消息"+msg);
    }
}
