package com.ljm.springbootdemo.security;

import com.ljm.springbootdemo.dao.security.SysUserDao;
import com.ljm.springbootdemo.security.permission.MyAccessDecisionManager;
import com.ljm.springbootdemo.security.permission.MyFilterSecurityInterceptor;
import com.ljm.springbootdemo.security.permission.MySecurityMetadataSource;
import com.ljm.springbootdemo.security.service.CustomAuthenticationProvider;
import org.apache.catalina.servlet4preview.GenericFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity()
public class MvcSequrityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private LogoutHandler logoutHandler;

    @Qualifier("druibDataSource")
    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Autowired
    public FilterInvocationSecurityMetadataSource mySecurityMetadataSource;
    @Autowired
    public AccessDecisionManager myAccessDecisionManager;
    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                //设置对 / 和 /login 不拦截 ,antMatchers按照定义顺序进行过滤
                .antMatchers("/","/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    //登陆访问路径为login
                    .loginPage("/login")
                     //成功后转向/chat路径
                    .defaultSuccessUrl("/logout")
                    .permitAll()
                .and()
                .logout()
                    .logoutUrl("/my/logout")
                    .logoutSuccessUrl("/")
//                如果配置了logoutSuccessHandler，上面的logoutSuccessUrl就没用作用了
                    .logoutSuccessHandler(logoutSuccessHandler)
//                让session失效
                    .invalidateHttpSession(true)
//                   增加自定义登出的处理器，SecurityContextLogoutHandler这个处理器总会在最后进行
                    .addLogoutHandler(logoutHandler)
//                指定登出时要删除的cookie名字
                    .deleteCookies("username","pwd")
                    .permitAll()
                .and()
                //在默认的FilterSecurityInterceptor前面再加个自定义的拦截器
                .addFilterBefore(myFilterSecurityInterceptor,FilterSecurityInterceptor.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //分配允许访问的用户名密码 ,由于security5 增加了很多密码算法，所以需要随意指定一下密码算法，具体开发需要看
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("wyf").password(new BCryptPasswordEncoder().encode("wyf")).roles("USER")
//                .and()
//                .withUser("wisely").password(new BCryptPasswordEncoder().encode("wisely")).roles("USER")
//                .and()
//                .withUser("123").password(new BCryptPasswordEncoder().encode("123")).roles("USER");
        //通过数据库验证
//        auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema();

        //使用自定义身份验证组件
        auth.authenticationProvider(new CustomAuthenticationProvider(userDetailsService,bCryptPasswordEncoder,sysUserDao));

    }

    @Override
    public void configure(WebSecurity webSecurity){
        //不拦截路径下的资源
        webSecurity.ignoring().antMatchers("/resources/static/**");
    }
}
