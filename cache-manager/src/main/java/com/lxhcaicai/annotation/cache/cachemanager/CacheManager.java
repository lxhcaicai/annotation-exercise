package com.lxhcaicai.annotation.cache.cachemanager;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager {
    private static final ConcurrentHashMap<String,Object> cache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String,Long> cacheTime = new ConcurrentHashMap<>();

    public static Long getCacheTimes(Method method, Object[] args) {
        String key = generateKey(method, args);
        return cacheTime.get(key);
    }

    public static Object getCacheValue(Method method, Object[] args) {
        String key = generateKey(method, args);
        Object obj = cache.get(key);
        if (obj != null) {
            cacheTime.put(key, cacheTime.get(key) + 1);
        }
        return obj;
    }

    public static void putValue(Method method, Object[] args, Object result) {
        String key = generateKey(method, args);
        cache.put(key, result);
        cacheTime.put(key, 0L);
    }

    public static void remove(Method method, Object[] args) {
        String key = generateKey(method, args);
        cache.remove(key);
        cacheTime.remove(key);
    }

    private static String generateKey(Method method, Object[] args) {
        StringBuilder sb = new StringBuilder(method.getName());
        for(Object obj: args) {
            sb.append(obj.hashCode());
        }
        return String.valueOf(sb);
    }

}
