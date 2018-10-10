package com.ljm.springbootdemo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    //全局的请求跳转过滤器
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/ws").setViewName("ws");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/chat").setViewName("chat");
        registry.addViewController("/security").setViewName("user");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //扫描静态资源,包括static下的所有子目录
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
