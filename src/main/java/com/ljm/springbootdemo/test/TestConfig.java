package com.ljm.springbootdemo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfig {
    @Bean
    @Profile("dev")
    public TestBean devTestBean(){
        return  new TestBean("i am a dev TestBean");
    }

    @Bean
    @Profile("prod")
    public TestBean prodTestBean(){
        return new TestBean("i am a prod TestBean");
    }
}
