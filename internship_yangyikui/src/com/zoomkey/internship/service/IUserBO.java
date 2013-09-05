/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.service.IUserBO.java
 * Created on 2013-5-7-下午03:50:54
 */

package com.zoomkey.internship.service;

import java.util.List;

import com.zoomkey.internship.persistence.model.TUser;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-7 下午03:50:54
 */
/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-10 下午03:35:19
 */
/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-10 下午03:35:22
 */
public interface IUserBO extends ICommonBO {

	/**
	 * @function:登录
	 * @param tUser
	 * @return
	 * @author: YangYiKui    2013-5-10 上午09:08:33
	 */
	boolean isSuccessLogin(TUser tUser);

	/**
	 * @function:注册
	 * @param tUser
	 * @author: YangYiKui    2013-5-10 上午09:08:49
	 */
	void isSuccessRegister(TUser tUser);

	/**
	 * @function:根据用户名查找用户
	 * @param name 用户名
	 * @return
	 * @author: YangYiKui    2013-5-10 上午09:09:14
	 */
	boolean getName(String name);

	/**
	 * @function:根据用户名模糊查询返回List
	 * @param name 用户名
	 * @return
	 * @author: YangYiKui    2013-5-10 下午03:35:41
	 */
	List getUserInfo(String name);

	/**
	 * @function:屏蔽客户（置状态位）
	 * @param idArrays
	 * @author: yangyikui    2013-5-13 下午10:35:56
	 */
	void optShieldUser(String[] idArrays);

	/**
	 * @function:根据用户名修改用户的权限
	 * @param id
	 * @author: yangyikui    2013-5-15 上午11:17:17
	 */
	void updateRole(int id, int role);

	/**
	 * @function:得到用户的列表
	 * @return
	 * @author: yangyikui    2013-5-16 上午10:38:30
	 */
	List getUserNameInfo();

	TUser getObjectOfTuser(String name);
}
