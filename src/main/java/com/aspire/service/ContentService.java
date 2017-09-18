package com.aspire.service;

import java.util.List;

import com.aspire.entity.Content;

public interface ContentService {

    // 增加主体内容
    public void addBody(Integer titleId,String body);
    
    // 更新主体内容
    public void updateBody(Integer contentId,String body);
    
    // 搜索内容
    public List<Content> searchContent(String body);
    
    // 查询全部内容
    public List<Content> findAll();
    
    // 根据主体内容ID查询内容
    public Content findBodyByContentId(Integer contentId);
    
    // 根据三级标题ID查询内容
    public Content findBodyByLevelThreeId(Integer titleId);
    
    // 删除主体内容
    public void removeBody(Integer contentId);

}