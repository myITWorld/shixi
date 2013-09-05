/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.persistence.dao.IArticleBO.java
 * Created on 2013-5-19-下午03:17:52
 */

package com.zoomkey.internship.persistence.dao;

import java.util.List;

import com.zoomkey.internship.persistence.model.TArticle;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
 * Create:  2013-5-19 下午03:17:52
 */
public interface IArticleDAO {

	/**
	 * @function:根据id获得文章详细信息
	 * @param id
	 * @return
	 * @author: yangyikui    2013-5-20 下午02:14:58
	 */
	TArticle getObject(int id);

	/**
	 * @function:发文章
	 * @param article
	 * @author: yangyikui    2013-5-20 下午02:26:49
	 */
	void saveArticle(TArticle article);

	/**
	 * @function:根据用户id获得该用户所发的文章
	 * @param userId
	 * @return
	 * @author: yangyikui    2013-5-24 上午08:55:55
	 */
	List getArticleOfUser(int userId);

	/**
	 * @function:获得某版块下的文章
	 * @param sectionId
	 * @return
	 * @author: yangyikui    2013-5-28 下午09:52:12
	 */
	List getArticle(int sectionId);
}
