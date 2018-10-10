package com.ljm.springbootdemo.cache.service.impl;

import com.ljm.springbootdemo.cache.dao.PersonRepository;
import com.ljm.springbootdemo.cache.domain.Person;
import com.ljm.springbootdemo.cache.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    PersonRepository personRepository;
    @Override
    @CachePut(value = "peopele",key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id、key 为：" + p.getId() + "数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "peopele")
    public void remove(Long id) {
        System.out.println("删除了id、key 为 " + id + " 的数据缓存");
        personRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "person",key = "#person.id")
    public Person findOne(Person person) {
        Person p = personRepository.findById(person.getId()).orElse(null);
        System.out.println("为id、key 为：" + p.getId() + "数据做了缓存");
        return p;
    }
}
