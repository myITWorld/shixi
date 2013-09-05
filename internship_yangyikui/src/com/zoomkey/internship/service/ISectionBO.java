/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.service.ISectionBO.java
 * Created on 2013-5-12-上午10:36:08
 */

package com.zoomkey.internship.service;

import java.util.List;

import com.zoomkey.internship.persistence.model.TSection;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-12 上午10:36:08
 */
public interface ISectionBO extends ICommonBO {

	/**
	 * @function:得到版块名称
	 * @return
	 * @author: YangYiKui    2013-5-12 上午10:41:43
	 */
	List getSectionName();

	/**
	 * @function:得到所有版块的名字
	 * @param isAu 是否审核参数
	 * @return
	 * @author: yangyikui    2013-5-19 下午03:38:08
	 */
	List getAllSectionName(int isAu);

	/**
	 * @function:得到所有版块名包括审核的和不审核的
	 * @return
	 * @author: yangyikui    2013-5-30 下午06:22:59
	 */
	List getAllSectionName();

	/**
	 * @function:设置版块的版主
	 * @param id
	 * @param sectionId
	 * @author: yangyikui    2013-5-15 上午11:37:35
	 */
	void updateSectionor(int id, int sectionId);

	/**
	 * @function:创建新版块
	 * @param tSection
	 * @author: yangyikui    2013-5-16 上午11:07:31
	 */
	void saveSectionInfo(TSection tSection);

	/**
	 * @function:删除版块名 （置位）
	 * @param idArrays
	 * @author: yangyikui    2013-5-16 下午01:43:57
	 */
	void optDeleteSection(String[] idArrays);

	/**
	 * @function:根据用户的id修改该用户的权限
	 * @param id    用户id
	 * @param role  权限
	 * @author: yangyikui    2013-5-17 下午02:27:18
	 */
	void updateRole(int id, int role);

	/**
	 * @function:
	 * @param sectionName
	 * @param isAuditing
	 * @param visitCredits
	 * @param id
	 * @author: yangyikui    2013-5-17 下午12:33:11
	 */
	void updateSectionInfo(String sectionName, int isAuditing, int visitCredits, String updateTime, int id);
}
