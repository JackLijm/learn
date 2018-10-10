package com.ljm.springbootdemo.domain.security;

/**
 * @ClassName SysRole
 * @Description security 角色实例bean
 * @Author lijiaming
 * @Date 2018/10/10 11:03
 * @Version 1.0
 **/
public class SysRole {
    private int id;
    private String rolename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
