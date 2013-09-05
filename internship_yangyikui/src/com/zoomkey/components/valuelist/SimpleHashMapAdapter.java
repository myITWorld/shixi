/*
 * Copyright: Tianjin wzh Tech Co,.ltd, China
 * VKang
 * com.wzh.util.valuelist -> SimpleHashMapAdapter.java
 * Created on 2006-7-27-上午10:34:21
 */

package com.zoomkey.components.valuelist;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.mlw.vlh.ValueListInfo;
import net.mlw.vlh.adapter.jdbc.AbstractDynaJdbcAdapter;

/**
 * 类功能描述： 使用HashMap保存ResultSet中的每一行记录，其中key是该列的列名，value是值。<br/> <b>需要JDBC驱动实现支持ResultSetMetaData。</b><br/>
 * 值得注意的是Oracle JDBC驱动返回的列名貌似都是大写，或者和驱动参数有关？没试。<br/>
 * 谨献给和我一样讨厌什么DynaBean和只能用Struts标签库输出DynaBean结果集的大人们！
 */
public class SimpleHashMapAdapter extends AbstractDynaJdbcAdapter
{

	/**
	 * @see net.mlw.vlh.adapter.jdbc.AbstractJdbcAdapter#processResultSet(java.lang.String,
	 *      java.sql.ResultSet, int, net.mlw.vlh.ValueListInfo)
	 */
	@Override
	public List processResultSet(String name, ResultSet result, int numberPerPage, ValueListInfo info)
				throws SQLException
	{
		List<Map<String, ?>> ret = new ArrayList<Map<String, ?>>(numberPerPage);
		ResultSetMetaData meta = result.getMetaData(); // 获取结果集meta
		Map<String, Object> m;
		int columnCount = meta.getColumnCount();
		for (int i = 0; i < numberPerPage && result.next(); i++)
		{
			m = new HashMap<String, Object>(columnCount);
			for (int j = 1; j <= columnCount; j++)
			{
				// key为列名，value为实际数据
				// m.put(meta.getColumnName(j), result.getObject(j));
				// mysql对应的valuelist中的列名
				m.put(meta.getColumnLabel(j), result.getObject(j));
			}
			ret.add(m);
		}
		return ret;
	}
}
