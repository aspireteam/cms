package com.aspire.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 内容类
 * @author 丁丁
 *
 */
public class Content implements Serializable{
	private static final long serialVersionUID = -2010856359457514702L;
	// 内容ID
	private Integer contentId;
	// 三级标题ID
	private Integer titleThreeId;
	// 内容
	private String body;
	// 创建时间
	private Date createTime;
	// 最后修改时间
	private Date lastModifyTime;
	
	public Content() {}

	public Content(Integer contentId, Integer titleThreeId, String body, Date createTime, Date lastModifyTime) {
		super();
		this.contentId = contentId;
		this.titleThreeId = titleThreeId;
		this.body = body;
		this.createTime = createTime;
		this.lastModifyTime = lastModifyTime;
	}

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Integer getTitleThreeId() {
		return titleThreeId;
	}

	public void setTitleThreeId(Integer titleThreeId) {
		this.titleThreeId = titleThreeId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
