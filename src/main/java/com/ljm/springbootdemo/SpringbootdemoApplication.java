package com.ljm.springbootdemo;

import com.ljm.springbootdemo.dao.security.SysUserDao;
import com.wisely.spring_boot_starter_hello.HelloService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import java.io.UnsupportedEncodingException;


@RestController
//exclude是关掉自动加载的config，SecurityAutoConfiguration是security框架的配置类
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
@EnableCaching
@MapperScan("com.ljm.springbootdemo.dao")
public class SpringbootdemoApplication {


	@Autowired
    HelloService helloService;


	@RequestMapping("/hellostart/{id}")
	public String index(@PathVariable(value = "id") String iuu){
		System.out.println(iuu);
		return helloService.sayHello();
	}



	public static void main(String[] args) throws UnsupportedEncodingException {
		//两种启动方式效果都一样
		//SpringApplication.run(SpringbootdemoApplication.class, args);
		new SpringApplicationBuilder(SpringbootdemoApplication.class).run(args);
	}

}
