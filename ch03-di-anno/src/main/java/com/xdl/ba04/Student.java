package com.xdl.ba04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Resources是jdk提供的，给引用类型赋值，支持byName、byType，默认是byName;spring支持这个注解的使用。
 * 位置：
 *      1、在属性定义的上面，无需set方法，推荐使用
 *      2、在set方法的上面
 * 默认使用byName如果byName没有找到则使用byType， 如果使用name属性则只会按照byName
 * 说明：
 *     Resource使用jdk1.8自带的注解，高于1.8版本没有这个注解。需要手动添加依赖
 * <dependency>
 *     <groupId>javax.annotation</groupId>
 *     <artifactId>javax.annotation-api</artifactId>
 *     <version>1.3.2</version>
 * </dependency>
 */
@Component("myStudent4")
public class Student {

    @Value("${name}")
    private String name;
    private int age;

    @Resource(name = "mySchool4")
    private School school;

    @Value("18")
    public void setAge(int age) {
        System.out.println("setAge 执行" + age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
