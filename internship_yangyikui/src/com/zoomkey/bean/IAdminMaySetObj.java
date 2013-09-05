/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms
 * com.berheley.hcms.bean.IAdminMaySetObj.java
 * Created on 2009-5-8-上午09:21:24
 */

package com.zoomkey.bean;

/**
 * 类功能描述：
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public interface IAdminMaySetObj extends IPrimaryKey
{

	/**
	 * 返回记录的状态值
	 * 
	 * @return 记录的状态值
	 * @author: Liujuan 2009-5-8 上午09:22:23
	 */
	public String getStatus();

	/**
	 * 设置记录的状态
	 * 
	 * @param status 状态值
	 * @author: Liujuan 2009-5-8 上午09:22:25
	 */
	public void setStatus(String status);

	/**
	 * @function:管理员对该条记录进行了设置
	 * @author: Liujuan 2009-5-8 上午09:22:01
	 */
	public void setByAdmin();
}
