package com.aspire.service;

import java.util.List;

import com.aspire.entity.LevelTwo;;

public interface LevelTwoService {

    // 增加二级标题
    public void addLevelTwoTitle(Integer titleId,String titleName);
    
    // 更新二级标题
    public void updateTitle(Integer titleId,String titleName);
    
    // 根据一级标题ID查询全部二级标题
    public List<LevelTwo> findTitleByLevelOneId(Integer levelOneId);
    
    // 查询二级标题
    public LevelTwo findTitleByLevelTwoId(Integer levelTwoId);
    
    // 查询全部二级标题
    public List<LevelTwo> findAll();
    
    // 删除二级列表
    public void removeLevelTwoTitle(Integer levelTwoId);

}