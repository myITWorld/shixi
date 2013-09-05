
package com.zoomkey.internship.persistence.dao.imp;

import com.zoomkey.internship.persistence.dao.ICommonDAO;

/**
 * 
 * 类功能描述：
 *
 * @author <a href="mailto:gaojiayuan@zoomkey.com.cn">GaoJiayuan</a>
 * Create:  2013-3-6 下午04:08:57
 */
public class CommonDAO extends HibernateFacadeDAO implements ICommonDAO {

	/**
	 * 
	 * @function:根据ID和类名，将status置位，以实现假删除
	 * @param clz
	 * @param ids
	 * @author: GaoJiayuan    2013-3-7 下午01:32:09
	 */
	@Override
	public void deleteByIds(Class<?> clz, String ids) {
		String hql = "UPDATE " + clz.getName() + " SET status='0' WHERE id IN (" + ids + ")";
		update(hql);
	}
}
