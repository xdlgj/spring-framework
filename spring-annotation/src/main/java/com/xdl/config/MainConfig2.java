package com.xdl.config;

import com.xdl.bean.Color;
import com.xdl.bean.Person;
import com.xdl.condition.MacCondition;
import com.xdl.condition.MyImportBeanDefinitionRegistrar;
import com.xdl.condition.MyImportSelector;
import com.xdl.condition.WinCondition;
import org.springframework.context.annotation.*;

@Configuration
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class}) // ID为全类名
public class MainConfig2 {
    /**
     * @Scope: 指定该bean的作用域
     *      singleton： 单例、默认值，当IOC容器启动的时候就会执行，并方法容器中， 一会每次回去都是同一个bean
     *      prototype： IOC容器启动的时候并不会执行，每获取一次就执行一次， 每次获取的对象都是不同的
     * @Lazy: 当Scope为singleton时，才会生效， 启动IOC容器时不会创建该对象，当第一次使用时才会创建，并且存在容器中。
     */
    @Lazy
    @Scope("singleton")
    @Bean("zhang_san")
    public Person person01() {
        System.out.println("person bean 被创建....");
        return new Person("张三", 18);
    }
    @Conditional(WinCondition.class)
    @Bean("li_si")
    public Person person02() {
        return new Person("李四", 20);
    }
}
