package com.ljm.springbootdemo.cache.service;

import com.ljm.springbootdemo.cache.domain.Person;

public interface DemoService {
    public Person save(Person person);
    public void remove(Long id);
    public Person findOne(Person person);
}
