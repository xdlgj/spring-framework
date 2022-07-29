package org.example.dynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibInterception implements MethodInterceptor {
    private Object target;
    public CglibInterception(Object target) {
        this.target = target;
    }
    /**
     * 获取代理对象
     * @return
     */
    public Object getProxy() {
        // 通过Enhancer对象中的create()方法生成一个类，用于生成代理对象
        Enhancer enhancer = new Enhancer();
        // 设置父类：将目标类作为代理类的父类
        enhancer.setSuperclass(this.target.getClass());
        // 设置拦截器（回调对象为本身对象）
        enhancer.setCallback(this);
        // 生成代理类对象
        Object object = enhancer.create();
        return object;
    }

    /**
     * 拦截器
     *  1、目标对象的方法调用
     *  2、行为增强
     * @param o cglib动态生成的代理类的实例
     * @param method 实体类中所调用的被代理的方法的引用
     * @param objects 参数列表
     * @param methodProxy 生成的代理类对方法的代理的引用(代理方法)
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib before......");
        // 调用目标类中的方法
        Object object = methodProxy.invoke(this.target, objects);
        System.out.println("cglib after......");
        return object;
    }
}
