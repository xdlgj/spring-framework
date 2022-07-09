package com.xdl;

import com.xdl.service.ServiceProxy;
import com.xdl.service.SomeService;
import com.xdl.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) ctx.getBean("someService");
        // 没有加入代理的处理：目标方法执行时没有切面功能；service对象没有被改变
        // someService:com.xdl.service.impl.SomeServiceImpl
        System.out.println("someService:" + someService.getClass().getName());
        someService.doSome("xdl", 18);
    }
    @Test
    public void test02() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) ctx.getBean("someService");
        // 加入代理之后：目标方法执行时具有切面功能；service对象也发生了变法
        // someService:com.sun.proxy.$Proxy7
        System.out.println("someService:" + someService.getClass().getName());
        someService.doSome("xdl", 18);
    }
    @Test
    public void test03() {
        ServiceProxy serviceProxy = new ServiceProxy();
        serviceProxy.doSome("xdl", 18);
    }

    @Test
    public void test04() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 不能使用SomeServiceImpl类
        SomeService someService = (SomeService) ctx.getBean("someService");
        someService.doSome("xdl", 18);
        someService.doOther();
    }
}
