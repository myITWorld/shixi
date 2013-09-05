/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.service.imp.UserBO.java
 * Created on 2013-5-7-下午03:51:55
 */

package com.zoomkey.internship.service.imp;

import java.util.List;

import com.zoomkey.common.ConstantEnumDefine;
import com.zoomkey.internship.persistence.dao.ISectionDAO;
import com.zoomkey.internship.persistence.dao.IUserDAO;
import com.zoomkey.internship.persistence.model.TUser;
import com.zoomkey.internship.service.IUserBO;
import com.zoomkey.util.Utility;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-7 下午03:51:55
 */
public class UserBO extends CommonBO implements IUserBO {

	private final int		SECTION_OF_USERID	= 0;

	private IUserDAO		userDao;

	private ISectionDAO	sectionDao;

	public ISectionDAO getSectionDao() {
		return this.sectionDao;
	}

	public void setSectionDao(ISectionDAO sectionDao) {
		this.sectionDao = sectionDao;
	}

	public IUserDAO getUserDao() {
		return this.userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	/**
	 * @function:
	 * @param tUser
	 * @return
	 * @author: YangYiKui    2013-5-7 下午03:51:55
	 */
	@Override
	public boolean isSuccessLogin(TUser tUser) {
		// TODO Auto-generated method stub
		return this.userDao.isSuccessLogin(tUser);
	}

	/**
	 * @function:
	 * @param tUser
	 * @return
	 * @author: YangYiKui    2013-5-9 下午12:45:50
	 */
	@Override
	public void isSuccessRegister(TUser tUser) {
		// TODO Auto-generated method stub
		this.userDao.saveInfo(tUser);
	}

	/**
	 * @function:根据用户名确定该用户是否已经注册
	 * @param name
	 * @return
	 * @author: YangYiKui    2013-5-9 下午09:37:33
	 */
	@Override
	public boolean getName(String name) {
		// TODO Auto-generated method stub
		return this.userDao.getName(name);
	}

	/**
	 * @function:根据用户名模糊查询所有用户
	 * @param name
	 * @return
	 * @author: YangYiKui    2013-5-10 下午03:36:33
	 */
	@Override
	public List getUserInfo(String name) {
		// TODO Auto-generated method stub
		return this.userDao.getUser(name);
	}

	/**
	 * @function:屏蔽客户
	 * @param idArrays
	 * @author: yangyikui    2013-5-13 下午10:36:49
	 */
	@Override
	public void optShieldUser(String[] idArrays) {
		// TODO Auto-generated method stub
		for (String id : idArrays) {
			if (Utility.isNullOrEmpty(id)) {
				continue;
			}
			TUser userObj = (TUser) loadObjectById(TUser.class, id);
			// 设置用户的状态,可以反复操作，对于已经屏蔽的用户可以恢复正常，对于正常的用户可以屏蔽
			if (userObj.getStatus().equals("1")) {
				userObj.setStatus(ConstantEnumDefine.STATUS.屏蔽.getValue());
				// 设置用户的权限
				userObj.setRole(ConstantEnumDefine.ROLE.用户.getValue());
				// 设置该用户所在版块的userId为0
				this.sectionDao.updateSectionOfUserId(Utility.nullObjectToInteger(id), this.SECTION_OF_USERID);
			} else {
				userObj.setStatus(ConstantEnumDefine.STATUS.正常.getValue());
			}
			saveOrUpdate(userObj);
		}
	}

	/**
	 * @function:根据用户id修改用户的权限
	 * @param id
	 * @author: yangyikui    2013-5-15 上午11:17:51
	 */
	@Override
	public void updateRole(int id, int role) {
		this.userDao.updateUserRole(id, role);
	}

	/**
	 * @function:
	 * @return
	 * @author: yangyikui    2013-5-16 上午10:38:59
	 */
	@Override
	public List getUserNameInfo() {
		// TODO Auto-generated method stub
		return this.userDao.getUserName();
	}

	/**
	 * @function:
	 * @return
	 * @author: yangyikui    2013-5-20 上午10:54:02
	 */
	@Override
	public TUser getObjectOfTuser(String name) {
		// TODO Auto-generated method stub
		return this.userDao.getObject(name);
	}
}
