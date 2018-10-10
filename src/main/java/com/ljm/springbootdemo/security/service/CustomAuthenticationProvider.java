package com.ljm.springbootdemo.security.service;

import com.ljm.springbootdemo.dao.security.SysUserDao;
import com.ljm.springbootdemo.domain.security.SysPermission;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CustomAuthenticationProvider
 * @Description security真正进行用户认证操作的地方
 * @Author lijiaming
 * @Date 2018/10/10 13:18
 * @Version 1.0
 **/
public class CustomAuthenticationProvider implements AuthenticationProvider {
   private UserDetailsService userDetailService;
   private BCryptPasswordEncoder bCryptPasswordEncoder;
   private SysUserDao userDao;

    public CustomAuthenticationProvider() {
    }

    public CustomAuthenticationProvider(UserDetailsService userDetailService, BCryptPasswordEncoder bCryptPasswordEncoder, SysUserDao userDao) {
        this.userDetailService = userDetailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDao = userDao;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("--验证用户名、密码--");

        // 获取认证的用户名 & 密码
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // 认证逻辑
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        if (userDetails != null) {
            if(bCryptPasswordEncoder.matches(password,userDetails.getPassword())){
              //设置权限和角色
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                //添加权限
                List<SysPermission> permList = userDao.getPermList(username);
                for(SysPermission entry:permList){
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(String.valueOf(entry.getId()));
                    authorities.add(grantedAuthority);
                }

                // 生成令牌 这里令牌里面存入了:name,password,authorities, 当然你也可以放其他内容
                User principal = new User(username, "", authorities);
                Authentication auth = new UsernamePasswordAuthenticationToken(principal, null, authorities);
                return auth;
            }else {
                throw new BadCredentialsException("用户或密码错误");
            }
        }else{
            throw new UsernameNotFoundException("用户不存在");
        }
    }

    /**
     * 是否可以提供输入类型的认证服务
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
