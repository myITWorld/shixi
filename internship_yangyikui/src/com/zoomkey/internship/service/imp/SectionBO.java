/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.service.imp.SectionBO.java
 * Created on 2013-5-12-上午10:42:48
 */

package com.zoomkey.internship.service.imp;

import java.util.List;

import com.zoomkey.common.ConstantEnumDefine;
import com.zoomkey.internship.persistence.dao.ISectionDAO;
import com.zoomkey.internship.persistence.dao.IUserDAO;
import com.zoomkey.internship.persistence.model.TSection;
import com.zoomkey.internship.service.ISectionBO;
import com.zoomkey.util.Utility;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-12 上午10:42:48
 */
public class SectionBO extends DeletableBO implements ISectionBO {

	ISectionDAO	sectionDao;

	IUserDAO		userDao;

	public IUserDAO getUserDao() {
		return this.userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	public ISectionDAO getSectionDao() {
		return this.sectionDao;
	}

	public void setSectionDao(ISectionDAO sectionDao) {
		this.sectionDao = sectionDao;
	}

	/**
	 * @function:
	 * @return
	 * @author: YangYiKui    2013-5-12 上午10:42:48
	 */
	@Override
	public List getSectionName() {
		// TODO Auto-generated method stub
		return this.sectionDao.getSectionName();
	}

	/**
	 * @function:根据版块的id修改对应用户的id
	 * @author: yangyikui    2013-5-14 下午04:59:49
	 */
	@Override
	public void updateSectionor(int id, int sectionId) {
		this.sectionDao.updateSectionOfModerator(id, sectionId);
	}

	/**
	 * @function:
	 * @param tSection
	 * @author: yangyikui    2013-5-16 上午11:07:47
	 */
	@Override
	public void saveSectionInfo(TSection tSection) {
		this.sectionDao.saveSectionInfo(tSection);
	}

	/**
	 * @function:删除版块（置状态位）
	 * @param idArrays
	 * @author: yangyikui    2013-5-16 下午01:44:39
	 */
	@Override
	public void optDeleteSection(String[] idArrays) {
		// TODO Auto-generated method stub
		for (String id : idArrays) {
			if (Utility.isNullOrEmpty(id)) {
				continue;
			}
			TSection sectionObj = (TSection) loadObjectById(TSection.class, id);
			sectionObj.setStatus(ConstantEnumDefine.STATUS.删除.getValue());// 设置版块的状态
			int userId = this.sectionDao.getUserId(Utility.nullObjectToInteger(id)).getUserId();
			updateRole(Utility.nullObjectToInteger(userId), ConstantEnumDefine.ROLE.用户.getValue());
			sectionObj.setUserId(0);
			// this.userDao.updateUserRole(Utility.nullObjectToInteger(id), 0);
			saveOrUpdate(sectionObj);
		}
	}

	/**
	 * @function:根据id修改用户权限
	 * @param id
	 * @param role
	 * @author: yangyikui    2013-5-16 下午04:36:55
	 */
	@Override
	public void updateRole(int id, int role) {
		this.userDao.updateUserRole(id, role);
	}

	/**
	 * @function:修改版块
	 * @param sectionName
	 * @param isAuditing
	 * @param visitCredits
	 * @param id
	 * @author: yangyikui    2013-5-17 下午12:33:21
	 */
	@Override
	public void updateSectionInfo(String sectionName, int isAuditing, int visitCredits, String updateTime, int id) {
		this.sectionDao.updateSectionInfo(sectionName, isAuditing, visitCredits, updateTime, id);
	}

	/**
	 * @function:得到所有版块的名字
	 * @return
	 * @author: yangyikui    2013-5-19 下午03:38:31
	 */
	@Override
	public List getAllSectionName(int isAu) {
		// TODO Auto-generated method stub
		return this.sectionDao.getAllSectionName(isAu);
	}

	/**
	 * @function:
	 * @return
	 * @author: yangyikui    2013-5-30 下午06:23:32
	 */
	@Override
	public List getAllSectionName() {
		// TODO Auto-generated method stub
		return this.sectionDao.getAllSectionName();
	}
}
