/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.service.imp.ArticleBO.java
 * Created on 2013-5-19-下午03:21:00
 */

package com.zoomkey.internship.service.imp;

import java.util.List;

import com.zoomkey.common.ConstantEnumDefine;
import com.zoomkey.internship.persistence.dao.IArticleDAO;
import com.zoomkey.internship.persistence.dao.ISectionDAO;
import com.zoomkey.internship.persistence.model.TArticle;
import com.zoomkey.internship.service.IArticleBO;
import com.zoomkey.util.DateHelper;
import com.zoomkey.util.Utility;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
 * Create:  2013-5-19 下午03:21:00
 */
public class ArticleBO extends CommonBO implements IArticleBO {

	private IArticleDAO	articleDao;

	private ISectionDAO	sectionDao;

	public ISectionDAO getSectionDao() {
		return this.sectionDao;
	}

	public void setSectionDao(ISectionDAO sectionDao) {
		this.sectionDao = sectionDao;
	}

	public IArticleDAO getArticleDao() {
		return this.articleDao;
	}

	public void setArticleDao(IArticleDAO articleDao) {
		this.articleDao = articleDao;
	}

	/**
	 * @function:审核文章
	 * @author: yangyikui    2013-5-19 下午04:31:41
	 */
	@Override
	public void optAutidingArticle(String[] idArrays) {
		// TODO Auto-generated method stub
		for (String id : idArrays) {
			if (Utility.isNullOrEmpty(id)) {
				continue;
			}
			TArticle articlerObj = (TArticle) loadObjectById(TArticle.class, id);
			if (articlerObj.getIsAuditing().equals("0")) {
				articlerObj.setIsAuditing(ConstantEnumDefine.AUDIRING.审核通过.getValue());
			} else {
				articlerObj.setIsAuditing(ConstantEnumDefine.AUDIRING.审核不通过.getValue());
			}
			saveOrUpdate(articlerObj);
		}
	}

	/**
	 * @function:删除文章
	 * @param idArrays 获得的文章id
	 * @author: yangyikui    2013-5-20 上午08:54:38
	 */
	@Override
	public void optDeleteArticle(String[] idArrays) {
		for (String id : idArrays) {
			if (Utility.isNullOrEmpty(id)) {
				continue;
			}
			TArticle article = (TArticle) loadObjectById(TArticle.class, id);
			article.setStatus(ConstantEnumDefine.STATUS.删除.getValue());
			saveOrUpdate(article);
		}
	}

	/**
	 * @function:根据id获得文章详细信息
	 * @param id
	 * @author: yangyikui    2013-5-20 下午02:11:15
	 */
	@Override
	public TArticle getObjectOfTarticle(int id) {
		return this.articleDao.getObject(id);
	}

	/**
	 * @function:发表文章
	 * @param tArticle
	 * @author: yangyikui    2013-5-20 下午02:42:09
	 */
	@Override
	public void saveArticle(TArticle tArticle) {
		this.articleDao.saveArticle(tArticle);
	}

	/**
	 * @function:精华
	 * @param idArrays
	 * @author: yangyikui    2013-5-20 下午05:25:15
	 */
	@Override
	public void optChangeArticleEss(String[] idArrays) {
		// TODO Auto-generated method stub
		for (String id : idArrays) {
			if (Utility.isNullOrEmpty(id)) {
				continue;
			}
			TArticle articlerObj = (TArticle) loadObjectById(TArticle.class, id);
			if (articlerObj.getIsEssence().equals(ConstantEnumDefine.ESS.非精华.getValue())) {
				articlerObj.setIsEssence(ConstantEnumDefine.ESS.精华.getValue());
			} else {
				articlerObj.setIsEssence(ConstantEnumDefine.ESS.非精华.getValue());
			}
			saveOrUpdate(articlerObj);
		}
	}

	/**
	 * @function:置顶
	 * @param idArrays
	 * @author: yangyikui    2013-5-20 下午05:25:15
	 */
	@Override
	public void optArticleTop(int id) {
		// TODO Auto-generated method stub
		// for (String id : idArrays) {
		// if (Utility.isNullOrEmpty(id)) {
		// continue;
		// }
		TArticle articlerObj = (TArticle) loadObjectById(TArticle.class, id);
		if (articlerObj.getIsTop().equals(ConstantEnumDefine.TOP.非置顶.getValue())) {
			articlerObj.setIsTop(ConstantEnumDefine.TOP.置顶.getValue());
		} else {
			articlerObj.setIsTop(ConstantEnumDefine.TOP.非置顶.getValue());
		}
		articlerObj.setUpdateTime(DateHelper.getSimpleFormatedDateNow());
		saveOrUpdate(articlerObj);
		// }
	}

	/**
	 * @function:
	 * @param userId
	 * @return
	 * @author: yangyikui    2013-5-24 上午09:05:12
	 */
	@Override
	public List getArticleOfUser(int userId) {
		// TODO Auto-generated method stub
		return this.articleDao.getArticleOfUser(userId);
	}

	/**
	 * @function:
	 * @param sectionId
	 * @return
	 * @author: yangyikui    2013-5-28 下午09:56:05
	 */
	@Override
	public List getArticleOfSection(int sectionId) {
		// TODO Auto-generated method stub
		return this.articleDao.getArticle(sectionId);
	}
}
