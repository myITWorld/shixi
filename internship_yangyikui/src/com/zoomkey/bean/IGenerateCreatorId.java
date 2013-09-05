/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms
 * com.berheley.hcms.bean.IGenerateCreatorId.java
 * Created on 2009-2-27-上午08:44:20
 */

package com.zoomkey.bean;

/**
 * 类功能描述：记录需要设置该记录的创建人id
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public interface IGenerateCreatorId
{

	/**
	 * 设置记录的创建人id（系统登录账号id）
	 * 
	 * @param creatorId 创建人id
	 * @author: Liujuan 2009-2-27 上午08:45:17
	 */
	public void setCreatorId(String creatorId);
}
