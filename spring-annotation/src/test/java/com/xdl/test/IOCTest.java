package com.xdl.test;

import com.xdl.bean.Person;
import com.xdl.condition.MacCondition;
import com.xdl.config.MainConfig;
import com.xdl.config.MainConfig2;
import com.xdl.config.MainConfig3;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class IOCTest {
    @Test
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person p1 = (Person) applicationContext.getBean("p1");
        Person p2 = (Person) applicationContext.getBean("p2");
        System.out.println("p1:" + p1);
        System.out.println("p2:" + p2);
        System.out.println(p1 == p2);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        /**
         * mainConfig : mainConfig也是一个组件
         *              @Component
         *              public @interface Configuration {
         * bookController
         * bookDao
         * bookService
         * person2
         */
    }

    @Test
    public void test02() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        Environment environment = applicationContext.getEnvironment();
        // 获取操作系统类型
        String property = environment.getProperty("os.name");
        System.out.println("当前操作系统" + property);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
    @Test
    public void test03() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);
        //默认获取到的时工厂bean调用getObject创建的对象
        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        Object colorFactoryBean2 = applicationContext.getBean("colorFactoryBean");
        //通过&符号获取FactoryBean本身
        Object colorFactoryBean3 = applicationContext.getBean("&colorFactoryBean");
        // colorFactoryBean的类型：class com.xdl.bean.Color
        System.out.println("colorFactoryBean的类型：" + colorFactoryBean.getClass());
        System.out.println("&colorFactoryBean的类型：" + colorFactoryBean3.getClass());
        // isSingleton()返回值为true时，两个相等，返回false时不相等
        System.out.println(colorFactoryBean == colorFactoryBean2);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

}
