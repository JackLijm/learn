package com.ljm.springbootdemo.sql.jdpctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//使用spring的jdbctemplate来进行数据库访问
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("/homes")
    public List<Home> getHomes(){
        return homeService.getList();
    }
}
