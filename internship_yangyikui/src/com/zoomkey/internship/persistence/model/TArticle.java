/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.persistence.model.TArticle.java
 * Created on 2013-5-7-下午12:41:55
 */

package com.zoomkey.internship.persistence.model;

import java.io.Serializable;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-7 下午12:41:55
 */
public class TArticle implements Serializable {

	private Integer	id;

	private TSection	TSection;			// 版块

	private TUser		TUser;				// 用户

	private String		title;				// 标题

	private String		isAuditing;		// 是否审核

	private String		createTime;		// 创建时间

	private String		updateTime;		// 修改时间

	private String		articleLabel;		// 标签

	private String		articleContent;	// 文章内容

	private String		status;				// 状态 （1：存在，0：假删除）

	private String		isEssence;			// 是否精华

	private String		isTop;				// 是否置顶

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TSection getTSection() {
		return this.TSection;
	}

	public void setTSection(TSection tSection) {
		this.TSection = tSection;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser tUser) {
		this.TUser = tUser;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsAuditing() {
		return this.isAuditing;
	}

	public void setIsAuditing(String isAuditing) {
		this.isAuditing = isAuditing;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getArticleLabel() {
		return this.articleLabel;
	}

	public void setArticleLabel(String articleLabel) {
		this.articleLabel = articleLabel;
	}

	public String getArticleContent() {
		return this.articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsEssence() {
		return this.isEssence;
	}

	public void setIsEssence(String isEssence) {
		this.isEssence = isEssence;
	}

	public String getIsTop() {
		return this.isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public TArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TArticle(Integer id,
				com.zoomkey.internship.persistence.model.TSection tSection,
				com.zoomkey.internship.persistence.model.TUser tUser,
				String title,
				String isAuditing,
				String createTime,
				String updateTime,
				String articleLabel,
				String articleContent,
				String status,
				String isEssence,
				String isTop) {
		super();
		this.id = id;
		this.TSection = tSection;
		this.TUser = tUser;
		this.title = title;
		this.isAuditing = isAuditing;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.articleLabel = articleLabel;
		this.articleContent = articleContent;
		this.status = status;
		this.isEssence = isEssence;
		this.isTop = isTop;
	}

	private TArticle(String isAuditing,
				String createTime,
				String updateTime,
				String status,
				String isEssence,
				String isTop) {
		super();
		this.isAuditing = isAuditing;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
		this.isEssence = isEssence;
		this.isTop = isTop;
	}
}
