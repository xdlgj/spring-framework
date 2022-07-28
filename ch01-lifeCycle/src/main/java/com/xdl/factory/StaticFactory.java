package com.xdl.factory;

import com.xdl.service.RoleService;

/**
 * 定义静态工厂
 */
public class StaticFactory {
    /**
     * 定义静态方法
     */
    public static RoleService createRoleService() {
        return new RoleService();
    }
}
