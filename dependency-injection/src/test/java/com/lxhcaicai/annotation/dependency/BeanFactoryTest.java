package com.lxhcaicai.annotation.dependency;

import com.lxhcaicai.annotation.dependency.entity.User;
import com.lxhcaicai.annotation.dependency.factory.BeanFactory;
import org.junit.jupiter.api.Test;

public class BeanFactoryTest {

    @Test
    public void test() {
        BeanFactory beanFactory = new BeanFactory();
        User user = beanFactory.createBean(User.class);
        user.sayHello();
    }
}
