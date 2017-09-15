package com.aspire.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 一级菜单表实体类
 * @author 丁丁
 *
 */
public class LevelOne implements Serializable{
	private static final long serialVersionUID = -7500422758916064357L;
	// 一级标题ID
	private Integer titleOneId;
	// 标题名字
	private String titleName;
	// 创建时间
	private Date createTime;
	// 最后修改时间
	private Date lastModifyTime;
	
	public LevelOne() {}

	public LevelOne(Integer titleOneId, String titleName, Date createTime, Date lastModifyTime) {
		super();
		this.titleOneId = titleOneId;
		this.titleName = titleName;
		this.createTime = createTime;
		this.lastModifyTime = lastModifyTime;
	}

	public Integer getTitleOneId() {
		return titleOneId;
	}

	public void setTitleOneId(Integer titleOneId) {
		this.titleOneId = titleOneId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
}
