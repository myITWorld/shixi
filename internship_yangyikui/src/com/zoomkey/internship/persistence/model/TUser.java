/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.persistence.model.TUser.java
 * Created on 2013-5-7-下午12:37:10
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
 * Create:  2013-5-7 下午12:37:10
 */
public class TUser implements Serializable, IDeletableObj, IModifiableObj {

	private Integer	id;

	private String		name;								// 用户名

	private String		password;							// 密码

	private String		gender;								// 性别

	private String		status;								// 状态

	private Integer	age;									// 年龄

	private Integer	role;								// 权限

	private String		registerTime;						// 注册时间

	private String		updateTime;						// 修改时间

	private Integer	credits;							// 积分

	private Set			TArticles	= new HashSet(0); // 一对多

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCredits() {
		return this.credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Set getTArticles() {
		return this.TArticles;
	}

	public void setTArticles(Set tArticles) {
		this.TArticles = tArticles;
	}

	public TUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TUser(String name,
				String password,
				String gender,
				String status,
				Integer age,
				Integer role,
				String registerTime,
				String updateTime,
				Integer credits) {
		super();
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.status = status;
		this.age = age;
		this.role = role;
		this.registerTime = registerTime;
		this.updateTime = updateTime;
		this.credits = credits;
	}

	/**
	 * @function:修改
	 * @param referObj
	 * @return
	 * @author: yangyikui    2013-5-13 下午10:42:06
	 */
	@Override
	public boolean change(IModifiableObj referObj) {
		// TODO Auto-generated method stub
		if (!(referObj instanceof TUser)) {
			return false;
		}
		TUser referObjO = (TUser) referObj;
		setAge(referObjO.getAge());
		setGender(referObjO.getGender());
		setUpdateTime(DateHelper.getSimpleFormatedDateNow());
		return true;
	}
}
