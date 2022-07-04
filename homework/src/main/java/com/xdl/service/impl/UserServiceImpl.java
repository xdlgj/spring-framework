package com.xdl.service.impl;

import com.xdl.dao.UserDao;
import com.xdl.domain.SysUser;
import com.xdl.service.UserService;

public class UserServiceImpl implements UserService {
    // 引用类型
    private UserDao userDao = null;
    // 使用set注入，需要set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void addUser(SysUser sysUser) {
        userDao.insertUser(sysUser);
    }

}
