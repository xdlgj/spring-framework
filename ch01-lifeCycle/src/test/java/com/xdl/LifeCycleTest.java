package com.xdl;

import com.xdl.service.RoleService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LifeCycleTest {
    @Test
    public void test01() {
        String config = "beans.xml";
        // ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        ctx.close();
    }
}
