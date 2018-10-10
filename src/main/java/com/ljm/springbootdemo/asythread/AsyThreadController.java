package com.ljm.springbootdemo.asythread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asythread")
public class AsyThreadController {
    @Autowired
    public AsyThreadService asyThreadService;

    @RequestMapping("/run")
    public void runThread(){
        for(int i=0;i<10;i++){
            asyThreadService.excuteAsyncTask(i);
            asyThreadService.excuteAsyncTaskPlus(i);
        }
    }
}
