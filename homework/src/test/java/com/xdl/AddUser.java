package com.xdl;

import com.xdl.domain.SysUser;
import com.xdl.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddUser {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        UserServiceImpl userService = (UserServiceImpl) ctx.getBean("userService");

        SysUser sysUser = new SysUser();
        sysUser.setName("xdl");
        sysUser.setAge(18);
        userService.addUser(sysUser);
    }
}
