/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.persistence.dao.IUserDao.java
 * Created on 2013-5-7-下午03:43:52
 */

package com.zoomkey.internship.persistence.dao;

import java.util.List;

import com.zoomkey.internship.persistence.model.TUser;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-7 下午03:43:52
 */
/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-9 下午09:31:12
 */
/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-12 上午10:28:12
 */
/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-12 上午10:28:16
 */
public interface IUserDAO {

	/**
	 * @function:判断登录
	 * @param tUser
	 * @return
	 * @author: YangYiKui    2013-5-8 下午01:58:26
	 */
	boolean isSuccessLogin(TUser tUser);

	/**
	 * @function:根据用户名模糊查询
	 * @param name
	 * @return
	 * @author: YangYiKui    2013-5-8 下午02:10:08
	 */
	List getUser(String name);

	/**
	 * @function:根据用户名找对象
	 * @param name
	 * @return
	 * @author: yangyikui    2013-5-20 上午10:48:39
	 */
	TUser getObject(String name);

	/**
	 * @function:注册
	 * @param tUser
	 * @return
	 * @author: YangYiKui    2013-5-9 下午09:20:55
	 */
	void saveInfo(TUser tUser);

	/**
	 * @function:根据用户名查看该用户是否注册过
	 * @param name
	 * @return
	 * @author: YangYiKui    2013-5-9 下午09:31:19
	 */
	boolean getName(String name);

	/**
	 * @function:根据用户的id修改该用户的权限
	 * @param id 用户id
	 * @param role 权限值
	 * @author: yangyikui    2013-5-16 下午02:54:09
	 */
	void updateUserRole(int id, int role);

	/**
	 * @function:得到用户的名单
	 * @return
	 * @author: yangyikui    2013-5-16 上午10:34:00
	 */
	List getUserName();

	void updateUserInfo(TUser user);
}
