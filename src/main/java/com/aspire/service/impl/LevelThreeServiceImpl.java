package com.aspire.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aspire.dao.LevelThreeDao;
import com.aspire.entity.LevelThree;
import com.aspire.service.LevelThreeService;
import com.aspire.service.exception.AddTitleException;
import com.aspire.service.exception.RemoveTitleException;
import com.aspire.service.exception.TitleIsNullException;
import com.aspire.service.exception.UpdateTitleException;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("levelThreeService")
public class LevelThreeServiceImpl implements LevelThreeService {

	@Autowired
	private LevelThreeDao levelThreeDao;

	/**
	 * 查找全部三级标题
	 * return 获取三级标题集合
	 */
	@Transactional(readOnly = true)
	public List<LevelThree> findAll() {
		List<LevelThree> levelThreeList = levelThreeDao.findAll();
		return levelThreeList;
	}

	/**
	 * 根据二级标题ID查找二级标题
	 * @param titleOneId 二级标题ID return 三级标题集合
	 */
	@Transactional(readOnly = true)
	public List<LevelThree> findTitleByLevelTwoId(Integer titleTwoId) {
		 List<LevelThree> levelThreeList = levelThreeDao.findTitleByLevelTwoId(titleTwoId);
		return levelThreeList;
	}

	/**
	 * 根据三级标题ID查找三级标题
	 * @param titleOneId 三级标题ID return 三级标题
	 */
	@Transactional(readOnly = true)
	public LevelThree findTitleByLevelThreeId(Integer titleThreeId) {
		 LevelThree levelThree = levelThreeDao.findTitleByLevelThreeId(titleThreeId);
		return levelThree;
	}

	
	/**
	 * 增加三级标题
	 * @param titleId 归属的二级标题ID
	 * @param titleName 三级标题名字
	 */
	public void addLevelThreeTitle(Integer titleId,String titleName) {
		if(titleName==null||titleName.isEmpty()){
			throw new TitleIsNullException("标题不能为空");
		}
		if(titleName==null||titleName.isEmpty()){
			throw new TitleIsNullException("标题ID不能为空");
		}
		LevelThree levelThree=new LevelThree();
		levelThree.setTitleName(titleName);
		levelThree.setTitleTwoId(titleId);
		levelThree.setCreateTime(new Date());
		levelThree.setLastModifyTime(new Date());
		int n = levelThreeDao.addLevelThreeTitle(levelThree);
		if (n < 1) {
			throw new AddTitleException("增加三级标题失败");
		}
	}

	/**
	 * 更新三级标题
	 * @param titleId 三级标题ID
	 * @param titleName 三级标题名字
	 */
	public void updateTitle(Integer titleId,String titleName) {
		if(titleName==null||titleName.isEmpty()){
			throw new TitleIsNullException("标题不能为空");
		}
		if(titleName==null||titleName.isEmpty()){
			throw new TitleIsNullException("标题ID不能为空");
		}
		LevelThree levelThree=new LevelThree();
		levelThree.setTitleName(titleName);
		levelThree.setTitleThreeId(titleId);
		levelThree.setLastModifyTime(new Date());
		int n = levelThreeDao.updateTitle(levelThree);
		if (n < 1) {
			throw new UpdateTitleException("更新三级标题失败");
		}
	}

	/**
	 * 删除三级标题
	 * @param levelOneId 三级标题ID
	 */
	public void removeLevelThreeTitle(Integer levelThreeId) {
		int n = levelThreeDao.removeLevelThreeTitle(levelThreeId);
		if (n < 1) {
			throw new RemoveTitleException("删除三级标题失败");
		}
	}

}