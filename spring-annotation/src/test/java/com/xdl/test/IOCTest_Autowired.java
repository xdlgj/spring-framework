package com.xdl.test;

import com.xdl.config.MainConfigOfAutowire;
import com.xdl.dao.BookDao;
import com.xdl.service.BookService;
import com.xdl.service.BookService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {
    @Test
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowire.class);
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        System.out.println(bookService);
        BookDao bookDao = (BookDao) applicationContext.getBean("bookDao");
        System.out.println(bookDao);
        System.out.println("==========所有组件==========");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
    @Test
    public void test02() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowire.class);
        BookService2 bookService2 = (BookService2) applicationContext.getBean("bookService2");
        System.out.println(bookService2);

    }
}


