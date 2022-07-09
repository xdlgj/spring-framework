package com.xdl;

import com.xdl.service.SomeService;
import com.xdl.service.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService service = (SomeService) ctx.getBean("someService");
        service.doSome();
        // ret为doOther业务方法的的返回值
        String ret = service.doOther();
        System.out.println("ret:" + ret);
    }
    @Test
    public void test2() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService service = (SomeService) ctx.getBean("someService");
        // ret为doOther业务方法的的返回值
        Student ret = service.doStudent();
        System.out.println("ret:" + ret);
    }
}
