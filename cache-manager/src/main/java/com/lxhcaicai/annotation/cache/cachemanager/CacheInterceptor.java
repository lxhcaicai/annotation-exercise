package com.lxhcaicai.annotation.cache.cachemanager;

import com.lxhcaicai.annotation.cache.annotation.Cacheable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CacheInterceptor implements InvocationHandler {

    private final Object target;

    public CacheInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cacheable.class)) {
            Cacheable cacheable = method.getAnnotation(Cacheable.class);
            Long expireTimes = CacheManager.getCacheTimes(method,args);
            if (expireTimes != null && expireTimes >= cacheable.expireTimes()) {
                CacheManager.remove(method,args);
            }
            Object result = CacheManager.getCacheValue(method,args);
            if (result != null) {
                System.out.println("cacheable get from cache! times = " + CacheManager.getCacheTimes(method,args));
                return result;
            } else {
                result = method.invoke(target, args);
                CacheManager.putValue(method,args,result);
                System.out.println("cacheable get from invoke method!");
                return result;
            }

        } else {
            System.out.println("get from invoke method!");
            return method.invoke(target, args);
        }
    }
}
