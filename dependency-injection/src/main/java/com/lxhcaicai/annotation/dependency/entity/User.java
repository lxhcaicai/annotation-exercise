package com.lxhcaicai.annotation.dependency.entity;

import com.lxhcaicai.annotation.dependency.annotation.Autowired;

public class User {

    @Autowired
    private String name;

    public void sayHello() {
        System.out.println("hello " + name);
    }

}
