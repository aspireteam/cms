package com.aspire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aspire.dao.UserDao;
import com.aspire.entity.User;
import com.aspire.service.UserService;
import com.aspire.service.exception.PasswordException;
import com.aspire.service.exception.UsernameException;
import com.aspire.service.exception.UsernameNotFindException;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

	/**
     * 用户名是否被注册检查
     * @param user 用户名
     * @return 用户信息
     */
    @Transactional(readOnly=true)
	public boolean checkIsRegistered(User user) {
    	// 验证用户名不能为空
    	if(user.getUsername()==null||user.getUsername().trim().isEmpty()){
    		throw new UsernameException("输入的用户名不能为空");
    	}
		// 判断用户名长度是否在范围内
		if (user.getUsername().length() < 3 || user.getUsername().length() > 15) {
			throw new PasswordException("输入的用户名长度不在范围内");
		}
		// 判断用户名长度是否在范围内
		if (!user.getUsername().trim().matches("^[a-zA-Z0-9_]{3,16}$")) {
			throw new UsernameException("输入的用户名有未知字符");
		}
		// 查询用户是否存在
		User userinfo = userDao.findUserByUsername(user);
		// 判断用户是否存在
		/*
		 * if(userinfo != null){ 
		 * 		throw new UsernameException("用户已经存在"); 
		 * }
		 */

		// 不存在则返回true,存在则返回true
		return userinfo != null ? true : false;
	}

    /**
     * 登录验证
     * @param user 用户名和密码
     * @return 用户信息 
     */
	@Transactional(readOnly = true)
	public User checkLogin(User user) {
		// 验证密码不能为空
		if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			throw new PasswordException("密码为空");
		}
		// 验证用户名不能为空
		if(user.getUsername()==null||user.getUsername().trim().isEmpty()){
			throw new UsernameNotFindException("用戶名为空");
		}
		// 数据库查询用户
		User userinfo=userDao.findUserByUserAndPassword(user);
		// 是否查找到用户
		if(userinfo==null){
			throw new UsernameNotFindException("用戶不存在");
		}
		// 返回用户信息
		return userinfo;
	}

    /**
     * 注册用户
     * @param user 新增用户信息
     * @return 增加用户影响值,0失败，1成功
     */
	public void addUser(User user) {
		// 判断注册的用户名是否为空
		if (user.getUsername() == null || user.getUsername().isEmpty()) {
			throw new UsernameException("用户名不能设置为空");
		}
		// 判断注册的密码是否为空
		if (user.getPassword() == null || user.getPassword().isEmpty()) {
			throw new PasswordException("密码不能设置为空");
		}
		// 判断用户名长度是否在范围内
		if (user.getUsername().length() < 3 || user.getUsername().length() > 15) {
			throw new PasswordException("输入的用户名长度不在范围内");
		}
		// 判断密码长度是否在范围内
		if (user.getPassword().length() < 3 || user.getPassword().length() > 15) {
			throw new PasswordException("输入的密码长度不在范围内");
		}
		// 注册用户
		int n = userDao.addUser(user);
		// 判断是否注册成功
		if (n < 1) {
			throw new UsernameException("用户注册失败");
		}
	}

    /**
     * 删除用户
     * @param id 用户id
     * @return 删除用户影响值，0失败，1成功
     */
	public boolean removeUser(String username) {
		return userDao.removeUser(username)>=1?true:false;
	}

}