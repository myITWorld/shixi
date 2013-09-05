/*
 * Copyright: Tianjin Berheley Tech Co,.ltd, China
 * hcms
 * com.berheley.hcms.util.BasalInfo.java
 * Created on 2009-2-15-下午09:25:25
 */

package com.zoomkey.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

/**
 * 类功能描述：基本信息公用类 
 * 
 * @author <a href="mailto:kun.li@berheley.com">LiKun</a>
 */
public class BasalInfo {

	/**properties配置文件路径 **/
	public static final String	PROPERTIES_FILE_PATH	= "/WEB-INF/classes";

	/**
	 * 取得缓存对象
	 * 
	 * @param type 缓存名称
	 * @return 缓存信息
	 * @author: LiKun 2009-2-23 下午05:40:18
	 */
	public static Cache getCache(String type) {
		CacheManager singletonManager = CacheManager.create();
		Cache cache = singletonManager.getCache(type);
		if (cache == null) {
			singletonManager.addCache(type);
			cache = singletonManager.getCache(type);
		}
		return cache;
	}

	/**
	 * @function: 从properties文件中获取配置信息
	 * @param request
	 * @param fileName
	 * @return 配置信息
	 * @author: wangcheng    2012-9-10 下午04:07:08
	 */
	public static Properties getPropertiesFromFile(HttpServletRequest request, String fileName) throws IOException {
		String filePath = request.getSession().getServletContext().getRealPath(PROPERTIES_FILE_PATH);
		File file = new File(filePath + "\\" + fileName);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Properties p = new Properties();
		try {
			p.load(reader);
			return p;
		} finally {
			reader.close();
		}
	}
}