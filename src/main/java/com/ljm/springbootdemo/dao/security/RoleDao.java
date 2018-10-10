package com.ljm.springbootdemo.dao.security;

import com.ljm.springbootdemo.domain.security.SysPermission;
import com.ljm.springbootdemo.domain.security.SysRole;
import com.ljm.springbootdemo.domain.security.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleDao {

    SysUser getRoleById(@Param("id") int id);

    int updateUser(@Param("role") SysRole role);

    int insertRole(@Param("role") SysRole role);

    int deleteRoleById(@Param("id") int id);

    List<SysPermission> getPermList(String username);

    List<SysRole> getAll();

    SysUser getRoleByRoleName(String RoleName);
}
