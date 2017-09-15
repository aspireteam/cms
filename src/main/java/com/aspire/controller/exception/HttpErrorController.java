package com.aspire.controller.exception;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aspire.entity.JsonResult;

import springfox.documentation.annotations.ApiIgnore;

/**
 * 对404错误做出处理
 * @author 丁丁
 *
 */
@ApiIgnore
@Controller
public class HttpErrorController implements ErrorController {

	private static final String ERROR_PATH = "/error";

	@RequestMapping(value = ERROR_PATH)
	@ResponseBody
	public JsonResult handleError() {
		// 对404错误做出响应
		return new JsonResult("该页面不存在");
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
