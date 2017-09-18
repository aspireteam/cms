package com.aspire.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.entity.Content;
import com.aspire.entity.JsonResult;
import com.aspire.service.ContentService;
import com.aspire.service.exception.AddTitleException;
import com.aspire.service.exception.RemoveTitleException;
import com.aspire.service.exception.UpdateTitleException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 一级标题控制器
 * @author 丁丁
 *
 */
@RestController
@RequestMapping("/content")
@Api(tags="内容管理接口")
public class ContentController {

	@Autowired
	ContentService contentService;

	// —————————————————— 标题基本操作接口 ——————————————————
	// 查询全部主体内容
	@ApiOperation(value = "获取全部内容接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult getBodyAll(){
		List<Content> contentList = contentService.findAll();
		// 成功返回标题JSON信息
		return new JsonResult(contentList);
	}
	
	// 根据内容ID查询内容
	@ApiOperation(value = "根据内容ID获取内容接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/getBodyByContentId", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult getBodyByContentId(
		    @ApiParam("内容ID号") @RequestParam("contentId")Integer contentId){
		Content contentList = contentService.findBodyByContentId(contentId);
		// 成功返回标题JSON信息
		return new JsonResult(contentList);
	}
	
	// 根据三级标题ID查询内容
	@ApiOperation(value = "根据三级标题ID获取内容接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/getBodyByTitleId", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult getBodyByTitleId(
		    @ApiParam("三级标题ID号") @RequestParam("titleId")Integer titleId){
		Content contentList = contentService.findBodyByLevelThreeId(titleId);
		// 成功返回标题JSON信息
		return new JsonResult(contentList);
	}
	
	// 搜索内容
	@ApiOperation(value = "搜索内容接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/searchBody", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult searchBody(
		    @ApiParam("要搜索的内容") @RequestParam("body")String body){
		// 判断level值
		List<Content> contentList=contentService.searchContent(body);
		// 成功返回标题JSON信息
		return new JsonResult(contentList);	
	}
	
	// 增加主体内容
	@ApiOperation(value = "增加内容接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/addBody", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult addBody(
			@ApiParam("三级标题ID") @RequestParam("titleId")Integer titleId,
		    @ApiParam("要增加的内容") @RequestParam("body")String body){
		// 增加标题
		contentService.addBody(titleId, body);
		// 返回成功状态
		return new JsonResult(0,"增加成功");
	}
	
	// 更新内容
	@ApiOperation(value = "更新内容接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/updateBody", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult updateBody(
		    @ApiParam("要更新的内容ID") @RequestParam("contentId")Integer contentId,
		    @ApiParam("要更新的内容") @RequestParam("body")String body){
		// 增加标题
		contentService.updateBody(contentId, body);
		// 返回成功状态
		return new JsonResult(JsonResult.SUCCESS,"更新成功");
	}
	
	// 删除内容
	@ApiOperation(value = "删除内容接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	@ResponseBody
	public JsonResult removeBody(
			@ApiParam("删除内容ID") @RequestParam("contenId")Integer contenId){
		contentService.removeBody(contenId);
		// 返回成功状态
		return new JsonResult(JsonResult.SUCCESS,"删除成功");	
	}
	
	
	
	// —————————————————— 标题异常处理 ——————————————————
	// 增加标题异常
	@ApiIgnore
	@ExceptionHandler(AddTitleException.class)
	public JsonResult UsernameNotFindExceptionHandler(AddTitleException e) {
		return new JsonResult(5, e);
	}

	// 更新标题异常
	@ApiIgnore
	@ExceptionHandler(UpdateTitleException.class)
	public JsonResult UsernameExceptionHandler(UpdateTitleException e) {
		return new JsonResult(6, e);
	}

	// 删除标题异常
	@ApiIgnore
	@ExceptionHandler(RemoveTitleException.class)
	public JsonResult PasswordExceptionHandler(RemoveTitleException e) {
		return new JsonResult(7, e);
	}

}