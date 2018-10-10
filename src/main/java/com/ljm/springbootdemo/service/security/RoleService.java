package com.ljm.springbootdemo.service.security;

import com.ljm.springbootdemo.dao.security.RoleDao;
import com.ljm.springbootdemo.domain.security.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description 角色服务类
 * @Author lijiaming
 * @Date 2018/10/10 14:50
 * @Version 1.0
 **/
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<SysRole> getAllRoles(){
        return roleDao.getAll();
    }
}
