package com.ljm.springbootdemo.domain.security;

import java.io.Serializable;

/**
 * @ClassName SysUser
 * @Description security 用户实例bean
 * @Author lijiaming
 * @Date 2018/10/10 11:02
 * @Version 1.0
 **/
public class SysUser implements Serializable{
    private int id;
    private String username;
    private String password;
    private String enabled;

    @Override
    public String toString(){
        return "id: " + id + ", username: " + username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
