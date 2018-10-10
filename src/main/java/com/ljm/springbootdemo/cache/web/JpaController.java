package com.ljm.springbootdemo.cache.web;

import com.ljm.springbootdemo.cache.dao.PersonRepository;
import com.ljm.springbootdemo.cache.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JpaController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name,String address,Integer age){
        Person p = personRepository.save(new Person(null,name,age,address));
        return p;
    }

    @RequestMapping("/queryByAddress")
    public List<Person> queryByAddress(String address){
        return personRepository.findByAddress(address);
    }

    @RequestMapping("/q2")
    public List<Person> q2(String name,String address){
        List<Person> person = personRepository.findByNameAndAddress(name,address);
        return person;
    }

    @RequestMapping("/q3")
    public Person q3(String name,String address){
        Person person = personRepository.withNameAndAddressQuery(name,address);
        return person;
    }

    @RequestMapping("/q4")
    public Person q4(String name,String address){
        Person person = personRepository.withNameAndAddressNamedQuery(name,address);
        return person;
    }

    @RequestMapping("/sort")
    public List<Person> sort(){
      return personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
    }

    @RequestMapping("/page")
    public Page<Person> page(){
        return personRepository.findAll(new PageRequest(1,2));
    }
}
