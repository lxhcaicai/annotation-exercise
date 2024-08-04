package com.lxhcaicai.annotation.cache;

import com.lxhcaicai.annotation.cache.cachemanager.CacheInterceptor;
import com.lxhcaicai.annotation.cache.service.UserService;
import com.lxhcaicai.annotation.cache.service.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class Tester {

    @Test
    public void test() {
        UserService userService = new UserServiceImpl();
        CacheInterceptor cacheInterceptor = new CacheInterceptor(userService);
        UserService proxy = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                cacheInterceptor
        );
        for (int i = 1; i <= 20; i ++) {
            System.out.println("=====" + i + "=====");
            System.out.println(proxy.getUserById(1));
        }
    }
}
