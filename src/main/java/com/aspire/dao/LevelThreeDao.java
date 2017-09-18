package com.aspire.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aspire.entity.LevelThree;

@Mapper
public interface LevelThreeDao {
	/**
	 * 查询所有数据
	 * @return LevelThree集合
	 */
	public List<LevelThree> findAll();
	
	/**
	 * 根据二级标题ID查询全部三级标题
	 * @param titleTwoId 二级标题ID
	 * @return 三级标题内容
	 */
	public List<LevelThree> findTitleByLevelTwoId(Integer titleTwoId);
	
	/**
	 * 根据三级标题查询三级标题
	 * @param titleThreeId 三级标题ID
	 * @return 三级标题内容集合
	 */
	public LevelThree findTitleByLevelThreeId(Integer titleThreeId);
	
	/**
	 * 增加三级标题
	 * @param levelThree要增加的内容
	 * @return 对数据的影响行数
	 */
	public Integer addLevelThreeTitle(LevelThree levelThree);
	
	/**
	 * 根据三级标题ID来更新三级标题
	 * @param titleThreeId 三级标题ID
	 * @param levelThree 要更新的内容
	 * @return 对数据的影响行数
	 */
	public Integer updateTitle(LevelThree levelThree);
	
	/**
	 * 根据三级标题ID删除三级标题
	 * @param titleThreeId 三级标题ID
	 * @return 对数据的影响行数
	 */
	public Integer removeLevelThreeTitle(Integer titleThreeId);
	
}
