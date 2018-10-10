package com.ljm.springbootdemo.bean;

public class BaseBeanDemo {
    public void initMethod(){
        System.out.println("bean create init");
    }

    public String sayHello(){
        return "hello world";
    }
    public void destroyMethod(){
        System.out.println("bean hase be destroy");
    }
}
