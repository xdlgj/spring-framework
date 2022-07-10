package com.xdl.handle;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;


@Aspect
public class MyAspect {
    // 定义方法表示切面的具体功能

    /**
     * 异常通知方法的定义：
     * 1、方法是public
     * 2、方法没有有返回值
     * 3、方法名称自定义
     * 4、方法有参数Exception
     *
     * @AfterThrowing
     *      属性： value切入点表达式
     *            Exception自定义变量，表示目标方法抛出的异常，必须与通知方法形参名相同
     * 特点：
     * 1、在目标方法抛出异常后执行，没有异常不执行,  或者异常不捕获也不会执行
     * 2、能获取表目标方法的异常信息
     * 3、不是异常处理程序，可以得到发生异常的通知，可以发送邮件、短信通知开发人员，
     *      看做是目标方法的监控
     * 执行通知执行
     * try {
     *     SomeServiceImpl.doFirst();
     * } catch(Exception e) {
     *     myAfterThrowing(e);
     * }
     */
    @AfterThrowing(value = "execution(* *..SomeServiceImpl.doFirst(..))", throwing = "exception")
    public void myAfterThrowing(Exception exception) {
        System.out.println("异常通知方法执行...， 异常原因是:" + exception.getMessage());
        /*
            异常发生可以做
            1、记录异常的时间，位置等信息
            2、发送邮件、短信通知开发人员
         */
    }
}
