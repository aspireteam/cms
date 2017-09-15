package com.aspire.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aspire.entity.JsonResult;

import springfox.documentation.annotations.ApiIgnore;

/**
 * 对全局异常做出处理
 * @author 丁丁
 *
 */
@ApiIgnore
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult exception(Exception e) {
		// 未知的异常做出响应
		return new JsonResult("发生了未知错误");
	}
	
	
}