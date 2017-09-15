package com.aspire.dao;

import java.util.List;

import com.aspire.entity.LevelOne;

public interface LevelOneDao {
	
	/**
	 * 查询所有数据
	 * @return LevelOne集合
	 */
	public List<LevelOne> findAll();
	
	/**
	 * 根据一级标题ID查询一级标题
	 * @param titleOneId 一级标题ID
	 * @return 一级标题内容
	 */
	public LevelOne findTitleByLevelOneId(Integer titleOneId);
	
	/**
	 * 增加一级标题
	 * @param levelOne 要增加的内容
	 * @return 对数据的影响行数
	 */
	public Integer addLevelOneTitle(LevelOne levelOne);
	
	/**
	 * 根据一级标题ID来更新一级标题
	 * @param titleOneId 一级标题ID
	 * @param levelOne 要更新的内容
	 * @return 对数据的影响行数
	 */
	public Integer updateTitleByLevelOneId(Integer titleOneId,LevelOne levelOne);
	
	/**
	 * 根据一级标题ID删除一级标题
	 * @param titleOneId 一级标题ID
	 * @return 对数据的影响行数
	 */
	public Integer removeLevelOneTitle(Integer titleOneId);
	
}
