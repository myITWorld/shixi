/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms
 * com.berheley.hcms.bean.IntegrateQueryOperation.java
 * Created on 2009-3-5-下午12:38:52
 */

package com.zoomkey.bean;

import java.io.Serializable;

/**
 * 类功能描述：多条件查询页面展示的信息
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public class IntegrateQueryOperation implements Serializable
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 6769984100825270584L;

	/** 页面展示元素 */
	private String					label;

	/** 具体的值 */
	private String					value;

	public IntegrateQueryOperation()
	{
	}

	/**
	 * @param label
	 * @param value
	 */
	public IntegrateQueryOperation(String label, String value)
	{
		super();
		this.label = label;
		this.value = value;
	}

	public String getLabel()
	{
		return label;
	}

	public String getValue()
	{
		return value;
	}
}
