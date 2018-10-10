package com.ljm.springbootdemo.startup;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class SpringApplicationRunningListenerDemo implements SpringApplicationRunListener {
    @Override
    public void starting() {
        System.out.println(" i am SpringApplicationRunningListenerDemo  ,stap 3[start]");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println(" i am SpringApplicationRunningListenerDemo  ,stap 3[environmentPrepared]");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println(" i am SpringApplicationRunningListenerDemo  ,stap 3[contextPrepared]");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println(" i am SpringApplicationRunningListenerDemo  ,stap 3[contextLoaded]");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println(" i am SpringApplicationRunningListenerDemo  ,stap 3[started]");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println(" i am SpringApplicationRunningListenerDemo  ,stap 3[running]");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println(" i am SpringApplicationRunningListenerDemo  ,stap 3[failed]");
    }
}
