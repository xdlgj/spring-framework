package com.xdl.spring;

/**
 * Bean工厂接口定义
 */
public interface Factory {
    // 通过id属性值获取对象
    public Object getBean(String id);
}
