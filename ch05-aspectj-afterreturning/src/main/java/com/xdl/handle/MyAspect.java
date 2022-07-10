package com.xdl.handle;

import com.xdl.service.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;

/**
 * @AfterReturning 后置通知，在目标方法执行完成后执行
 * 属性：
 *      value: 切入点表达式
 *      returning: 目标方法的返回值，值与被修饰的切面方法的形参相同。
 * myAfterReturning： 切面方法
 * 属性：
 *      JoinPoint: 连接点，必须在形参的第一个位置
 *      Object：业务方法的返回值
 */
@Aspect
public class MyAspect {
    @AfterReturning(
            value = "execution(* *..SomeServiceImpl.do*(..))",
            returning = "res"
    )
    public String myAfterReturning(JoinPoint jp, Object res) {
         //当业务方法的返回值为引用类型时，在切面中修改该值会影响业务方法的返回值
        if (res instanceof Student) {
            ((Student) res).setName("gj");
        }
        System.out.println("后置通知执行，目标方法的返回值：" + res);
        System.out.println("后置通知执行，目标方法名称：" + jp.getSignature().getName());
        return "hello AfterReturning";
    }

}
