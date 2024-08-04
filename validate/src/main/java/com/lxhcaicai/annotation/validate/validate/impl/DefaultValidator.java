package com.lxhcaicai.annotation.validate.validate.impl;

import com.lxhcaicai.annotation.validate.annotation.Length;
import com.lxhcaicai.annotation.validate.annotation.NotNull;
import com.lxhcaicai.annotation.validate.validate.Validator;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DefaultValidator implements Validator {
    @Override
    public <T> Map<String, String> validate(T object) {
        Map<String,String> errors = new HashMap<>();
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(NotNull.class)) {
                NotNull notNull = field.getAnnotation(NotNull.class);
                Object value = null;

                try {
                    value = field.get(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (value == null) {
                    errors.put(String.valueOf(UUID.randomUUID()),field.getName() +" "+  notNull.message());
                }
            }

            if (field.isAnnotationPresent(Length.class)) {
                Length lengthAnno = field.getAnnotation(Length.class);
                String value = null;

                try {
                     value = (String) field.get(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (value.length() < lengthAnno.min() || value.length() > lengthAnno.max()) {
                    errors.put(String.valueOf(UUID.randomUUID()),field.getName() + " out of size min = " + lengthAnno.min() + " max = " + lengthAnno.max() + " but now length is " + value.length());
                }
            }
        }
        return errors;
    }
}
