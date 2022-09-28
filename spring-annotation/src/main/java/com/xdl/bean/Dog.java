package com.xdl.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {
    public Dog() {
        System.out.println("无参构造被调用");
    }
    // 在bean创建完成并且属性赋值完成后，回调
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct.......");
    }
    // 在容器销毁bean之前回调
    @PreDestroy
    public void destroy() {
        System.out.println("@PreDestroy.........");
    }
}
