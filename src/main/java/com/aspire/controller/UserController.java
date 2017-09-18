package com.aspire.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.entity.JsonResult;
import com.aspire.entity.User;
import com.aspire.service.UserService;
import com.aspire.service.exception.PasswordException;
import com.aspire.service.exception.UsernameException;
import com.aspire.service.exception.UsernameNotFindException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * User控制器
 * @author 丁丁
 *
 */
@RestController
@RequestMapping("/user")
@Api(tags="用户管理接口")
public class UserController {

	@Autowired
	UserService userService;

	// —————————————————— 用户基本操作接口 ——————————————————
	// 登录验证
	@ApiOperation(value = "登录验证接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult loginUser(
			@ApiParam("用户名") @RequestParam("username") String username,
			@ApiParam("密码") @RequestParam("password") String password,
			@ApiParam("是否记住用户") @RequestParam("rememberPassword") Integer rememberPassword,
			HttpServletRequest request,
			HttpServletResponse response) {
		// 将值存入实体类
		User currentUser=new User();
		currentUser.setUsername(username);
		currentUser.setPassword(password);
		// 用户名、密码检测
		User userinfo = userService.checkLogin(currentUser);
		// 通过检测,将用户信息存入session
		request.getSession().setAttribute("user_session", userinfo);
		// 如果用户勾选记住密码功能,则给用户返回一个记录账户、密码的Cookie
		if (rememberPassword == 1) {
			// 设置Cookie存储值
			String loginInfo = userinfo.getUsername()+"#"+userinfo.getPassword();
			// 新建Cookie对象，用户名、将密码存入Cookie
			Cookie userCookie = new Cookie("loginInfo", loginInfo);
			// 设置存活期为一星期7*24*60*60秒
			userCookie.setMaxAge(7 * 24 * 60 * 60);
			userCookie.setPath("/");
			response.addCookie(userCookie);
		}
		// 返回JSON信息
		return new JsonResult(userinfo);
	}

	// 注册用户
	@ApiOperation(value = "注册用户接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE
			,notes="注册成功=true,注册失败=false")
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult RegistUser(
			@ApiParam("用户名") @RequestParam("username")String username,
			@ApiParam("密码") @RequestParam("password") String password,
			@ApiParam("姓名") @RequestParam("name") String name) {
		// 将值存入实体类
		User currentUser=new User();
		currentUser.setUsername(username);
		currentUser.setPassword(password);
		currentUser.setName(name);
		// 检车用户名是否存在(存在=true,不存在=false)
		boolean checkResult = userService.checkIsRegistered(currentUser);
		// 返回信息(成功=true,失败false)
		Map<String, Object> message = new HashMap<String, Object>();
		message.put("message",checkResult?"true":"false");	
		return new JsonResult(message);
	}

	// 检查用户是否存在
	@ApiOperation(value = "检查用户是否存在接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/checkuser", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult checkUserIsExist(@RequestParam("username") String username) {
		// 将值存入实体类
		User currentUser=new User();
		currentUser.setUsername(username);
		// 检车用户名是否存在
		boolean checkResult = userService.checkIsRegistered(currentUser);
		// 返回消息(可以注册=true,不可以注册=false)
		Map<String, Object> message = new HashMap<String, Object>();
		message.put("message", checkResult?"true":"false");
		return new JsonResult(message);
	}
	
	// 删除用户
	@RequestMapping(value = "/removeuser", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult removeUser(@RequestParam("username") String username) {
		// 删除用户
		boolean checkResult = userService.removeUser(username);
		// 返回消息(删除成功=true,删除失败=false)
		Map<String, Object> message = new HashMap<String, Object>();
		message.put("message", checkResult?"true":"false");
		return new JsonResult(message);
	}
	
	// —————————————————— 用户异常处理 ——————————————————

	// 用户异常
	@ApiIgnore
	@ExceptionHandler(UsernameException.class)
	public JsonResult UsernameExceptionHandler(UsernameException e) {
		return new JsonResult(2, e);
	}

	// 用户未查找到异常
	@ApiIgnore
	@ExceptionHandler(UsernameNotFindException.class)
	public JsonResult UsernameNotFindExceptionHandler(UsernameNotFindException e) {
		return new JsonResult(3, e);
	}

	// 密码异常
	@ApiIgnore
	@ExceptionHandler(PasswordException.class)
	public JsonResult PasswordExceptionHandler(PasswordException e) {
		return new JsonResult(4, e);
	}

}