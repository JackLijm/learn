package com.ljm.springbootdemo.asythread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyThreadService {
    @Async
    public void excuteAsyncTask(Integer i) {
        System.out.println("执行异步任务：" + i);
    }
    @Async
    public void excuteAsyncTaskPlus(Integer i) {
        System.out.println("执行异步任务+1：" + (i+1));
    }
}
