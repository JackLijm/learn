package com.ljm.springbootdemo.controller;

import com.ljm.springbootdemo.properteis.LoginVo;
import com.ljm.springbootdemo.properteis.WelComeVo;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class PropertiesDemo {
    //配置文件获取方式1 （获取默认application.properties中的属性）
    @Value(value = "${com.lijm.name}")
    private String name;
    @Value(value = "${com.lijm.word}")
    private String word;
    //获取随机值
    @Value(value = "${com.lijm.uuid}")
    private String uuid;
    @Value(value = "${com.lijm.secret}")
    private String secret;

    //配置文件获取方式2（用test.properties文件中的属性来初始化bean）
    @Autowired
    private LoginVo loginVo;
    @Autowired
    private WelComeVo welComeVo;
    //加载文件流
    @Value("classpath:/test.txt")
    private Resource testFile;

    //加载网络资源
    @Value("https://www.baidu.com")
    private Resource testUrl;

    @RequestMapping("/propertiesdemo")
    public String index() throws IOException {

        String returnmsg = uuid + "," + secret + "\r\n"
                +name + "," + word + "\r\n"
                + loginVo.getUsername() + "," + loginVo.getPassword() + "\r\n"
                + welComeVo.getName() + "," + welComeVo.getWord()+IOUtils.toString(testFile.getInputStream())+IOUtils.toString(testUrl.getInputStream());
        return returnmsg;
    }
}
