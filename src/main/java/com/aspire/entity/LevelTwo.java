package com.aspire.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 二级菜单表实体类
 * @author 丁丁
 *
 */
public class LevelTwo implements Serializable{
	private static final long serialVersionUID = -1641762113926442574L;
	// 二级标题ID
	private Integer titleTwoId;
	// 一级标题ID
	private Integer titleOneId;
	// 标题名字
	private String titleName;
	// 创建时间
	private Date createTime;
	// 最后修改时间
	private Date lastModifyTime;
	
	public LevelTwo() {}

	public LevelTwo(Integer titleTwoId, Integer titleOneId, String titleName, Date createTime, Date lastModifyTime) {
		super();
		this.titleTwoId = titleTwoId;
		this.titleOneId = titleOneId;
		this.titleName = titleName;
		this.createTime = createTime;
		this.lastModifyTime = lastModifyTime;
	}

	public Integer getTitleTwoId() {
		return titleTwoId;
	}

	public void setTitleTwoId(Integer titleTwoId) {
		this.titleTwoId = titleTwoId;
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
