package com.lxhcaicai.annotation.test;

import com.lxhcaicai.annotation.test.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static TestRunner getInstance() {
        return TestRunnerLazyHolder.INSTANCE;
    }

    private static class  TestRunnerLazyHolder {
        private static final TestRunner INSTANCE = new TestRunner();
    }

    private TestRunner() {
    }

    public void runTest(String className) throws Exception {
        // com.lxhcaicai.annotation.test.testcase.MyTest
        Class<?> testClass = Class.forName(className);
        Object testInstance = testClass.newInstance();

        // get all test methods
        List<Method> testMethods = new ArrayList<>();
        List<Method> beforeClassMethods = new ArrayList<>();
        List<Method> afterClassMethods = new ArrayList<>();
        List<Method> beforeEachMethods = new ArrayList<>();
        List<Method> afterEachMethods = new ArrayList<>();
        for (Method method: testClass.getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
            if (method.isAnnotationPresent(BeforeClass.class)) {
                beforeClassMethods.add(method);
            }
            if (method.isAnnotationPresent(AfterClass.class)) {
                afterClassMethods.add(method);
            }
            if (method.isAnnotationPresent(BeforeEach.class)) {
                beforeEachMethods.add(method);
            }
            if (method.isAnnotationPresent(AfterEach.class)) {
                afterEachMethods.add(method);
            }
        }

        // 执行测试方法
        for(Method beforeClassMethod: beforeClassMethods) {
            beforeClassMethod.invoke(testInstance);
        }
        for (Method method: testMethods) {
            for(Method beforeEachMethod: beforeEachMethods) {
                beforeEachMethod.invoke(testInstance);
            }
            method.invoke(testInstance);
            for(Method afterEachMethod: afterEachMethods) {
                afterEachMethod.invoke(testInstance);
            }
        }
        for(Method afterClassMethod: afterClassMethods) {
            afterClassMethod.invoke(testInstance);
        }
    }
}
