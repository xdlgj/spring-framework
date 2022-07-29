package com.xdl.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    public static void main(String[] args) {
        String config = "spring.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    }
}
