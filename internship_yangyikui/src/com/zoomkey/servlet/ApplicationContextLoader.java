
package com.zoomkey.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 类功能描述：获得spring bean容器
 * 
 * @author <a href="mailto:zehui.wang@hotmail.com">wangnan </a>
 */
public class ApplicationContextLoader extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -4235643601188566127L;

	private static String		contextPath;

	/**
	 * @return Returns the contextPath.
	 */
	public static final String getContextPath()
	{
		return contextPath;
	}

	/**
	 * @param contextPath The contextPath to set.
	 */
	private void setContextPath(String contextPath)
	{
		this.contextPath = contextPath;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException
	{
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletConfig.getServletContext());
		ApplicationContextKeeper.init(ctx);
		setContextPath(servletConfig.getServletContext().getServletContextName());
	}

	@Override
	public void destroy()
	{
		super.destroy();
	}
}
