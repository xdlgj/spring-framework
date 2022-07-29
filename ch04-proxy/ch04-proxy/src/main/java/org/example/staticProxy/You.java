package org.example.staticProxy;

/**
 * 静态代理的目标角色 - 实现行为
 */
public class You implements Marry{

    @Override
    public void toMarry() {
        System.out.println("我要结婚了....");
    }
}
