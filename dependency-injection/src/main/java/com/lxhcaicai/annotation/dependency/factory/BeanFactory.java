package com.lxhcaicai.annotation.dependency.factory;

import com.lxhcaicai.annotation.dependency.annotation.Autowired;

import java.lang.reflect.Field;

public class BeanFactory {
    public <T> T createBean(Class<T> clazz) {

        try {
            T bean = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field: fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    String filedName = field.getName();
                    String value = "qwq";
                    field.setAccessible(true);
                    field.set(bean, value);
                }
            }
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
