
package com.zoomkey.servlet;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

/**
 * 类功能描述：sping容器工具类，用于无法获取request的地方查找spring中注册的资源
 * 
 * @author <a href="mailto:zehui.wang@hotmail.com">wangnan </a>
 */
public class ApplicationContextKeeper
{

	// log
	public final static Logger				logger	= Logger.getLogger(ApplicationContextKeeper.class);

	private static ApplicationContext	appCtx	= null;

	public static ApplicationContext getAppCtx()
	{
		return appCtx;
	}

	public static void init(ApplicationContext ctxVal)
	{
		appCtx = ctxVal;
	}

	/**
	 * spring 获取注入的bean
	 * 
	 * @param serviceBeanName
	 * @return
	 */
	public static Object getService(String serviceBeanName)
	{
		logger.info("return serivce objects named " + serviceBeanName);
		return ApplicationContextKeeper.getAppCtx().getBean(serviceBeanName);
	}
}
