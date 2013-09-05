/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * hms
 * com.berheley.hcms.bean.DateConvertor.java
 * Created on 2012-6-4-下午05:09:39
 */

package com.zoomkey.bean;

import java.sql.Date;

import org.apache.commons.beanutils.Converter;

/**
 * 类功能描述：struts的Form用来转换前台时间类型的
 *
 * @author <a href="mailto:zhaoxinchun@zoomkey.com.cn">zhaoxinchun</a>
 * Create:  2012-6-4 下午05:09:39
 */
public class SqlDateConvertor implements Converter
{

	private final String	pattern	= "yyyy-MM-dd";

	public SqlDateConvertor()
	{
	}

	@Override
	public Object convert(@SuppressWarnings("rawtypes") Class arg0, Object arg1)
	{
		Date date = null;
		String src = (String) arg1;
		if (src == null || "".equals(src))
		{
			return null;
		} else
		{
			src = src.trim();
			if (src.length() == this.pattern.length())
			{
				date = Date.valueOf(src);
			}
			return date;
		}
	}
}
