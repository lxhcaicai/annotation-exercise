package com.lxhcaicai.annotation.cache.service;

import com.lxhcaicai.annotation.cache.annotation.Cacheable;
import com.lxhcaicai.annotation.cache.entity.User;

public interface UserService {
    @Cacheable(expireTimes = 10)
    public User getUserById(Integer id);
}
