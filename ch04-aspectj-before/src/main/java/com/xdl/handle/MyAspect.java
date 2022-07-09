package com.xdl.handle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * @Aspect:切面类的注解 位置：在某个类的上面
 * 作用：表示当前类是一个切面类（表示切面功能的类）
 */
@Aspect
public class MyAspect {
    // 定义方法表示切面的具体功能

    /**
     * 前置通知方法的定义
     * 1、方法是public
     * 2、返回值是void
     * 3、方法名称自定义
     * 4、方法可以有参数，如果有是JoinPoint（连接点），也可以没有
     *
     * @Before： 前置通知
     * 属性：value表示切入点表达式，表示切面执行位置
     * 位置：在方法上面
     * 特点：
     * 1、执行时间：在目标方法之前先执行
     * 2、不会影响目标方法的执行
     * 3、不会修改目标方法的执行效果
     */
//    @Before(value = "execution(public void com.xdl.service.impl.SomeServiceImpl.doSome(String, Integer))")
//    public void myBefore() {
//        // 切面代码
//        System.out.println("前置通知，切面功能，在目标方法之前先执行：" + new Date());
//    }
//    @Before(value = "execution(void com.xdl.service.impl.SomeServiceImpl.doSome(String, Integer))")
//    public void myBefore() {
//        // 切面代码
//        System.out.println("==前置通知，切面功能，在目标方法之前先执行：" + new Date());
//    }
    // 两个前置通知都会再目标方法之前执行，但是哪个先执行无法确定，实际项目中也不会这样写
    @Before(value = "execution(* *..SomeServiceImpl.do*(..))")
    public void myBefore() {
        // 切面代码
        System.out.println("==前置通知，切面功能，在目标方法之前先执行：" + new Date());
    }

    /**
     * 切面类中的通知方法可以有参数
     * 必须是 JoinPoint
     * JoinPoint表示正在执行的业务方法，相当于反射中的 Method
     * 使用要求必须是参数列表的第一个
     * 作用：
     * 获取方法执行时的信息，例如方法名称，参数聚合
     */
    @Before(value = "execution(* *..SomeServiceImpl.do*(..))")
    void myBefore2(JoinPoint joinPoint) {
        System.out.println("前置通知中获取目标方法的定义：" + joinPoint.getSignature());
        System.out.println("前置通知中获取目标方法名称：" + joinPoint.getSignature().getName());
        // 获取参数
        Object[] args = joinPoint.getArgs();
        for(Object arg: args) {
            System.out.println(arg);
        }
        // 切面代码
        System.out.println("前置通知2，切面功能，在目标方法之前先执行：" + new Date());
    }
}
