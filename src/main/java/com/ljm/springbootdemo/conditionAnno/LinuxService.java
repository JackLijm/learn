package com.ljm.springbootdemo.conditionAnno;

public class LinuxService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
