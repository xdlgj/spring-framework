package com.xdl.spring;

/**
 * bean对象用来接收配置文件中bean标签对应的id和class
 */
public class Bean {
    private String id;  // bean标签的id属性值
    private String clazz; // bean标签的class属性值

    public void setId(String id) {
        this.id = id;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getId() {
        return id;
    }

    public String getClazz() {
        return clazz;
    }

    public Bean() {
    }

    public Bean(String id, String clazz) {
        this.id = id;
        this.clazz = clazz;
    }
}
