
package com.zoomkey.internship.persistence.dao;

public interface IJdbcDAO
{

	/**
	 * @function:批量执行sql
	 * @param sql
	 * @return true：正常；false：异常；
	 * @author: Liujuan 2009-3-17 下午01:59:15
	 */
	public boolean execute(String[] sql);

	/**
	 * @function:批量执行sql(返回受影响记录的id数组)
	 * @param sql
	 * @return 每一条sql影响行数的数组
	 * @author: WangCheng  [ZKP-108]  2011-1-6 下午01:32:48
	 */
	public int[] executeWithInfluenceRowsReturn(String[] sql);
}
