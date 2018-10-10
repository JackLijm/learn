package com.ljm.springbootdemo.domain.security;

/**
 * @ClassName SysPermission
 * @Description security 权限信息
 * @Author lijiaming
 * @Date 2018/10/10 11:04
 * @Version 1.0
 **/
public class SysPermission {
    private int id;
    private String permissionname;
    private String description;

    //可以访问的url
    private String url;

    //父节点id
    private int pid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
