/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.web.form.UserForm.java
 * Created on 2013-5-7-下午03:58:43
 */

package com.zoomkey.internship.web.form;

import java.util.List;
import java.util.Map;

import com.zoomkey.internship.persistence.model.TUser;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-7 下午03:58:43
 */
public class UserForm extends BaseForm {

	private TUser		tUser	= new TUser();

	private List<Map>	usernameList;			// 存放用户列表

	public List<Map> getUsernameList() {
		return this.usernameList;
	}

	public void setUsernameList(List<Map> usernameList) {
		this.usernameList = usernameList;
	}

	public TUser gettUser() {
		return this.tUser;
	}

	public void settUser(TUser tUser) {
		this.tUser = tUser;
	}

	private String	pwd;

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
