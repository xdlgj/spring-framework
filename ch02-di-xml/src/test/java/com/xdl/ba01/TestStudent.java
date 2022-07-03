package com.xdl.ba01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestStudent {
    @Test
    public void test01() {
        String config = "ba01/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("myStudent");
        System.out.println("student = "+ student.toString());

        Date date = (Date) ctx.getBean("myDate");
        System.out.println("date==== " + date);
    }
}
