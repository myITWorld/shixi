/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms-cvs
 * com.berheley.hcms.bean.IModifiableObj.java
 * Created on 2009-1-15-上午09:46:43
 */

package com.zoomkey.bean;

/**
 * 类功能描述：对象可以修改
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public interface IModifiableObj extends IPrimaryKey {

	/**
	 * 本体参照提供的参照对象修改自身的值
	 * 
	 * @param referObj 参照对象
	 * @author: Liujuan 2009-1-15 上午09:48:35
	 */
	public boolean change(IModifiableObj referObj);
}
