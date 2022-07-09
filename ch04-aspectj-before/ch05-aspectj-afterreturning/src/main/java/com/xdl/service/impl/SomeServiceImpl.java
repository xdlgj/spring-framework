package com.xdl.service.impl;

import com.xdl.service.SomeService;
import com.xdl.service.Student;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("doSome方法业务方法执行");
    }

    @Override
    public String doOther() {
        System.out.println("doOther业务方法执行");
        return "abc";
    }
    @Override
    public Student doStudent() {
        System.out.println("doStudent业务方法执行");
        return new Student("xdl", 18);
    }
}
