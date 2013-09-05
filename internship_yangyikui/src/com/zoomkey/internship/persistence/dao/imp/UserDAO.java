/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.persistence.dao.imp.UserDao.java
 * Created on 2013-5-7-下午03:45:12
 */

package com.zoomkey.internship.persistence.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;

import com.zoomkey.internship.persistence.dao.IUserDAO;
import com.zoomkey.internship.persistence.model.TUser;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-7 下午03:45:12
 */
public class UserDAO extends HibernateFacadeDAO implements IUserDAO {

	/**
	 * @function:登录，根据用户名密码查找用户
	 * @param tUser
	 * @return
	 * @author: YangYiKui    2013-5-7 下午03:45:12
	 */
	@Override
	public boolean isSuccessLogin(TUser tUser) {
		// TODO Auto-generated method stub
		String hql = "FROM TUser WHERE status='1' and  name=? and password =?";
		Object[] args = {
					tUser.getName(), tUser.getPassword()};
		Type[] types = {
					new StringType(), new StringType()};
		TUser tU = null;
		tU = (TUser) queryUniqueObject(hql, args, types);
		if (null != tU) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @function:根据用户名模糊查询
	 * @param name
	 * @return
	 * @author: YangYiKui    2013-5-8 下午02:09:44
	 */
	@Override
	public List getUser(String name) {
		// TODO Auto-generated method stub
		String hql = "SELECT tu.name,tu.status,tu.registerTime,ts.sectionName ,(case when tu.role='2' then '是' when tu.role != '2' then '否' end) "
					+ "FROM TUser tu,TSection ts "
					+ "WHERE tu.id= ts.userId and tu.name like ?";
		// 参数值
		Object[] args = {
			"%" + name + "%"};
		Type[] types = {
			new StringType()};
		List list = query(hql, args, types);
		return list;
	}

	/**
	 * @function:注册
	 * @param tUser
	 * @return
	 * @author: yangyikui    2013-5-9 下午12:44:13
	 */
	@Override
	public void saveInfo(TUser tUser) {
		saveOrUpdate(tUser);
	}

	/**
	 * @function:根据用户名查找用户，用于ajax验证
	 * @param name
	 * @return
	 * @author: yangyikui    2013-5-9 下午09:32:16
	 */
	@Override
	public boolean getName(String name) {
		String hql = "FROM TUser WHERE name = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, name);
		List list = query.list();
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @function:
	 * @return
	 * @author: yangyikui    2013-5-16 上午10:34:29
	 */
	@Override
	public List getUserName() {
		// TODO Auto-generated method stub
		String hql = "select new map(id as id,name as name) from TUser where status=1 and role=0";
		List list = query(hql);
		return list;
	}

	/**
	 * @function:根据用户的id改变用户的角色
	 * @param id
	 * @param role
	 * @author: yangyikui    2013-5-16 下午02:54:59
	 */
	@Override
	public void updateUserRole(int id, int role) {
		String sql = "update t_user tu set tu.role_=? where tu.id_=?";
		Object args[] = {
					role, id};
		Type[] types = {
					new IntegerType(), new IntegerType()};
		executeBySql(sql, args, types);
	}

	/**
	 * @function:
	 * @param name
	 * @return
	 * @author: yangyikui    2013-5-20 上午10:49:20
	 */
	@Override
	public TUser getObject(String name) {
		// TODO Auto-generated method stub
		String hql = "FROM TUser where name = ?";
		Object args[] = {
			name};
		Type[] types = {
			new StringType()};
		return (TUser) queryUniqueObject(hql, args, types);
	}

	/**
	 * @function:
	 * @param user
	 * @author: yangyikui    2013-5-23 下午04:37:41
	 */
	@Override
	public void updateUserInfo(TUser user) {
		update(user);
	}
}
