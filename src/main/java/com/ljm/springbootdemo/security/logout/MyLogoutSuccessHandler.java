package com.ljm.springbootdemo.security.logout;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyLogoutSuccessHandler
 * @Description 登出成功后处理器，一般用来做成功退出后的页面跳转
 * @Author lijiaming
 * @Date 2018/9/28 15:34
 * @Version 1.0
 **/
@Configuration
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("登陆成功，自定义登出后的处理器,跳转到根目录");
        response.sendRedirect("/");
    }
}
