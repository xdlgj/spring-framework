package com.xdl.config;

import com.xdl.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配：
 *      Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 * 1、@Autowired：自动注入
 *      1、默认优先按照类型去容器中找对应的组件：applicationContext.getBean(BookDao.class);
 *      2、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找.
 *      3、@Qualifier("bookDao2"):使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 *      4、自动装配默认一定要将属性赋值，没有就会报错。可以使用@Autowired(required = false)修改默认情况，这样容器中没有该组件，就是赋值为null
 *      5、@Primary: 让Spring进行自动装的时候，默认使用首选的bean，也可以继续使用@Qualifier执行需要装配的bean的名字
 *      BookService {
 *          @Autowired
 *          private BookDao bookDao
 *      }
 */
@Configuration
@ComponentScan({"com.xdl.service", "com.xdl.controller", "com.xdl.dao", "com.xdl.bean"})
public class MainConfigOfAutowire {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
}
