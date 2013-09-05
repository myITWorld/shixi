/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms-cvs
 * com.berheley.hcms.service.IDeletableBO.java
 * Created on 2009-1-13-下午03:54:52
 */

package com.zoomkey.internship.service;

import java.util.List;

import com.zoomkey.bean.IDeletableObj;
import com.zoomkey.exception.BusinessException;

/**
 * 类功能描述：
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public interface IDeletableBO extends ICommonBO {

	/**
	 * @function: 创建对象，设置为正常状态
	 * @param obj
	 * @return
	 * @throws BusinessException
	 * @author: Liujuan 2009-1-14 上午09:29:20
	 */
	public IDeletableObj optCreate(IDeletableObj obj) throws BusinessException;

	/**
	 * 
	 * @function:批量删除对象：假删除，设置状态为删除状态
	 * @param ids
	 * @param clz
	 * @throws BusinessException
	 * @author: GaoJiayuan    2013-2-26 下午05:07:30
	 */
	public void optDelete(String ids, Class<? extends IDeletableObj> clz) throws BusinessException;

	/**
	 * @function: 返回所有正常的记录
	 * @param clz
	 * @return
	 * @author: Liujuan 2009-1-14 上午09:28:57
	 */
	public List<? extends IDeletableObj> loadAllEnabled(Class<? extends IDeletableObj> clz);

	/**
	 * @function: 删除对象：假删除，设置状态为删除状态
	 * @param obj
	 * @author: wangcheng    2011-3-11 下午04:41:40
	 */
	void optDelete(IDeletableObj obj);
}
