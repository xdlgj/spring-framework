package com.xdl.service;

import com.xdl.handle.MyAspect;
import com.xdl.service.impl.SomeServiceImpl;

/**
 * 调用ServiceProxy类方法时，调用真正的目标方法，调用目标方法的时候增加了一些功能
 * ServiceProxy叫做代理，代理对目标的操作，
 * 创建代理，可以完成对目标方法的调用增加新的功能，保持目标方法内容不变
 *
 * 框架会生成类似于这样的代理存放再内存中。
 */
public class ServiceProxy implements SomeService {
    // 正真的目标
    SomeService target = new SomeServiceImpl();
    // 切面类
    MyAspect myAspect = new MyAspect();
    @Override
    public void doSome(String name, Integer age){
        myAspect.myBefore();
        target.doSome("gj", 18);
    }
    @Override
    public void doOther() {
        System.out.println("doOther");
    }
}
