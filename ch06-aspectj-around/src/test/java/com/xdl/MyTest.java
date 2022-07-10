package com.xdl;

import com.xdl.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService service = (SomeService) ctx.getBean("someService");
        // 执行目标方法时，其实实在执行切面方法（Around）
        String ret = service.doFirst("xdl");
        System.out.println("ret调用切面方法的返回值:" + ret);
    }
}
