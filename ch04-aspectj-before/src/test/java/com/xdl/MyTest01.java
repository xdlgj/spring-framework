package com.xdl;

import com.xdl.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx =  new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) ctx.getBean("someService");
        someService.doSome("xdl", 18);
    }
}
