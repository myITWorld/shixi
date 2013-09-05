/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.persistence.dao.imp.ArticleDAO.java
 * Created on 2013-5-19-下午03:19:01
 */

package com.zoomkey.internship.persistence.dao.imp;

import java.util.List;

import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;

import com.zoomkey.internship.persistence.dao.IArticleDAO;
import com.zoomkey.internship.persistence.model.TArticle;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
 * Create:  2013-5-19 下午03:19:01
 */
public class ArticleDAO extends HibernateFacadeDAO implements IArticleDAO {

	/**
	 * @function:
	 * @param id
	 * @return
	 * @author: yangyikui    2013-5-20 下午02:08:32
	 */
	@Override
	public TArticle getObject(int id) {
		String hql = "FROM TArticle where id=?";
		Object[] args = {
			id};
		Type[] types = {
			new IntegerType()};
		return (TArticle) queryUniqueObject(hql, args, types);
	}

	/**
	 * @function:
	 * @param article
	 * @author: yangyikui    2013-5-20 下午02:26:59
	 */
	@Override
	public void saveArticle(TArticle article) {
		saveOrUpdate(article);
	}

	/**
	 * @function:根据用户id获得该用户所发表的所有文章
	 * @param userId 用户id
	 * @return
	 * @author: yangyikui    2013-5-24 上午08:58:32
	 */
	@Override
	public List getArticleOfUser(int userId) {
		// TODO Auto-generated method stub
		String hql = "FROM TArticle where TUser.id=? and status=1";
		Object[] args = {
			userId};
		Type[] types = {
			new IntegerType()};
		return query(hql, args, types);
	}

	/**
	 * @function:
	 * @param sectionId
	 * @return
	 * @author: yangyikui    2013-5-28 下午09:52:35
	 */
	@Override
	public List getArticle(int sectionId) {
		// String sql =
		// "SELECT ta.ID_ AS id, ta.IS_ESSENCE_  AS ess,ta.IS_TOP_ AS top,ta.TITLE_ AS title FROM t_article ta WHERE ta.SECTION_ID_=?";
		String sql = "SELECT  ta.id_ AS id, ta.is_essence_ AS essence ,ta.is_top_ AS top, ta.title_ AS title  "
					+ "FROM t_article ta "
					+ "WHERE ta.is_auditing_=1 "
					+ "AND ta.status_=1 "
					+ "AND ta.SECTION_ID_=? "
					+ "ORDER BY ta.IS_TOP_ DESC, ta.IS_ESSENCE_ DESC";
		Object[] args = {
			sectionId};
		Type[] types = {
			new IntegerType()};
		return findBySql(sql, args, types);
	}
}
