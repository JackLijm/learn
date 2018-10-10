package com.ljm.springbootdemo.listener;

import org.springframework.context.ApplicationEvent;

//自定义事件
public class MyEventDemo extends ApplicationEvent {
    private String msg;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEventDemo(Object source) {
        super(source);
    }

    public MyEventDemo(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
