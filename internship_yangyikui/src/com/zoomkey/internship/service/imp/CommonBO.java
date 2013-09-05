
package com.zoomkey.internship.service.imp;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zoomkey.bean.IModifiableObj;
import com.zoomkey.exception.BusinessException;
import com.zoomkey.internship.persistence.dao.ICommonDAO;
import com.zoomkey.internship.persistence.dao.IFacadeDAO;
import com.zoomkey.internship.service.ICommonBO;
import com.zoomkey.servlet.ApplicationContextKeeper;

/**
 * 类功能描述：
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public class CommonBO implements ICommonBO {

	/** Commons logger. */
	private static final Log		LOGGER					= LogFactory.getLog(CommonBO.class);

	private static final String	QUERY_INTEGER_DILIM	= ",";

	/**
	 * DAO属性的set/get
	 */
	public IFacadeDAO					commonDao;

	public ICommonDAO					comDao;

	@Override
	public IFacadeDAO getCommonDao() {
		return this.commonDao;
	}

	public void setCommonDao(IFacadeDAO dao) {
		this.commonDao = dao;
	}

	@Override
	public final void clearObjectFromSession() {
		this.commonDao.clear();
	}

	@Override
	public final void evictSecondLevelCache(Class<?> persistence) {
		this.commonDao.evictSecondLevelCache(persistence);
	}

	@Override
	@SuppressWarnings("unchecked")
	public final List<Object> loadAll(Class<?> clz) {
		return (List<Object>) this.commonDao.loadAll(clz);
	}

	private Integer getPrimaryKey(Serializable id) {
		Integer objId = null;
		if (id instanceof Integer) {
			objId = (Integer) id;
		} else if (id instanceof String) {
			try {
				objId = Integer.valueOf((String) id);
			} catch (NumberFormatException e) {
				LOGGER.debug("Object Id = " + id + "'，Exception:", e);
			}
		}
		return objId;
	}

	@Override
	public final Object getObjectById(Class<?> clazz, Serializable id) throws BusinessException {
		Integer objId = getPrimaryKey(id);
		Object obj = null;
		if (objId != null) {
			obj = this.commonDao.get(clazz, objId);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Start to get Object Class '" + clazz + "', Id = " + objId + "'");
			}
		}
		if (obj == null) {
			try {
				obj = clazz.newInstance();
			} catch (Exception e) {
				LOGGER.debug("newInstance Object Class '" + clazz + "', Exception : ", e);
			}
		}
		return obj;
	}

	@Override
	public final Object loadObjectById(Class<?> clazz, Serializable id) throws BusinessException {
		Integer objId = getPrimaryKey(id);
		Object obj = null;
		if (objId != null) {
			obj = this.commonDao.load(clazz, objId);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Start to load Object Class '" + clazz + "', Id = " + objId + "'");
			}
		}
		if (obj == null) {
			try {
				obj = clazz.newInstance();
			} catch (Exception e) {
				LOGGER.debug("newInstance Object Class '" + clazz + "', Exception : ", e);
			}
		}
		return obj;
	}

	@Override
	public final Object loadObjectById(String id, Class<?> clazz, boolean throwException, String moduleName)
				throws BusinessException {
		if (id == null || id.trim().length() < 1) {
			if (throwException) {
				throwSimpleNotExist(moduleName);
			} else {
				return null;
			}
		}
		Object o = this.commonDao.get(clazz, id);
		boolean isNull = true;
		if (o != null) {
			Method meth;
			try {
				meth = o.getClass().getMethod("getId");
				if (meth != null) {
					Object retobj = meth.invoke(o);
					if (retobj != null && retobj.toString().length() > 0) {
						isNull = false;
					}
				}
			} catch (Exception e) {
			}
		}
		if (isNull && throwException) {
			throwSimpleNotExist(moduleName);
		}
		return o;
	}

	@Override
	public void optCreate(Object o) throws BusinessException {
		if (isHavePrimaryKeyValue(o)) {
			throw new BusinessException("对象已经存在");
		}
		this.commonDao.save(o, true);
	}

	public void additonalCheckBeforeDelete(Object o) throws BusinessException {
	}

	@Override
	public void optDelete(Object o) throws BusinessException {
		if (!isHavePrimaryKeyValue(o)) {
			throw new BusinessException("对象不存在");
		}
		this.commonDao.delete(o);
	}

	@Override
	public void optModify(Object o) throws BusinessException {
		if (!isHavePrimaryKeyValue(o)) {
			throw new BusinessException("对象不存在");
		}
		this.commonDao.update(o, true);
	}

	@Override
	public void optModify(IModifiableObj o) throws BusinessException {
		Serializable id = o.getId();
		if (id == null || String.valueOf(id) == null || String.valueOf(id).trim().length() < 1) {
			throw new BusinessException("对象不存在");
		}
		// 需要返回真实对象而不是缓存对象
		this.commonDao.evict(o);
		IModifiableObj objIndb = (IModifiableObj) getObjectById(o.getClass(), id);
		// 如果取到的仍为代理对象，则将其移出缓存，查询数据库对象
		if (objIndb != null && objIndb.getClass().getName().contains("CGLIB$$")) {
			this.commonDao.evict(objIndb);
			objIndb = (IModifiableObj) getObjectById(o.getClass(), id);
		}
		if (objIndb == null) {
			throw new BusinessException("对象不存在");
		}
		objIndb.change(o);
		this.commonDao.update(objIndb, true);
	}

	@Override
	public void saveOrUpdate(Object o) {
		this.commonDao.saveOrUpdate(o);
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
			if (retobj != null && !retobj.toString().trim().equals("") && !retobj.toString().trim().equals("0")) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}// 若方法直接产生异常，则直接返回实体不存在
		return false;
	}

	protected void throwSimpleNotExist(String moduleName) throws BusinessException {
		throw new BusinessException(moduleName + "不存在");
	}

	/**
	 * spring 获取注入的bean
	 * 
	 * @param serviceBeanName
	 * @return
	 */
	public Object getService(String serviceBeanName) {
		return ApplicationContextKeeper.getAppCtx().getBean(serviceBeanName);
	}

	/**
	 * @function:根据id串删除数据记录(置标志位:假删除)
	 * @param clz 所要删除数据的实体类名称
	 * @param ids id串
	 * @author: HeSong    2011-11-3 下午05:28:08
	 */
	@Override
	public void deleteByIds(Class<?> clz, String ids) {
		this.comDao.deleteByIds(clz, ids);
	}

	public ICommonDAO getComDao() {
		return this.comDao;
	}

	public void setComDao(ICommonDAO comDao) {
		this.comDao = comDao;
	}
}
