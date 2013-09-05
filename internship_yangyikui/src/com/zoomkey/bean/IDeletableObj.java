/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms
 * com.berheley.hcms.bean.IDeletableObj.java
 * Created on 2009-1-7-下午01:29:57
 */

package com.zoomkey.bean;

/**
 * 类功能描述：对象可删除
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public interface IDeletableObj extends IPrimaryKey
{

	/**
	 * 返回记录的状态值
	 * 
	 * @return 记录的状态值
	 * @author: Liujuan 2009-5-8 上午09:22:23
	 */
	public String getStatus();

	/**
	 * 设置记录的状态值
	 * 
	 * @param status 状态值
	 * @author: Liujuan 2009-5-8 上午09:22:25
	 */
	public void setStatus(String status);
}
