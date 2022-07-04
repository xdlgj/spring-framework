package com.xdl.ba03;

import com.xdl.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class TestStudent {
    @Test
    public void test01() {
        String config = "ba03/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("myStudent");
        System.out.println("student = " + student.toString());

        Student student2 = (Student) ctx.getBean("myStudent2");
        System.out.println("student2 = " + student2.toString());

        Student student3 = (Student) ctx.getBean("myStudent3");
        System.out.println("student3 = " + student3.toString());

        File file = (File) ctx.getBean("file");
        System.out.println("file name is: " + file.getName());

    }
}
