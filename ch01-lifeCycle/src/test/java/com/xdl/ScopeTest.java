package com.xdl;

import com.xdl.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("scope.xml");
        //UserService userService01 = (UserService) ctx.getBean("userService");
        UserService userService02 = (UserService) ctx.getBean("userService2");
        UserService userService03 = (UserService) ctx.getBean("userService2");
        System.out.println(userService02.equals(userService03)); //true

    }
    @Test
    public void test02() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("scope.xml");
        UserService userService01 = (UserService) ctx.getBean("userService3");
        UserService userService02 = (UserService) ctx.getBean("userService3");
        System.out.println(userService01.equals(userService02)); //false
    }
}
