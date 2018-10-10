package com.ljm.springbootdemo.sql.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<JpaUser,Integer>{
    //通过名字来查询
    public List<JpaUser> findByName(String name);
}
