package com.aspire.service;

import java.util.List;

import com.aspire.entity.LevelThree;

public interface LevelThreeService {

    // 增加三级标题
    public void addLevelThreeTitle(Integer titleId,String titleName);
    
    // 更新三级标题
    public void updateTitle(Integer titleId,String titleName);
    
    // 根据二级标题ID查询全部三级标题
    public List<LevelThree> findTitleByLevelTwoId(Integer levelTwoId);
    
    // 查询三级标题
    public LevelThree findTitleByLevelThreeId(Integer levelThreeId);
    
    // 查询全部三级标题
    public List<LevelThree> findAll();
    
    // 删除三级列表
    public void removeLevelThreeTitle(Integer levelThreeId);

}