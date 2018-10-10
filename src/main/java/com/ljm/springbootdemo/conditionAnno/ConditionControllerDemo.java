package com.ljm.springbootdemo.conditionAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/condition")
public class ConditionControllerDemo {
    @Autowired
    public ListService service;
    @RequestMapping("/cmd")
    public String condition(){
        System.out.println(service.showListCmd());
     return "";
    }
}
