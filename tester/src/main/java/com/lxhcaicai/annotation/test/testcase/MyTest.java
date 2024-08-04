package com.lxhcaicai.annotation.test.testcase;

import com.lxhcaicai.annotation.test.annotation.*;

public class MyTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class!");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class!");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after each!");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("before each!");
    }


    @Test
    public void test1() {
        System.out.println("this is a test1");
    }

    @Test
    public void test2() {
        System.out.println("this is a test2");
    }


}
