package com.xdl.service.impl;

import com.xdl.service.SomeService;

public class SomeServiceImpl implements SomeService {

    @Override
    public String doFirst(String name) {

        System.out.println("执行业务方法doFirst"+ (1 / 0));


        return "doFirst";
    }
}
