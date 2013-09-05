/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms-cvs
 * com.berheley.hcms.service.ICommonBO.java
 * Created on 2009-1-14-上午09:00:52
 */

package com.zoomkey.internship.service;

/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms-cvs
 * com.berheley.hcms.service.ICommonBO.java
 * Created on 2009-1-14-上午09:00:52
 */
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.zoomkey.bean.IModifiableObj;
import com.zoomkey.exception.BusinessException;
import com.zoomkey.internship.persistence.dao.IFacadeDAO;

/**
 * 类功能描述：
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public interface ICommonBO {

	public IFacadeDAO getCommonDao();

	/**
	 * @function:对象保存
	 * @param o
	 * @throws BusinessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public void optCreate(Object o) throws BusinessException;

	/**
	 * @function:对象修改
	 * @param o
	 * @throws BusinessException
	 */
	public void optModify(Object o) throws BusinessException;

	/**
	 * @function:对象修改
	 * @param o
	 * @throws BusinessException
	 */
	public void optModify(IModifiableObj o) throws BusinessException;

	/**
	 * 对象删除
	 * 
	 * @function:
	 * @param o
	 * @throws BusinessException
	 */
	public void optDelete(Object o) throws BusinessException;

	public void saveOrUpdate(Object o);

	/**
	 * @function:对象是否为空
	 * @param o
	 * @return
	 * @author: Liujuan 2009-4-21 下午04:42:49
	 */
	public boolean isHavePrimaryKeyValue(Object o);

	/**
	 * @function:对象加载 默认延迟加载，找不到对象返回异常
	 * @param id
	 * @return 如果 id为空，返回 实例化的对象
	 * @throws BusinessException
	 */
	public Object getObjectById(Class<?> clazz, Serializable id) throws BusinessException;

	/**
	 * @function:对象加载 默认延迟加载，找不到对象返回null
	 * @param id
	 * @return 如果 id为空，返回 实例化的对象
	 * @throws BusinessException
	 */
	public Object loadObjectById(Class<?> clazz, Serializable id) throws BusinessException;

	/**
	 * @author <a href="mailto:juan.liu@berheley.com">LiuJuan </a>
	 * @function:返回要查询的对象
	 * @param id 对象id
	 * @param clazz 对象的class
	 * @param throwException 对象不存在的话是否抛出异常
	 * @param moduleName 如果抛出异常，提示信息
	 * @return
	 * @throws BusinessException
	 */
	public Object loadObjectById(String id, Class<?> clazz, boolean throwException, String moduleName)
				throws BusinessException;

	/**
	 * @author <a href="mailto:juan.liu@berheley.com">LiuJuan </a>
	 * @function:从session中清除对象
	 */
	public void clearObjectFromSession();

	void evictSecondLevelCache(Class<?> persistence);

	public List<Object> loadAll(Class<?> clz);

	/**
	 * @function:根据id串删除数据记录(置标志位:假删除)
	 * @param clz 所要删除数据的实体类名称
	 * @param ids id串
	 * @author: HeSong    2011-11-3 下午05:28:08
	 */
	public void deleteByIds(Class<?> clz, String ids);
}
