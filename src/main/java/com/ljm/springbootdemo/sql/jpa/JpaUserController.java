package com.ljm.springbootdemo.sql.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JpaUserController {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    //查询所有
    @GetMapping(value = "/jpaUsers")
    public List<JpaUser> userList(){
        return jpaUserRepository.findAll();
    }

    //加入
    @GetMapping(value = "/addJpaUser")
    public JpaUser jpaUserAdd(@RequestParam("name") String name,@RequestParam("password") String passoword,@RequestParam("sex") String sex){
        JpaUser jpaUser = new JpaUser();
        jpaUser.setName(name);
        jpaUser.setPassword(passoword);
        jpaUser.setSex(sex);
        return jpaUserRepository.save(jpaUser);
    }

    //通过id查询
    @GetMapping(value = "/jpaUser/{uuid}")
    public JpaUser findUserById(@PathVariable("uuid") Integer uuid){
        return jpaUserRepository.findById(uuid).get();
    }


    //通过姓名查询
    @GetMapping(value = "/findUser/{name}")
    public List<JpaUser> findUserByName(@PathVariable("name") String name){
        return jpaUserRepository.findByName(name);
    }
    //更新
    @GetMapping(value = "/updateJpaUser")
    public JpaUser userUpdate(@PathVariable("uuid") Integer uuid,@RequestParam("name") String name,@RequestParam("password") String passoword,@RequestParam("sex") String sex){
        JpaUser jpaUser = new JpaUser();
        jpaUser.setUuid(uuid);
        jpaUser.setName(name);
        jpaUser.setPassword(passoword);
        jpaUser.setSex(sex);
        return jpaUserRepository.save(jpaUser);
    }

    //删除
    @GetMapping(value = "/delJpaUser/{uuid}")
    public void delUserById(@PathVariable("uuid") Integer uuid){
        jpaUserRepository.deleteById(uuid);
    }

}
