package com.ljm.springbootdemo.security.logout;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyLogoutHandler
 * @Description 自定义的登出操作执行器
 * @Author lijiaming
 * @Date 2018/9/28 15:43
 * @Version 1.0
 **/
@Configuration
public class MyLogoutHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        System.out.println("自定义登出操作执行器");
    }
}
