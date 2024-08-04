package com.lxhcaicai.annotation.test;


import org.junit.jupiter.api.Test;

public class Tester {
    @Test
    public void tester() throws Exception {
        TestRunner testRunner = TestRunner.getInstance();
        testRunner.runTest("com.lxhcaicai.annotation.test.testcase.MyTest");
    }
}
