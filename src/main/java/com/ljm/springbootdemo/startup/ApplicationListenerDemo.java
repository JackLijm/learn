package com.ljm.springbootdemo.startup;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationListenerDemo implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(" i am applicationListenerDemo , stap 2");
    }
}
