package com.xdl.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {
    //@Autowired
    private Car car;

    // @Autowired // 只有一个构造器时，该注解可以省略
    public Boss(@Autowired Car car) {
        this.car = car;
        System.out.println("Boss... 有参数构造器" + car);
    }

    //@Autowired // 标注在方法上，Spring容器创建当前对象，就会调用方法完成赋值，方法使用的参数，自定义类型的值从IOC容器中获取
    public void setCar(Car car) {
        System.out.println("setCar方法被调用：" + car);
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss [car=" + car + "]";
    }
}
