package com.aspire.dao;

import org.apache.ibatis.annotations.Mapper;

import com.aspire.entity.User;

@Mapper
public interface UserDao {

	/**
	 * 
	 * @param user 用户名
	 * @return 根据用户名查询，用于注册检查
	 */
    public User findUserByUsername(User user);
    
    /**
     * 
     * @param user 用户名
     * @return 根据用户名和密码查询，用作登录检查
     */
    public User findUserByUserAndPassword(User user);
    
    /**
     * @param user 根据设定的用户名和密码添加用户
     * @return 
     */
    public Integer addUser(User user);
    
    /**
     * 根据用户名删除用户
     * @param user
     */
    public Integer removeUser(String username);
    
}