/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms-cvs
 * com.berheley.hcms.service.imp.DeletableBO.java
 * Created on 2009-1-13-下午04:11:02
 */

package com.zoomkey.internship.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zoomkey.bean.IDeletableObj;
import com.zoomkey.bean.IPrimaryKey;
import com.zoomkey.exception.BusinessException;
import com.zoomkey.internship.service.IDeletableBO;
import com.zoomkey.util.Utility;

/**
 * 类功能描述：
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public class DeletableBO extends CommonBO implements IDeletableBO {

	/** Commons logger. */
	private static final Log	LOGGER	= LogFactory.getLog(DeletableBO.class);

	public void enableStatus(IDeletableObj obj) {
		obj.setStatus("1");
	}

	public void disableStatus(IDeletableObj obj) {
		obj.setStatus("0");
	}

	@Override
	public IDeletableObj optCreate(IDeletableObj obj) throws BusinessException {
		if (isHavePrimaryKeyValue(obj)) {
			throw new BusinessException("对象已经存在");
		}
		enableStatus(obj);
		this.commonDao.save(obj, true);
		this.commonDao.clear();
		return obj;
	}

	/**
	 * 
	 * @function:批量删除对象：假删除，设置状态为删除状态
	 * @param ids
	 * @param clz
	 * @throws BusinessException
	 * @author: GaoJiayuan    2013-2-26 下午05:07:30
	 */
	@Override
	public void optDelete(String ids, Class<? extends IDeletableObj> clz) throws BusinessException {
		String className = clz.getName();
		if (Utility.isNull(ids)) {
			LOGGER.info("没有需要删除的对象" + className);
			return;
		}
		String hql = "update " + className + " t set t.status ='0' where t.id in (" + ids + ")";
		this.commonDao.update(hql);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<? extends IDeletableObj> loadAllEnabled(Class<? extends IDeletableObj> clz) {
		String className = clz.getName();
		String hql = "from " + className + " t where t.status ='1' order by t.id desc";
		return this.commonDao.query(hql);
	}

	/**
	 * 判断参数对象实体是否在数据库中已经存在，通过反射方式判断，若该实体根本没有ID属性，则直接返回false
	 * 
	 * @throws InvocationTargetException
	 */
	@Override
	public boolean isHavePrimaryKeyValue(Object o) {
		try {
			Method meth = o.getClass().getMethod("getId");
			if (meth == null) {
				return false;
			}
			Object retobj = meth.invoke(o);
			if (retobj != null && !retobj.toString().trim().equals("")) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}// 若方法直接产生异常，则直接返回实体不存在
		return false;
	}

	/**
	 * @function 判断对象是否有主键，从而判断是新建记录还是修改记录
	 * @param intObj model对象
	 * @return 如果getId()不为空，则返回true否则返回false。
	 */
	public boolean isHavePrimaryKeyValue(IPrimaryKey intObj) {
		if (intObj == null) {
			return false;
		}
		Integer value = intObj.getId();
		if (value == null || value.intValue() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void optCorrectObjId(IPrimaryKey intObj) {
		if (!isHavePrimaryKeyValue(intObj)) {
			intObj.setId(null);
		}
	}

	/**
	 * @function: 删除对象：假删除，设置状态为删除状态
	 * @param obj
	 * @author: wangcheng    2011-3-11 下午04:41:40
	 */
	@Override
	public void optDelete(IDeletableObj obj) {
		// 设置对象状态为删除
		disableStatus(obj);
		// 更新数据库
		saveOrUpdate(obj);
	}
}
