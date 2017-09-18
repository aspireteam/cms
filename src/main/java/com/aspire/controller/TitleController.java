package com.aspire.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.entity.JsonResult;
import com.aspire.service.LevelOneService;
import com.aspire.service.LevelThreeService;
import com.aspire.service.LevelTwoService;
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
@RequestMapping("/title")
@Api(tags="标题管理接口")
public class TitleController {

	@Autowired
	LevelOneService levelOneService;
	@Autowired
	LevelTwoService levelTwoService;
	@Autowired
	LevelThreeService levelThreeService;

	// —————————————————— 标题基本操作接口 ——————————————————
	// 查询全部标题
	@ApiOperation(value = "获取全部标题接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult getTitleAll(@ApiParam("标题等级") @RequestParam("level")Integer level){
		Object titleAll;
		// 判断level值
		if(level==1){
			titleAll=levelOneService.findAll();
		}else if(level==2){
			titleAll=levelTwoService.findAll();
		}else if(level==3){
			titleAll=levelThreeService.findAll();
		}else{
			// 参数错误返回信息
			return new JsonResult("参数错误");
		}
		// 成功返回标题JSON信息
		return new JsonResult(titleAll);
	}
	
	// 查询标题
	@ApiOperation(value = "获取标题接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult getTitle(
			@ApiParam("标题等级") @RequestParam("level")Integer level,
		    @ApiParam("标题ID号") @RequestParam("titleId")Integer titleId){
		Object title; 
		// 判断level值
		if(level==1){
			title=levelOneService.findTitleByLevelOneId(titleId);
		}else if(level==2){
			title=levelTwoService.findTitleByLevelTwoId(titleId);
		}else if(level==3){
			title=levelThreeService.findTitleByLevelThreeId(titleId);
		}else{
			// 参数错误返回信息
			return new JsonResult("参数错误");
		}
		// 成功返回标题JSON信息
		return new JsonResult(title);	
	}
	
	// 查询归属于一级的全部二级标题
	@ApiOperation(value = "查询属于一级的二级标题", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/getLevelTwoAll", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult getLevelTwo(
		    @ApiParam("一级标题ID号") @RequestParam("titleId")Integer titleId){
		Object titleLevelTwo; 
		// 判断level值
		titleLevelTwo=levelTwoService.findTitleByLevelOneId(titleId);
		// 成功返回标题JSON信息
		return new JsonResult(titleLevelTwo);	
	}
	
	// 查询归属于二级的全部三级标题
	@ApiOperation(value = "查询属于二级的三级标题", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/getLevelThreeAll", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult getLevelThree(
		    @ApiParam("二级标题ID号") @RequestParam("titleId")Integer titleId){
		Object titleLevelThree; 
		// 判断level值
		titleLevelThree=levelThreeService.findTitleByLevelTwoId(titleId);
		// 成功返回标题JSON信息
		return new JsonResult(titleLevelThree);	
	}
	
	// 增加一级标题
	@ApiOperation(value = "增加一级标题接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/addTitleOne", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult addTitleOne(
		    @ApiParam("标题名字") @RequestParam("titleName")String titleName){
		// 增加标题
		levelOneService.addLevelOneTitle(titleName);
		// 返回成功状态
		return new JsonResult(0,"增加成功");
	}
	
	// 增加二级标题
	@ApiOperation(value = "增加二级标题接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/addTitleTwo", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult addTitleTwo(
			@ApiParam("归属的一级标题ID") @RequestParam("titleId")Integer titleId,
		    @ApiParam("二级标题名字") @RequestParam("titleName")String titleName){
		// 增加标题
		levelTwoService.addLevelTwoTitle(titleId,titleName);
		// 返回成功状态
		return new JsonResult(JsonResult.SUCCESS,"增加成功");
	}
	
	// 增加三级标题
	@ApiOperation(value = "增加三级标题接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/addTitleThree", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult addTitleThree(
		    @ApiParam("归属的二级标题ID") @RequestParam("titleId")Integer titleId,
		    @ApiParam("三级标题名字") @RequestParam("titleName")String titleName){
		// 增加标题
		levelThreeService.addLevelThreeTitle(titleId,titleName);
		// 返回成功状态
		return new JsonResult(JsonResult.SUCCESS,"增加成功");
	}
	
	// 更新标题
	@ApiOperation(value = "修改标题接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult updateTitle(
			@ApiParam("标题等级(1 or 2 or 3)") @RequestParam("level")Integer level,
			@ApiParam("修改的标题ID") @RequestParam("titleId")Integer titleId,
		    @ApiParam("修改的标题名") @RequestParam("titleName")String titleName){
		// 判断level值
		if(level==1){
			levelOneService.updateTitle(titleId, titleName);
		}else if(level==2){
			levelTwoService.updateTitle(titleId, titleName);
		}else if(level==3){
			levelThreeService.updateTitle(titleId, titleName);
		}else{
			// 参数错误返回信息
			return new JsonResult("参数错误");
		}
		// 返回成功状态
		return new JsonResult(JsonResult.SUCCESS,"更新成功");	
	}
	
	// 删除标题
	@ApiOperation(value = "删除标题接口", response = JsonResult.class, produces = APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	@ResponseBody
	public JsonResult removeTitle(
			@ApiParam("标题等级(1 or 2 or 3)") @RequestParam("level")Integer level,
			@ApiParam("删除的标题ID") @RequestParam("titleId")Integer titleId){
		// 判断level值
		if(level==1){
			levelOneService.removeLevelOneTitle(titleId);
		}else if(level==2){
			levelTwoService.removeLevelTwoTitle(titleId);
		}else if(level==3){
			levelThreeService.removeLevelThreeTitle(titleId);
		}else{
			// 参数错误返回信息
			return new JsonResult("参数错误");
		}
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