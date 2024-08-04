package com.lxhcaicai.annotation.validate;

import com.lxhcaicai.annotation.validate.entity.User;
import com.lxhcaicai.annotation.validate.validate.Validator;
import com.lxhcaicai.annotation.validate.validate.impl.DefaultValidator;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class Tester {
    @Test
    public void test() {
        Validator validator = new DefaultValidator();
        User user = new User("qweqwe");
        Map<String,String> errors = validator.validate(user);
        if (!errors.isEmpty()) {
            errors.entrySet().stream()
                    .forEach(entry -> {
                        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                    });
        }
    }

    @Test
    public void test2() {
        Validator validator = new DefaultValidator();
        User user = new User("lxhcaicai","qweqw");
        Map<String,String> errors = validator.validate(user);
        if (!errors.isEmpty()) {
            errors.entrySet().stream()
                    .forEach(entry -> {
                        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                    });
        }
    }
}
