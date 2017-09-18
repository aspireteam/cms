package com.aspire.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aspire.dao.LevelTwoDao;
import com.aspire.entity.LevelTwo;
import com.aspire.service.LevelTwoService;
import com.aspire.service.exception.AddTitleException;
import com.aspire.service.exception.RemoveTitleException;
import com.aspire.service.exception.TitleIsNullException;
import com.aspire.service.exception.UpdateTitleException;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("levelTwoService")
public class LevelTwoServiceImpl implements LevelTwoService {

	@Autowired
	private LevelTwoDao levelTwoDao;

	/**
	 * 查找全部二级标题
	 * return 获取二级标题集合
	 */
	@Transactional(readOnly = true)
	public List<LevelTwo> findAll() {
		List<LevelTwo> levelTwo = levelTwoDao.findAll();
		return levelTwo;
	}

	/**
	 * 根据一级标题ID查找二级标题
	 * @param titleOneId 一级标题ID return 二级标题集合
	 */
	@Transactional(readOnly = true)
	public List<LevelTwo> findTitleByLevelOneId(Integer titleOneId) {
		 List<LevelTwo> levelTwoList = levelTwoDao.findTitleByLevelOneId(titleOneId);
		return levelTwoList;
	}

	/**
	 * 根据二级标题ID查找二级标题
	 * @param titleOneId 二级标题ID return 二级标题
	 */
	@Transactional(readOnly = true)
	public LevelTwo findTitleByLevelTwoId(Integer titleTwoId) {
		 LevelTwo levelTwo = levelTwoDao.findTitleByLevelTwoId(titleTwoId);
		return levelTwo;
	}
	
	/**
	 * 增加二级标题
	 * @param titleId 归属的一级标题ID
	 * @param titleName 二级标题名字
	 */
	public void addLevelTwoTitle(Integer titleId,String titleName) {
		if(titleName==null||titleName.isEmpty()){
			throw new TitleIsNullException("标题不能为空");
		}
		if(titleName==null||titleName.isEmpty()){
			throw new TitleIsNullException("标题ID不能为空");
		}
		LevelTwo levelTwo=new LevelTwo();
		levelTwo.setTitleOneId(titleId);
		levelTwo.setTitleName(titleName);
		levelTwo.setCreateTime(new Date());
		levelTwo.setLastModifyTime(new Date());
		int n = levelTwoDao.addLevelTwoTitle(levelTwo);
		if (n < 1) {
			throw new AddTitleException("增加二级标题失败");
		}
	}

	/**
	 * 更新二级标题
	 * @param titleId 二级标题ID
	 * @param titleName 二级标题名字
	 */
	public void updateTitle(Integer titleId,String titleName) {
		if(titleName==null||titleName.isEmpty()){
			throw new TitleIsNullException("标题不能为空");
		}
		if(titleName==null||titleName.isEmpty()){
			throw new TitleIsNullException("标题ID不能为空");
		}
		System.out.println(titleId+":"+titleName);
		LevelTwo levelTwo=new LevelTwo();
		levelTwo.setTitleTwoId(titleId);
		levelTwo.setTitleName(titleName);
		levelTwo.setLastModifyTime(new Date());
		int n = levelTwoDao.updateTitle(levelTwo);
		if (n < 1) {
			throw new UpdateTitleException("更新二级标题失败");
		}
	}

	/**
	 * 删除二级标题
	 * @param levelOneId 二级标题ID
	 */
	public void removeLevelTwoTitle(Integer levelTwoId) {
		int n = levelTwoDao.removeLevelTwoTitle(levelTwoId);
		if (n < 1) {
			throw new RemoveTitleException("删除二级标题失败");
		}
	}

}