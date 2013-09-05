/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms
 * com.berheley.hcms.bean.Table.java
 * Created on 2009-4-2-上午10:14:15
 */

package com.berheley.hcms.bean.query;

/**
 * 类功能描述：
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public class Table
{

	private String	tableName;

	private String	tableSimpleName;

	/**
	 * 
	 */
	public Table()
	{
		super();
	}

	/**
	 * @param tableName
	 * @param tableSimpleName
	 */
	public Table(String tableName, String tableSimpleName)
	{
		super();
		this.tableName = tableName;
		this.tableSimpleName = tableSimpleName;
	}

	public String getTableName()
	{
		return tableName;
	}

	public void setTableName(String tableName)
	{
		this.tableName = tableName;
	}

	public String getTableSimpleName()
	{
		return tableSimpleName;
	}

	public void setTableSimpleName(String tableSimpleName)
	{
		this.tableSimpleName = tableSimpleName;
	}
}
