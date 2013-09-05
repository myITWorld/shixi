/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.persistence.dao.ISectionDAO.java
 * Created on 2013-5-12-上午10:37:39
 */

package com.zoomkey.internship.persistence.dao;

import java.util.List;

import com.zoomkey.internship.persistence.model.TSection;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-12 上午10:37:39
 */
public interface ISectionDAO {

	/**
	 * @function:得到版块名称(版块版主没指定)
	 * @return
	 * @author: YangYiKui    2013-5-12 上午10:28:20
	 */
	List getSectionName();

	/**
	 * @function:得到所有版块名
	 * @param isAu  是否审核
	 * @return
	 * @author: yangyikui    2013-5-30 下午06:21:05
	 */
	List getAllSectionName(int isAu);

	/**得到所有版块名不区分审核否
	 * @function:
	 * @return
	 * @author: yangyikui    2013-5-30 下午06:20:46
	 */
	List getAllSectionName();

	/**
	* @function:修改版块的版主
	* @param id
	* @author: yangyikui    2013-5-14 下午04:33:28
	*/
	void updateSectionOfModerator(int id, int sectionId);

	/**
	 * @function:创建新版块
	 * @param tSection
	 * @author: yangyikui    2013-5-16 上午11:05:08
	 */
	void saveSectionInfo(TSection tSection);

	/**
	 * @function:
	 * @param id 用户id
	 * @param role 权限值
	 * @author: yangyikui    2013-5-16 下午02:54:09
	 */
	void updateUserRole(int id, int role);

	/**
	 * @function:根据版块id得到用户id
	 * @param id
	 * @author: yangyikui    2013-5-16 下午05:01:52
	 */
	TSection getUserId(int id);

	/**
	 * @function:根据版块id修改版块信息
	 * @param sectionName  版块名
	 * @param isAuditing   是否审核
	 * @param visitCredits 访问积分
	 * @param updateTime   修改时间
	 * @param id           版块id
	 * @author: yangyikui    2013-5-17 上午11:15:51
	 */
	void updateSectionInfo(String sectionName, int isAuditing, int visitCredits, String updateTime, int id);

	/**
	 * @function:当屏蔽用户是，如果该用户是版主，则该版块对应的id设为0
	 * @param userId	用户id
	 * @author: yangyikui    2013-5-17 下午02:30:13
	 */
	void updateSectionOfUserId(int userId, int value);
}
