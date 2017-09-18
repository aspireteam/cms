package com.aspire.service;

import java.util.List;

import com.aspire.entity.LevelOne;;

public interface LevelOneService {

    // 增加一级标题
    public void addLevelOneTitle(String titleName);
    
    // 更新一级标题
    public void updateTitle(Integer titleId,String titleName);
    
    // 查询一级标题
    public LevelOne findTitleByLevelOneId(Integer levelOneId);
    
    // 查询全部一级标题
    public List<LevelOne> findAll();
    
    // 删除一级标题
    public void removeLevelOneTitle(Integer levelOneId);

}