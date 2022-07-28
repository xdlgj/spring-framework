package com.xdl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
    @Test
    public void test01() {
        String config = "static-factory.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    }
    @Test
    public void test02() {
        String config = "factory.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    }
}
