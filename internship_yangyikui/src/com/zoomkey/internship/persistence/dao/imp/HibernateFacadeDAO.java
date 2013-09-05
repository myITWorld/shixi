
package com.zoomkey.internship.persistence.dao.imp;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zoomkey.exception.DaoException;
import com.zoomkey.internship.persistence.dao.IFacadeDAO;

@SuppressWarnings("unchecked")
public class HibernateFacadeDAO extends HibernateDaoSupport implements IFacadeDAO {

	public SimpleJdbcTemplate	simpleJdbcTemplete;

	public SimpleJdbcTemplate getSimpleJdbcTemplete() {
		return this.simpleJdbcTemplete;
	}

	public void setSimpleJdbcTemplete(SimpleJdbcTemplate simpleJdbcTemplete) {
		this.simpleJdbcTemplete = simpleJdbcTemplete;
	}

	/**
	 * @function:清除hibernate的session缓存中的内容
	 * @author: zhaoxinchun    2013-4-17 上午10:12:39
	 */
	@Override
	public void clear() {
		this.getSession().clear();
	}

	/**
	 * @function:删除指定的实体类
	 * @param entity
	 * @author: zhaoxinchun    2013-4-17 上午10:13:16
	 */
	@Override
	public void delete(Object entity) {
		try {
			HibernateTemplate ht = getHibernateTemplate();
			ht.delete(entity);
			ht.flush();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	/**
	 * @function:通过hql查询，将查询出来的结果从数据库删除
	 * @param hql 查询语句
	 * @author: zhaoxinchun    2013-4-17 上午10:15:02
	 */
	@Override
	public void delete(String hql) {
		List<Object> list = this.query(hql);
		try {
			if (list != null && list.size() > 0) {
				getHibernateTemplate().deleteAll(list);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void deleteAll(Collection<?> collectionEntities) {
		try {
			getHibernateTemplate().deleteAll(collectionEntities);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void evict(Object entity) {
		try {
			getHibernateTemplate().evict(entity);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void evictSecondLevelCache(Class<?> persistentClass) {
		try {
			getSessionFactory().evict(persistentClass);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 根据sql执行。
	 * 
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void executeBySql(String sql) {
		try {
			Session s = this.getSession();
			Connection conn = s.connection();
			Statement statement;
			statement = conn.createStatement();
			statement.execute(sql);
			releaseSession(s);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void executeBySql(String sql, Object[] args, Type[] types) {
		try {
			Query query = this.getSession().createSQLQuery(sql);
			query.setParameters(args, types);
			query.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public <T> List<T> findBySql(String sql) {
		try {
			return this.findBySql(sql, 0);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public <T> List<T> findBySql(String sql, int count) {
		try {
			Session session = this.getSession();
			Query sqlQuery = session.createSQLQuery(sql);
			synchronized (sqlQuery) {
				if (count > 0) {
					sqlQuery.setMaxResults(count);
				}
				return sqlQuery.list();
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public <T> List<T> findBySql(String sql, Object[] args, Type[] types) {
		try {
			return this.findBySql(sql, args, types, 0);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public <T> List<T> findBySql(String sql, Object[] args, Type[] types, int maxSize) {
		try {
			Query query = this.getSession().createSQLQuery(sql);
			query.setParameters(args, types);
			if (maxSize > 0) {
				query.setMaxResults(maxSize);
			}
			return query.list();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	/**
	 * @function:
	 * @param sql
	 * @return
	 * @author: Liujuan 2009-2-18 下午05:55:10
	 */
	@Override
	public Object findBySqlUniqueObject(String sql, Object[] args, Type[] types) {
		List<?> list = this.findBySql(sql, args, types, 1);
		return resolveUniqueObject(list);
	}

	@Override
	public Object get(Class<?> clazz, Serializable id) {
		try {
			return getHibernateTemplate().get(clazz, id);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void init() {
		getHibernateTemplate().setCacheQueries(true);
	}

	@Override
	public <T> Iterator<T> iterate(String hql) {
		try {
			return getHibernateTemplate().iterate(hql);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Object load(Class<?> clazz, Serializable id) {
		try {
			return getHibernateTemplate().load(clazz, id);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public <T> List<T> loadAll(Class<T> entityClass) {
		try {
			return getHibernateTemplate().loadAll(entityClass);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Object loadNotLazy(Class<?> clazz, Serializable id) {
		try {
			Object o = getHibernateTemplate().get(clazz, id);
			getHibernateTemplate().initialize(o);
			return o;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public <T> List<T> query(String hql) {
		return query(hql, 0);
	}

	/**
	 * 分页查询,从第firstResult（从0开始）条开始，返回maxSize个记录。
	 */
	@Override
	public <T> List<T> query(String hql, int firstResult, int maxSize) {
		List<T> list1 = null;
		try {
			Session ss = this.getSession();
			Query q = ss.createQuery(hql);
			if (maxSize > 0) {
				// 分页
				q.setFirstResult(firstResult);
				q.setMaxResults(maxSize);
			}
			list1 = q.list();
			releaseSession(ss);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return list1;
	}

	@Override
	public <T> List<T> query(String hql, Integer maxSize) {
		try {
			HibernateTemplate ht = getHibernateTemplate();
			synchronized (ht) {
				ht.setMaxResults(maxSize);
				return ht.find(hql);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public <T> List<T> query(String hql, Object[] args, Type[] types) {
		return this.query(hql, args, types, 0);
	}

	public <T> List<T> query(String hql, Object[] args, Type[] types, Integer maxSize) {
		try {
			Query query = this.getSession().createQuery(hql);
			query.setParameters(args, types);
			if (maxSize > 0) {
				query.setMaxResults(maxSize);
			}
			return query.list();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public <T> List<T> queryByNamedParam(String hql, String[] args, Type[] types) {
		try {
			return getHibernateTemplate().findByNamedParam(hql, args, types);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	/**
	 * modifed by lisr:这个函数有问题，原先为直接获取所有的记录，再取第一条；现改为只查第一条
	 */
	@Override
	public Object queryUniqueObject(String hql) {
		List<?> list = query(hql, new Integer(1));
		return resolveUniqueObject(list);
	}

	public Object queryUniqueObject(String hql, Object[] args, Type[] types) {
		List<?> list = this.query(hql, args, types, 1);
		return resolveUniqueObject(list);
	}

	@Override
	public void refresh(Object obj) {
		try {
			getHibernateTemplate().flush();
			getHibernateTemplate().refresh(obj);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public Object resolveUniqueObject(List<?> list) {
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 保存
	 */
	@Override
	public void save(Object entity) {
		this.save(entity, false);
	}

	@Override
	public void save(Object entity, boolean removeFromCache) {
		try {
			HibernateTemplate ht = getHibernateTemplate();
			ht.save(entity);
			ht.flush();
			if (removeFromCache) {
				ht.evict(entity);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 保存
	 */
	@Override
	public void saveOrUpdate(Collection<?> co) {
		try {
			HibernateTemplate ht = getHibernateTemplate();
			ht.saveOrUpdateAll(co);
			ht.flush();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 保存、更新
	 */
	@Override
	public void saveOrUpdate(Object entity) {
		this.saveOrUpdate(entity, false);
	}

	/**
	 * 保存、更新
	 */
	@Override
	public void saveOrUpdate(Object entity, boolean removeFromCache) {
		try {
			HibernateTemplate ht = getHibernateTemplate();
			ht.saveOrUpdate(entity);
			ht.flush();
			if (removeFromCache) {
				ht.evict(entity);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	/**
	 * 更新
	 */
	@Override
	public void update(Object entity) {
		this.update(entity, false);
	}

	/**
	 * 更新
	 */
	@Override
	public void update(Object entity, boolean removeFromCache) {
		try {
			HibernateTemplate ht = getHibernateTemplate();
			ht.update(entity);
			ht.flush();
			if (removeFromCache) {
				ht.evict(entity);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	// 通过hql进行批量更新
	@Override
	public void update(String hql) {
		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql);
			query.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	/**
	 * [ZKP-74]
	 * 
	 * @function: 批量保存或者更新对象集合
	 * @param <T>
	 * @param entityList 需要更新的对象集合
	 * @param batchSize 批量更新的个数。即每几次操作更新到数据库。
	 * @author: Yuan Nan 2010-10-28 下午03:39:14
	 */
	@Override
	public <T> void batchSaveOrUpate(List<T> entityList, int batchSize) {
		try {
			Session session = this.getSession();
			int count = 0;
			for (T entity : entityList) {
				session.saveOrUpdate(entity);
				if (++count % batchSize == 0) {
					session.flush();
					session.clear();
					count = 0;
				}
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	/**
	 * @function: 对于带有别名的sql语句，使用该方法
	 * @param sql
	 * @return key为别名，value为结果的map
	 * @author: wangcheng    2011-12-28 下午12:45:41
	 */
	@Override
	public List<Map<String, Object>> findBySqlWithAlias(String sql) {
		try {
			Session session = this.getSession();
			Query sqlQuery = session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			return sqlQuery.list();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}