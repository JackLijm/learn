package com.ljm.springbootdemo.conditionAnno;

public class WindowsService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
