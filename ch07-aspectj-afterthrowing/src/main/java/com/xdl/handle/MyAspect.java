package com.xdl.handle;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class MyAspect {
    //@Before(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    @Before(value = "myPoint()")
    public void myBefore() {
        System.out.println("前置通知...");
    }

    //@After(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    @After(value = "myPoint()")
    public void myAfter() {
        System.out.println("最终通知，总是会被执行");
    }

    /**
     * @Pointcut： 定义和管理切入点，不是通知注解
     * 使用场景：
     *      如果我们修改了doFirst方法名为doFirst2,则需要修改上面两个切面方法的切入点表达式
     *      使用了pointcut时，只需要修改myPoint即可
     */
    @Pointcut(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    private void myPoint(){
        // 不需要任何代码
    }
}
