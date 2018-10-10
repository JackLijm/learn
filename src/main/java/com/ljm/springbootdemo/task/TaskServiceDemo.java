package com.ljm.springbootdemo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TaskServiceDemo {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 50000) //每隔固定时间执行一次，单位毫秒
    public void reportCurrentTime(){
        System.out.println("每隔50秒执行一次 "+dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 28 11 ? * *") //每天11.28分执行一次
    public void fixTimeExecution(){
        System.out.println("在指定时间 " + dateFormat.format(new Date())+"执行");
    }
}
