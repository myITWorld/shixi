
package com.zoomkey.bean;

import java.io.Serializable;

/**
 * 类功能描述：
 * 
 * @author <a href="mailto:juan.liu@berheley.com">Liujuan</a>
 */
public class IntegrateQueryKey implements Serializable
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 9213073633948339854L;

	/** 页面展示元素 */
	private String					label;

	/** 元素对应的唯一标识 */
	private String					key;

	/** 对应数据库的字段 */
	private String					column;

	private String					selectColumn;										// select语句中显示的列

	/** 查询字段的类型 */
	private Class					columnType;

	/** 是否需要有选择项 */
	private boolean				listValue;

	/**
	 * 
	 */
	public IntegrateQueryKey()
	{
	}

	/**
	 * @param label
	 * @param column
	 * @param columnType
	 */
	public IntegrateQueryKey(String label,
				String key,
				String column,
				Class columnType)
	{
		this(label, key, column, columnType, false);
	}

	public IntegrateQueryKey(String label,
				String key,
				String column,
				Class columnType,
				boolean listValue)
	{
		super();
		this.label = label;
		this.key = key;
		this.column = column;
		this.columnType = columnType;
		this.listValue = listValue;
	}

	public IntegrateQueryKey(String label,
				String key,
				String selectColumn,
				String column,
				Class columnType)
	{
		this(label, key, selectColumn, column, columnType, false);
	}

	public IntegrateQueryKey(String label,
				String key,
				String selectColumn,
				String column,
				Class columnType,
				boolean listValue)
	{
		super();
		this.label = label;
		this.key = key;
		this.selectColumn = selectColumn;
		this.column = column;
		this.columnType = columnType;
		this.listValue = listValue;
	}

	public String getColumn()
	{
		return column;
	}

	public Class getColumnType()
	{
		return columnType;
	}

	public String getLabel()
	{
		return label;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public boolean isListValue()
	{
		return listValue;
	}

	public void setColumn(String column)
	{
		this.column = column;
	}

	public void setColumnType(Class columnType)
	{
		this.columnType = columnType;
	}

	public String getSelectColumn()
	{
		return selectColumn;
	}

	public void setSelectColumn(String selectColumn)
	{
		this.selectColumn = selectColumn;
	}
}
