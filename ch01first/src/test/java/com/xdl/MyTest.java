package com.xdl;

import com.xdl.service.OtherService;
import com.xdl.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    //spring创建对象的时候，使用的是哪个构造方法? 无参构造方法
    @Test
    public void test1() {
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // getBean的参数可以是bean中id字符串，也可以是类
        SomeService service = ctx.getBean(SomeService.class);
        service.doSome();
    }

    /**
     * spring在什么时候创建对象的
     * 在创建spring容器对象的时候，会读取配置文件，创建文件中声明的java对象
     * 优点：
     * 获取对象的速度快，因为对象已经创建好了
     * 缺点：
     * 占内存
     */
    @Test
    public void test2() {
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    }

    /**
     * spring容器创建对象，一次创建几个？
     * 在创建容器时，会把配置文件中所有对象创建出来（spring的默认规则）
     */
    @Test
    public void test3() {
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    }

    /**
     * 获取容器中对象信息
     */
    @Test
    public void test4() {
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 获取对象数量
        int num = ctx.getBeanDefinitionCount();
        System.out.println("容器中定义对象的数量==" + num);
        //获取对象名称数组
        String names[] = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("对象名称：" + name);
        }
    }

    /**
     * 让spring创建非自定义对象
     * 有class就能创建对象
     */
    @Test
    public void test5() {
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Date date = (Date) ctx.getBean("myDate");
        System.out.println("date=== " + date);

        OtherService otherService = (OtherService) ctx.getBean("otherService");
        otherService.doOther();
    }
}
