package com.xdl.ba03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Autowire是spring提供的注解，支持byName、byType，默认是byType
 *      如果需要byName，需要使用Qualifier
 *      require属性，默认为true，表示如果该对象不存在程序就会报错。
 *      No qualifying bean of type 'com.xdl.ba03.School' available: expected at least 1 bean which qualifies as autowire candidate
 */
@Component("myStudent3")
public class Student {

    @Value("${name}")
    private String name;
    private int age;
    // @Autowired
    // @Autowired
    // @Qualifier("mySchool")
    @Autowired(required = true)
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
