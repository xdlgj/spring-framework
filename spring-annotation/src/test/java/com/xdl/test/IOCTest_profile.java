package com.xdl.test;


import com.xdl.bean.Yellow;
import com.xdl.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.sql.DataSource;

public class IOCTest_profile {
    //1、使用命令行动态参数: 在虚拟机参数位置添加 -Dspring.profiles.active=test
    //2、在代码中使用
    @Test
    public void test01() {
        //1、创建一个applicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //2、设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("dev");
        //3、注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4、启动刷新容器
        applicationContext.refresh();
        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        Yellow yellow = applicationContext.getBean(Yellow.class);
        System.out.println(yellow);
    }
}


