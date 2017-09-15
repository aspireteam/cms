package com.aspire.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 三级菜单ID
 * @author 丁丁
 *
 */
public class LevelThree implements Serializable{
	private static final long serialVersionUID = 2554187927076635676L;
	// 三级菜单ID
	private Integer titleThreeId;
	// 二级菜单ID
	private Integer titleTwoId;
	// 标题名称
	private String titleName;
	// 创建时间
	private Date createTime;
	// 最后修改时间
	private Date lastModifyTime;
	
	public LevelThree() {}

	public LevelThree(Integer titleThreeId, Integer titleTwoId, String titleName, Date createTime,
			Date lastModifyTime) {
		super();
		this.titleThreeId = titleThreeId;
		this.titleTwoId = titleTwoId;
		this.titleName = titleName;
		this.createTime = createTime;
		this.lastModifyTime = lastModifyTime;
	}

	public Integer getTitleThreeId() {
		return titleThreeId;
	}

	public void setTitleThreeId(Integer titleThreeId) {
		this.titleThreeId = titleThreeId;
	}

	public Integer getTitleTwoId() {
		return titleTwoId;
	}

	public void setTitleTwoId(Integer titleTwoId) {
		this.titleTwoId = titleTwoId;
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
