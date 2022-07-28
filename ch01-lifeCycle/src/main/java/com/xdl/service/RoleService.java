package com.xdl.service;

import org.springframework.beans.factory.InitializingBean;

public class RoleService implements InitializingBean {

    public RoleService() {
        System.out.println("无参构造器被执行.....");
    }

    /**
     * 配置文件中指定的查看初始化的方法
     */
    public void init() {
        System.out.println("init......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("方式二afterPropertiesSet........");
    }
    public void destroy() {
        System.out.println("destroy.......");
        
    }
}
