
package com.zoomkey.internship.persistence.dao.imp;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.support.lob.LobHandler;

import com.zoomkey.internship.persistence.dao.IJdbcDAO;

/**
 * 类功能描述： 提供jdbcTemplete 和 SimpleJdbcTemplete 工具类操作JDBC
 * 
 * @author <a href="mailto:nan.wang@berheley.com">wangnan </a>
 */
public class JdbcDAO extends SimpleJdbcDaoSupport implements IJdbcDAO
{

	private LobHandler	lobHandler;

	public void setLobHandler(LobHandler lobHandler)
	{
		this.lobHandler = lobHandler;
	}

	public boolean execute(String[] sql)
	{
		try
		{
			getSimpleJdbcTemplate().getJdbcOperations().batchUpdate(sql);
		} catch (DataAccessException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// added by Wang Cheng 2011-1-11 [ZKP-108] begin
	public int[] executeWithInfluenceRowsReturn(String[] sql)
	{
		try
		{
			return getSimpleJdbcTemplate().getJdbcOperations().batchUpdate(sql);
		} catch (DataAccessException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	// [ZKP-108] end
}
