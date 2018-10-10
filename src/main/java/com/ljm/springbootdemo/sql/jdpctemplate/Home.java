package com.ljm.springbootdemo.sql.jdpctemplate;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Home{

    private Integer homeid;
    private String  addr;
    private String phone;
    private String partition;

    public Home() {
    }

    public Integer getHomeid() {
        return homeid;
    }

    public void setHomeid(Integer homeid) {
        this.homeid = homeid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPartition() {
        return partition;
    }

    public void setPartition(String partition) {
        this.partition = partition;
    }
}
