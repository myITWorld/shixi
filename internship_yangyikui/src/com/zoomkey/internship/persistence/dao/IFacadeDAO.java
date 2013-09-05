
package com.zoomkey.internship.persistence.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateTemplate;

public interface IFacadeDAO {

	/**
	 * @function:从session中清除对象
	 */
	public void clear();

	public void delete(Object entity);

	public void delete(String hql);

	public void deleteAll(Collection<?> collectionEntities);

	public void evict(Object entity);

	public void evictSecondLevelCache(Class<?> persistentClass);

	public void executeBySql(String sql);

	public void executeBySql(String sql, Object[] args, Type[] types);

	public <T> List<T> findBySql(String sql);

	public <T> List<T> findBySql(String sql, int count);

	public <T> List<T> findBySql(String sql, Object[] args, Type[] types);

	public <T> List<T> findBySql(String sql, Object[] args, Type[] types, int maxSize);

	public Object findBySqlUniqueObject(String sql, Object[] args, Type[] types);

	public Object get(Class<?> clazz, Serializable id);

	public HibernateTemplate getHibernateTemplate();

	public void init();

	public <T> Iterator<T> iterate(String hql);

	public Object load(Class<?> clazz, Serializable id);

	public <T> List<T> loadAll(Class<T> entityClass);

	// 加载对象的所有属性
	public Object loadNotLazy(Class<?> clazz, Serializable id);

	public <T> List<T> query(String hql);

	/**
	 * 分页查询,从第firstResult（从0开始）条开始，返回maxSize个记录
	 */
	public <T> List<T> query(String hql, int firstResult, int maxSize);

	// 按照查询条件查询出maxSize条记录
	public <T> List<T> query(String hql, Integer maxSize);

	public <T> List<T> query(String hql, Object[] args, Type[] types);

	public <T> List<T> queryByNamedParam(String hql, String[] args, Type[] types);

	// 只让结果返回一个对象
	public Object queryUniqueObject(String hql);

	public void refresh(Object obj);

	public void save(Object entity);

	public void save(Object entity, boolean removeFromCache);

	/**
	 * @function: 保存多个对象
	 * @param co
	 */
	public void saveOrUpdate(Collection<?> co);

	public void saveOrUpdate(Object entity);

	public void saveOrUpdate(Object entity, boolean removeFromCache);

	public void update(Object entity);

	public void update(Object entity, boolean removeFromCache);

	public void update(String hql);

	/**
	 * [ZKP-74]
	 * 
	 * @function: 批量保存或者更新对象集合
	 * @param <T>
	 * @param entityList 需要更新的对象集合
	 * @param batchSize 批量更新的个数。即每几次操作更新到数据库。
	 * @author: Yuan Nan 2010-10-28 下午03:39:14
	 */
	<T> void batchSaveOrUpate(List<T> entityList, int batchSize);

	/**
	 * @function: 对于带有别名的sql语句，使用该方法
	 * @param sql
	 * @return key为别名，value为结果的map
	 * @author: wangcheng    2011-12-28 下午12:45:41
	 */
	List<Map<String, Object>> findBySqlWithAlias(String sql);
}
