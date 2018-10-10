package com.ljm.springbootdemo.controller;

import com.ljm.springbootdemo.domain.security.SysUser;
import com.ljm.springbootdemo.service.security.RoleService;
import com.ljm.springbootdemo.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName SecurityController
 * @Description security的所有操作包括增加权限等
 * @Author lijiaming
 * @Date 2018/10/10 14:57
 * @Version 1.0
 **/
@RestController
public class SecurityController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;


    @RequestMapping("getAllRoles")
    public List getAllRoles(){
        List roles = roleService.getAllRoles();
        return roles;
    }

    @RequestMapping("adduser")
    public int addUser(@ModelAttribute SysUser user, @RequestParam int roleid){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userService.addUserAndRole(user,roleid);
    }
}
