
package com.zoomkey.internship.web.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.validator.ValidatorActionForm;

public class BaseForm extends ValidatorActionForm {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 810993310677418082L;

	/**
	 * 页面ajax请求
	 */
	private String					ajaxSubmit;

	/**
	 * 查询条件
	 */
	private Map						conMap				= new HashMap();

	private String					contentPath;

	/**
	 * 页面提交的批量删除的对象的id集合
	 */
	private String[]				ids					= new String[0];

	/* param for dispathAction */
	private String					method;

	/**
	 * 页面传递的需要修改的id
	 */
	private String					objId;

	public String getAjaxSubmit() {
		return this.ajaxSubmit;
	}

	/**
	 * @param attributeKey
	 * @return
	 */
	public Object getAttribute(String attributeKey) {
		Object keyValue = getConMap().get(attributeKey);
		return keyValue;
	}

	/**
	 * @return 返回 conMap。
	 */
	public Map getConMap() {
		return this.conMap;
	}

	public String getContentPath() {
		return this.contentPath;
	}

	/**
	 * @return Returns the ids.
	 */
	public String[] getIds() {
		return this.ids;
	}

	/**
	 * @return
	 */
	public final String getMethod() {
		return this.method;
	}

	public String getObjId() {
		return this.objId;
	}

	public void setAjaxSubmit(String ajaxSubmit) {
		this.ajaxSubmit = ajaxSubmit;
	}

	/**
	 * @param attributeKey
	 * @param attributeValue
	 */
	public void setAttribute(String attributeKey, Object attributeValue) {
		getConMap().put(attributeKey, attributeValue);
	}

	/**
	 * @param conMap 要设置的 conMap。
	 */
	public void setConMap(Map conMap) {
		this.conMap = conMap;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	/**
	 * @param ids The ids to set.
	 */
	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * @param method
	 */
	public final void setMethod(String method) {
		this.method = method;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}
}
