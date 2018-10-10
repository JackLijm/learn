package com.ljm.springbootdemo.security.service;

import com.ljm.springbootdemo.dao.security.SysUserDao;
import com.ljm.springbootdemo.domain.security.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

/**
 * @ClassName UserDetailServiceImpl
 * @Description TODO
 * @Author lijiaming
 * @Date 2018/10/10 13:31
 * @Version 1.0
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private SysUserDao userDao;

    public UserDetailServiceImpl(SysUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = userDao.getUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
    }

}
