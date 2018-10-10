package com.ljm.springbootdemo.conditionAnno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConCig {
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsService(){
        return  new WindowsService();
    }
    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxService(){
        return new LinuxService();
    }
}
