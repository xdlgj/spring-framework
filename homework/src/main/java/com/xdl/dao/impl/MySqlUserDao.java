package com.xdl.dao.impl;

import com.xdl.dao.UserDao;
import com.xdl.domain.SysUser;

public class MySqlUserDao implements UserDao {

    @Override
    public void insertUser(SysUser sysUser) {
        System.out.println("使用了dao执行insert操作");
    }
}
