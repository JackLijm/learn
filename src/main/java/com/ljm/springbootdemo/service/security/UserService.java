package com.ljm.springbootdemo.service.security;

import com.ljm.springbootdemo.dao.security.SysUserDao;
import com.ljm.springbootdemo.domain.security.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private SysUserDao userDao;

    /**
     * 增加用户并赋予角色
     * @param user
     * @param roleid
     * @return
     */
    public int addUserAndRole(SysUser user, int roleid) {
        userDao.addUser(user);
        return userDao.giveRoleToUser(user.getId(), roleid);

    }
}
