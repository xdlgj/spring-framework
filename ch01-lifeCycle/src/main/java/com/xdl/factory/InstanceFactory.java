package com.xdl.factory;

import com.xdl.service.RoleService;


public class InstanceFactory {
    /**
     * 该方法不能是静态方法
     * @return
     */
    public RoleService createRoleService() {
        return new RoleService();
    }
}
