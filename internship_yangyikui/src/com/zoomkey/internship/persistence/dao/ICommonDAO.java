
package com.zoomkey.internship.persistence.dao;

/**
 * 
 * 类功能描述：
 *
 * @author <a href="mailto:gaojiayuan@zoomkey.com.cn">GaoJiayuan</a>
 * Create:  2013-3-6 下午03:59:04
 */
public interface ICommonDAO {

	/**
	 * 
	 * @function:根据ID和类名，将status置位，以实现假删除
	 * @param clz
	 * @param ids
	 * @author: GaoJiayuan    2013-3-7 下午01:32:09
	 */
	public void deleteByIds(Class<?> clz, String ids);
}
