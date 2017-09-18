package com.aspire.dao;

import java.util.List;

import com.aspire.entity.LevelTwo;

public interface LevelTwoDao {
	
	/**
	 * 查询所有数据
	 * @return LevelTwo集合
	 */
	public List<LevelTwo> findAll();
	
	/**
	 * 根据一级标题ID查询全部二级标题
	 * @param titleOneId 一级标题ID
	 * @return 二级标题内容
	 */
	public LevelTwo findTitleByLevelOneId(Integer titleOneId);
	
	/**
	 * 根据二级标题ID查询二级标题
	 * @param titleTwoId 二级标题ID
	 * @return 二级标题内容
	 */
	public LevelTwo findTitleByLevelTwoId(Integer titleTwoId);
	
	/**
	 * 增加二级标题
	 * @param levelOne 要增加的内容
	 * @return 对数据的影响行数
	 */
	public Integer addLevelTwoTitle(LevelTwo levelTwo);
	
	/**
	 * 根据titleTwoId来更新二级标题
	 * @param titleTwoId 二级标题ID
	 * @param levelOne 要更新的内容
	 * @return 对数据的影响行数
	 */
	public Integer updateLevelTwoTitleById(Integer titleTwoId,LevelTwo levelOne);
	
	/**
	 * 根据titleTwoId移出二级标题
	 * @param titleTwoId 二级标题ID
	 * @return 对数据的影响行数
	 */
	public Integer removeLevelTwoTitle(Integer titleTwoId);
	
}
