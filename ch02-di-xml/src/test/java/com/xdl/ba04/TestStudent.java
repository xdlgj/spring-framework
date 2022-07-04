package com.xdl.ba04;

import com.xdl.ba04.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class TestStudent {
    @Test
    public void test01() {
        String config = "ba04/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("myStudent");
        System.out.println("student = " + student.toString());
    }
}
