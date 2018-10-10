package com.ljm.springbootdemo.dao.security;

import com.ljm.springbootdemo.domain.security.SysPermission;
import com.ljm.springbootdemo.domain.security.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserDao {
    SysUser getUserById(@Param("id") int id);

    int updateUser(@Param("user") SysUser user);

    int insertUser(@Param("user") SysUser user);

    int deleteUserById(@Param("id") int id);

    List<SysPermission> getPermList(String username);

    SysUser getUserByUserName(String username);

    int addUser(SysUser user);

    int giveRoleToUser(@Param("userid")int userid, @Param("roleid")int roleid);
}
