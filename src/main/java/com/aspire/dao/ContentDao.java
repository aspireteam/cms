package com.aspire.dao;

import java.util.List;

import com.aspire.entity.Content;

public interface ContentDao {
	/**
	 * 查询所有数据
	 * @return content集合
	 */
	public List<Content> findAll();
	
	/**
	 * 根据三级标题ID查询全部主体内容
	 * @param titleThreeId 三级级标题ID
	 * @return 主体内容
	 */
	public Content findBodyByLevelThreeId(Integer titleThree);
	
	/**
	 * 根据contentId查询主体内容
	 * @param contentId 主体内容ID
	 * @return 主体内容
	 */
	public Content findBodyByContentId(Integer contentId);
	
	/**
	 * 增加主体内容
	 * @param content 要增加的内容
	 * @return 对数据的影响行数
	 */
	public Integer addBody(Content content);
	
	/**
	 * 根据contentId来更新三级标题
	 * @param contentId 主体内容ID
	 * @param content 要更新的内容
	 * @return 对数据的影响行数
	 */
	public Integer updateBodyByContentId(Integer contentId,Content content);
	
	/**
	 * 根据contentId移出主体内容
	 * @param contentId 主体内容ID
	 * @return 对数据的影响行数
	 */
	public Integer removeBody(Integer contentId);
}
