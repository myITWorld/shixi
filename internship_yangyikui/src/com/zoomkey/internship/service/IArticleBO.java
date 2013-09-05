/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.service.IArticleBO.java
 * Created on 2013-5-19-下午03:20:11
 */

package com.zoomkey.internship.service;

import java.util.List;

import com.zoomkey.internship.persistence.model.TArticle;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
 * Create:  2013-5-19 下午03:20:11
 */
public interface IArticleBO extends ICommonBO {

	/**
	 * @function:审核文章
	 * @param idArrays
	 * @author: yangyikui    2013-5-20 上午08:53:16
	 */
	void optAutidingArticle(String[] idArrays);

	/**
	 * @function:删除文章
	 * @param idArrays
	 * @author: yangyikui    2013-5-20 上午08:54:20
	 */
	void optDeleteArticle(String[] idArrays);

	/**
	 * @function:根据id获得文章详细信息
	 * @param id 文章id
	 * @author: yangyikui    2013-5-20 下午02:12:01
	 */
	TArticle getObjectOfTarticle(int id);

	/**
	 * @function:发表文章
	 * @param tArticle
	 * @author: yangyikui    2013-5-20 下午02:41:54
	 */
	void saveArticle(TArticle tArticle);

	/**
	 * @function:设置文章为精华
	 * @param idArrays
	 * @author: yangyikui    2013-5-20 下午05:23:37
	 */
	void optChangeArticleEss(String[] idArrays);

	/**
	 * @function:文章置顶
	 * @param id
	 * @author: yangyikui    2013-5-20 下午05:25:01
	 */
	void optArticleTop(int id);

	/**
	 * @function:获得某用户所发表的文章
	 * @param userId 用户id
	 * @return
	 * @author: yangyikui    2013-5-24 上午09:04:45
	 */
	List getArticleOfUser(int userId);

	/**
	 * @function:获得某版块下的文章
	 * @param sectionId
	 * @return
	 * @author: yangyikui    2013-5-28 下午09:55:43
	 */
	List getArticleOfSection(int sectionId);
}
