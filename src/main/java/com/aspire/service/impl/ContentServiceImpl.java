package com.aspire.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aspire.dao.ContentDao;
import com.aspire.entity.Content;
import com.aspire.service.ContentService;
import com.aspire.service.exception.AddBodyException;
import com.aspire.service.exception.BodyIsNullException;
import com.aspire.service.exception.RemoveBodyException;
import com.aspire.service.exception.TitleIsNullException;
import com.aspire.service.exception.UpdateBodyException;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("contentService")
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	ContentDao contentDao;
	
	/**
	 * 添加主体内容
	 * @param titleId 归属的三级列表ID
	 * @param body 添加的主体内容
	 */
	public void addBody(Integer titleId,String body) {
		if(body==null||body.isEmpty()){
			throw new TitleIsNullException("标题不能为空");
		}
		Content content=new Content();
		content.setTitleThreeId(titleId);
		content.setBody(body);
		content.setCreateTime(new Date());
		content.setLastModifyTime(new Date());
		int n=contentDao.addBody(content);
		if (n < 1) {
			throw new AddBodyException("添加内容失败");
		}	
	}

	/**
	 * 更新主体内容
	 * @param contentId 主体内容ID
	 * @param body 更新的主体内容
	 */
	public void updateBody(Integer contentId, String body) {
		if(body==null||body.isEmpty()){
			throw new BodyIsNullException("内容不能为空");
		}
		if(contentId==null){
			throw new BodyIsNullException("内容ID不能为空");
		}
		Content content=new Content();
		content.setContentId(contentId);
		content.setBody(body);
		content.setLastModifyTime(new Date());
		int n = contentDao.updateBody(content);
		if (n < 1) {
			throw new UpdateBodyException("更新内容失败");
		}
	}

	/**
	 * 查找主体内容
	 * @param body 主体内容
	 */
	public List<Content> searchContent(String body) {
		if(body==null||body.isEmpty()){
			throw new BodyIsNullException("内容不能为空");
		}
		List<Content> contentList=contentDao.findBodyBySearch(body);
		return contentList;
	}

	/**
	 * 查找全部主体内容
	 */
	public List<Content> findAll() {
		List<Content> contentList=contentDao.findAll();
		return contentList;
	}

	/**
	 * 根据主题内容ID查找主体内容
	 * @param contentId 主体内容ID
	 */
	public Content findBodyByContentId(Integer contentId) {
		if(contentId==null){
			throw new BodyIsNullException("内容ID不能为空");
		}
		Content content=contentDao.findBodyByContentId(contentId);
		return content;
	}

	/**
	 * 根据三级标题ID查找主体内容
	 * @param levelThreeId 三级标题ID
	 */
	public Content findBodyByLevelThreeId(Integer titleId) {
		if(titleId==null){
			throw new BodyIsNullException("三级标题ID不能为空");
		}
		Content content=contentDao.findBodyByLevelThreeId(titleId);
		return content;
	}

	/**
	 * 删除内容
	 * @param contentId 主体内容ID
	 */
	public void removeBody(Integer contentId) {
		if(contentId==null){
			throw new BodyIsNullException();
		}
		int n=contentDao.removeBody(contentId);
		if(n<1){
			throw new RemoveBodyException("删除内容失败");
		}
	}

}