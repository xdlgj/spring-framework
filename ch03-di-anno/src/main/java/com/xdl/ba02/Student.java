package com.xdl.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {
    /**
     * 简单类型属性赋值：@Value
     *
     * @Value： 简单类型属性赋值
     * 属性：value简单类型属性赋值
     * 位置：
     * 1、在属性定义上面，无需set方法，推荐使用
     * 2、在set方法的上面
     */
    //@Value("xdl")
    //使用外部属性文件中的数据 语法@Value("${key}")
    @Value("${name}")
    private String name;
    private int age;

    public Student() {
        System.out.println("Student 的无参构造");
    }

    public void setName(String name) {
        this.name = name;
    }

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
                '}';
    }
}
