/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.persistence.dao.imp.SectionDAO.java
 * Created on 2013-5-12-上午10:38:40
 */

package com.zoomkey.internship.persistence.dao.imp;

import java.util.List;

import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;

import com.zoomkey.internship.persistence.dao.ISectionDAO;
import com.zoomkey.internship.persistence.model.TSection;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-12 上午10:38:40
 */
public class SectionDAO extends HibernateFacadeDAO implements ISectionDAO {

	/**
	 * @function:得到版块名称显示到下拉菜单里(显示版块没有版主的)
	 * @return
	 * @author: yangyikui    2013-5-12 上午10:28:52
	 */
	@Override
	public List getSectionName() {
		// TODO Auto-generated method stub
		String hql = "select new map(id as id, sectionName as name)  from TSection where status = 1 and userId=0";
		List list = query(hql);
		return list;
	}

	/**
	 * @function:根据版块id设置对应的用户id
	 * @param id 版块表中的用户id
	 * @param sectionId 版块id
	 * @author: yangyikui    2013-5-14 下午04:34:14
	 */
	@Override
	public void updateSectionOfModerator(int id, int sectionId) {
		String sql = " update t_section ts set ts.user_id_ =? where ts.id_=?";
		Object[] args = {
					id, sectionId};
		Type[] types = {
					new IntegerType(), new IntegerType()};
		executeBySql(sql, args, types);
	}

	/**
	 * @function:创建新版块
	 * @param tSection
	 * @author: yangyikui    2013-5-16 上午11:05:33
	 */
	@Override
	public void saveSectionInfo(TSection tSection) {
		// TODO Auto-generated method stub
		save(tSection);
	}

	/**
	 * @function:
	 * @param id
	 * @param role
	 * @author: yangyikui    2013-5-16 下午04:35:32
	 */
	@Override
	public void updateUserRole(int id, int role) {
		String sql = "update t_user tu set role_=? where tu.id_=?";
		Object args[] = {
					role, id};
		Type[] types = {
					new IntegerType(), new IntegerType()};
		executeBySql(sql, args, types);
	}

	/**
	 * @function:
	 * @param id
	 * @author: yangyikui    2013-5-16 下午05:02:17
	 */
	@Override
	public TSection getUserId(int id) {
		String hql = " FROM TSection WHERE id=?";
		Object args[] = {
			id};
		Type[] types = {
			new IntegerType()};
		return (TSection) queryUniqueObject(hql, args, types);
	}

	/**
	 * @function:
	 * @param sectionName
	 * @param isAuditing
	 * @param visitCredits
	 * @param id
	 * @author: yangyikui    2013-5-17 下午12:28:03
	 */
	@Override
	public void updateSectionInfo(String sectionName, int isAuditing, int visitCredits, String updateTime, int id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE t_section ts "
					+ "SET ts.section_name_=?,ts.is_auditing_=? ,ts.visit_credits_=?,ts.update_time_=? "
					+ "WHERE ts.ID_=?";
		Object args[] = {
					sectionName, isAuditing, visitCredits, updateTime, id};
		Type[] types = {
					new StringType(), new IntegerType(), new IntegerType(), new StringType(), new IntegerType()};
		executeBySql(sql, args, types);
	}

	/**
	 * @function:
	 * @param userId
	 * @author: yangyikui    2013-5-17 下午02:31:15
	 */
	@Override
	public void updateSectionOfUserId(int userId, int value) {
		String sql = "update t_section ts set ts.user_id_=? where ts.user_id_=? ";
		Object args[] = {
					value, userId};
		Type[] types = {
					new IntegerType(), new IntegerType()};
		executeBySql(sql, args, types);
	}

	/**
	 * @function:获得所有版块
	 * @param isAu审核
	 * @return
	 * @author: yangyikui    2013-5-30 下午05:56:23
	 */
	@Override
	public List getAllSectionName(int isAu) {
		String hql = "select new map(id as id, sectionName as name)  from TSection where status = 1 and isAuditing=?";
		Object args[] = {
			isAu};
		Type[] types = {
			new IntegerType()};
		List list = query(hql, args, types);
		return list;
	}

	/**
	 * @function:
	 * @return
	 * @author: yangyikui    2013-5-30 下午06:22:08
	 */
	@Override
	public List getAllSectionName() {
		String hql = "select new map(id as id, sectionName as name)  from TSection where status = 1 ";
		List list = query(hql);
		return list;
	}
}
