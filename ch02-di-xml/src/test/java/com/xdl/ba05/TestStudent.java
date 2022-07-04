package com.xdl.ba05;

import com.xdl.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    @Test
    public void test01() {
        String config = "ba05/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("myStudent");
        System.out.println("student = " + student.toString());
    }
}
