package com.xdl.handle;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class MyAspect {
    // 定义方法表示切面的具体功能

    /**
     * 最终通知方法的定义：
     * 1、方法是public
     * 2、方法没有有返回值
     * 3、方法名称自定义
     * 4、方法没有参数
     *
     * @After
     *      属性： value切入点表达式
     * 特点：
     * 1、在目标方法之后执行
     * 2、总是会被执行
     * 3、可以用来做程序最后的收尾工作，例如清楚临时数据，变量，清理内存
     * 执行通知执行
     * try {
     *     SomeServiceImpl.doFirst();
     * } finally {
     *     myAfter();
     * }
     */
    @After(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public void myAfter() {
        System.out.println("最终通知，总是会被执行");
    }
}
