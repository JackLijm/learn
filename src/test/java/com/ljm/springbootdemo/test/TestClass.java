package com.ljm.springbootdemo.test;

import junit.framework.TestCase;
import redis.clients.jedis.Jedis;

public class TestClass extends TestCase {

    public void testRedisConnection(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //设置密码
        jedis.auth("123");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行：" + jedis.ping());

    }
}
