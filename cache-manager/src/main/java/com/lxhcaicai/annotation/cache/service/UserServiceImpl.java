package com.lxhcaicai.annotation.cache.service;

import com.lxhcaicai.annotation.cache.entity.User;

public class UserServiceImpl implements UserService{

    static int times = 0;

    @Override
    public User getUserById(Integer id) {
        times ++;
        System.out.println("getUserById ==> times:" + times);
        return new User(id, id.toString());
    }
}
