package com.xdl.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的FactoryBean
 */
public class ColorFactoryBean implements FactoryBean {
    // 返回一个Color对象，这个对象会被添加到容器中
    @Override
    public Object getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject()");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
    //true表示单实例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
