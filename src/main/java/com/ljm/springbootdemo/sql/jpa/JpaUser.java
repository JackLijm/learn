package com.ljm.springbootdemo.sql.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class JpaUser {
    @Id
    @GeneratedValue
    private Integer uuid;
    private String name;
    private String password;
    private String sex;

    public JpaUser() {
    }

    public Integer getUuid() {
        return uuid;
    }

    public JpaUser setUuid(Integer uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getName() {
        return name;
    }

    public JpaUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public JpaUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public JpaUser setSex(String sex) {
        this.sex = sex;
        return this;
    }
}
