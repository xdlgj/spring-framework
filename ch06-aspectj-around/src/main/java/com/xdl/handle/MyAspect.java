package com.xdl.handle;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;


@Aspect
public class MyAspect {
    // 定义方法表示切面的具体功能

    /**
     * 环绕通知方法的定义：
     * 1、方法是public
     * 2、方法必须有返回值，推荐使用Object
     * 3、方法名称自定义
     * 4、方法必须有ProceedingJoinPoint参数
     *
     * @Around 属性： value切入点表达式
     * 返回值：Object表示调用目标方法希望得到执行直接（不一定是目标方法自己的返回值）
     * 参数：ProceedingJoinPoint 相当于反射中的Method
     * 作用：用于执行目标方法，等于Method.invoke()
     * public interface ProceedingJoinPoint extends JoinPoint
     * 特点：
     * 1、在目标方法的前后都能增强功能
     * 2、控制目标方法是否执行
     * 3、修改目标方法的执行结果
     */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        // 获取方法执行时的参数值
        String name = "";
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 0) {
            Object arg = args[0];
            if (arg != null) {
                name = (String) arg;
            }
        }
        Object methodReturn = null;
        System.out.println("执行了环绕通知的myAround方法,在目标方法之前，输出日志时间：" + new Date());
        // 执行目标方法，ProceedingJoinPoint表示doFirst
        if ("xdl".equals(name)) {
            methodReturn = pjp.proceed(); // method.invoke(),表示执行doFirst方法本身
        }

        System.out.println("执行了环绕通知的myAround方法,在目标方法之后，增加事务操作");
        return methodReturn;
    }
}
