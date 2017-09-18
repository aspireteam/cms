package com.aspire.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aspire.dao.LevelOneDao;
import com.aspire.entity.LevelOne;
import com.aspire.service.LevelOneService;
import com.aspire.service.exception.AddTitleException;
import com.aspire.service.exception.RemoveTitleException;
import com.aspire.service.exception.TitleIsNullException;
import com.aspire.service.exception.UpdateTitleException;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("levelOneService")
public class LevelOneServiceImpl implements LevelOneService {

	@Autowired
	private LevelOneDao levelOneDao;

	/**
	 * 查找全部一级标题
	 * return 获取一级标题集合
	 */
	@Transactional(readOnly = true)
	public List<LevelOne> findAll() {
		List<LevelOne> levelOne = levelOneDao.findAll();
		return levelOne;
	}

	/**
	 * 根据一级标题ID查找一级标题
	 * @param titleOneId 一级标题名称 return 一级标题
	 */
	@Transactional(readOnly = true)
	public LevelOne findTitleByLevelOneId(Integer titleOneId) {
		LevelOne levelOne = levelOneDao.findTitleByLevelOneId(titleOneId);
		return levelOne;
	}

	/**
	 * 增加一级标题
	 * @param levelOne 一级标题数据
	 */
	public void addLevelOneTitle(String titleName) {
		if(titleName==null||titleName.isEmpty()){
			throw new TitleIsNullException("标题不能为空");
		}
		LevelOne levelOne=new LevelOne();
		levelOne.setTitleName(titleName);
		levelOne.setCreateTime(new Date());
		levelOne.setLastModifyTime(new Date());
		int n = levelOneDao.addLevelOneTitle(levelOne);
		if (n < 1) {
			throw new AddTitleException("增加一级标题失败");
		}
	}

	/**
	 * 更新一级标题
	 * @param titleId 一级标题ID
	 * @param titleName 一级标题名字
	 */
	public void updateTitle(Integer titleId,String titleName) {
		if(titleName==null||titleName.isEmpty()){
			throw new TitleIsNullException("标题不能为空");
		}
		LevelOne levelOne=new LevelOne();
		levelOne.setTitleOneId(titleId);
		levelOne.setTitleName(titleName);
		levelOne.setLastModifyTime(new Date());
		int n = levelOneDao.updateTitle(levelOne);
		if (n < 1) {
			throw new UpdateTitleException("更新一级标题失败");
		}
	}

	/**
	 * 删除一级标题
	 * @param levelOneId 一级标题ID
	 */
	public void removeLevelOneTitle(Integer levelOneId) {
		int n = levelOneDao.removeLevelOneTitle(levelOneId);
		if (n < 1) {
			throw new RemoveTitleException("删除一级标题失败");
		}
	}

}