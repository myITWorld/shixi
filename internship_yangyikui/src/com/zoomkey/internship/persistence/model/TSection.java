/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.persistence.model.TSection.java
 * Created on 2013-5-7-下午12:42:31
 */

package com.zoomkey.internship.persistence.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.zoomkey.bean.IDeletableObj;
import com.zoomkey.bean.IModifiableObj;
import com.zoomkey.util.DateHelper;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-7 下午12:42:31
 */
public class TSection implements Serializable, IDeletableObj, IModifiableObj {

	private Integer	id;									// 版块id

	private Integer	userId;								// 用户id

	private String		sectionName;						// 板块名

	private String		sectionIntro;						// 版块简介

	private Integer	isAuditing;						// 是否审核

	private String		createTime;						// 创建时间

	private String		updateTime;						// 修改时间

	private String		status;								// 状态

	private Integer	visitCredits;						// 访问积分

	private Set			TArticles	= new HashSet(0); // 一个板块含有多篇文章

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getSectionIntro() {
		return this.sectionIntro;
	}

	public void setSectionIntro(String sectionIntro) {
		this.sectionIntro = sectionIntro;
	}

	public Integer getVisitCredits() {
		return this.visitCredits;
	}

	public void setVisitCredits(Integer visitCredits) {
		this.visitCredits = visitCredits;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Integer getIsAuditing() {
		return this.isAuditing;
	}

	public void setIsAuditing(Integer isAuditing) {
		this.isAuditing = isAuditing;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	public Set getTArticles() {
		return this.TArticles;
	}

	public void setTArticles(Set tArticles) {
		this.TArticles = tArticles;
	}

	public TSection() {
		super();
		// TODO Auto-generated constructor stub
	}

	private TSection(Integer id,
				Integer userId,
				String sectionName,
				String sectionIntro,
				Integer isAuditing,
				String createTime,
				String updateTime,
				String status,
				Integer visitCredits,
				Set tArticles) {
		super();
		this.id = id;
		this.userId = userId;
		this.sectionName = sectionName;
		this.sectionIntro = sectionIntro;
		this.isAuditing = isAuditing;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
		this.visitCredits = visitCredits;
		this.TArticles = tArticles;
	}

	private TSection(Integer userId,
				String sectionName,
				String sectionIntro,
				Integer isAuditing,
				String createTime,
				String updateTime,
				String status,
				Integer visitCredits,
				Set tArticles) {
		super();
		this.userId = userId;
		this.sectionName = sectionName;
		this.sectionIntro = sectionIntro;
		this.isAuditing = isAuditing;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
		this.visitCredits = visitCredits;
		this.TArticles = tArticles;
	}

	/**
	 * @function:修改版块信息
	 * @param referObj
	 * @return
	 * @author: yangyikui    2013-5-30 下午04:27:22
	 */
	@Override
	public boolean change(IModifiableObj referObj) {
		// TODO Auto-generated method stub
		if (!(referObj instanceof TSection)) {
			return false;
		}
		TSection referObjO = (TSection) referObj;
		setSectionName(referObjO.getSectionName());
		setIsAuditing(referObjO.getIsAuditing());
		setVisitCredits(referObjO.getVisitCredits());
		setUpdateTime(DateHelper.getSimpleFormatedDateNow());
		return true;
	}
}
