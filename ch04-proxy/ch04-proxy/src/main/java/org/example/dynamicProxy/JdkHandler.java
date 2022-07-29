package org.example.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 *  每一个代理类都需要实现InvocationHandler接口
 */
public class JdkHandler implements InvocationHandler {
    // 目标对象, 不固定，创建时动态生成
    private Object target;

    public JdkHandler(Object target) {
        this.target = target;
    }

    /**
     *  newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
     *      loader: 类加载器
     *      interfaces：接口数组
     *      h: InvocationHandler的实现类
     * @return
     */
    public Object getProxy() {

        Object object = Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(),
                this
        );
        return object;
    }

    /**
     * 1、调用目标对象的方法（返回object）
     * 2、增强目标对象的行为
     * proxy：调用该方法的代理实例
     * method：目标对象的方法
     * args：  目标对象的方法所需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 用户的增强行为
        System.out.println("before......");
        // 调调用目标对象的方法
        Object object = method.invoke(this.target, args);
        // 用户的增强行为
        System.out.println("after........");
        return object;
    }
}
