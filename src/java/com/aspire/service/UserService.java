package com.aspire.service;

import com.aspire.entity.User;

public interface UserService {

    // 注册检查
    public boolean checkIsRegistered(User user);
    
    // 登录检查
    public User checkLogin(User user);
    
    // 增加用户
    public void addUser(User user);
    
    // 移出用户
    public boolean removeUser(String username);

}