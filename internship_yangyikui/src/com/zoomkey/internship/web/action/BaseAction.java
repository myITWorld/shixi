
package com.zoomkey.internship.web.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.WebUtils;

import com.zoomkey.common.ServiceDefine;
import com.zoomkey.exception.AppException;
import com.zoomkey.exception.MessageCode;
import com.zoomkey.internship.service.ICommonBO;
import com.zoomkey.internship.service.IDeletableBO;
import com.zoomkey.internship.web.form.BaseForm;
import com.zoomkey.util.Utility;

/**
 * This class is:Action的基类，所有的Action继承它 这是一个dispatchAction,便于把独立的功能放在一起。
 * 主要完成：具体Action的调用，然后统一处理异常，以及出现异常时的消息显示。 同时提供获取spring Bean的方法，利用valuelist查询的方法和获取当前用户对象的方法
 * 
 * @author <a href="mailto:qiaoli.xu@berheley.com">qiaoli.xu </a>
 */
public class BaseAction extends DispatchAction {

	private static WebApplicationContext	wac								= null;

	public static final String					PAGE_FORWARD_PRE				= "prepage";							// 某操作的初始化页面

	public static final String					PAGE_FORWARD_SUCCESS			= "success";							// 某操作提交成功之后的页面

	public static final String					PAGE_FORWARD_FAIL				= "fail";								// 某操作提交失败的页面

	public static final String					RETURN_AJAX						= "returnAjax";						// Ajax请求状态

	public static final String					DEFAULT_CHARACTER_ENCODING	= "UTF-8";								// 默认的请求的编码

	// ajax 提交后的信息提示类型：success成功，error 失败
	public static final String					RETURN_AJAX_STATUS			= "state";

	public static final String					RETURN_AJAX_STATUS_SUCCESS	= "success";							// 成功

	public static final String					RETURN_AJAX_STATUS_WARN		= "warn";								// 警告

	public static final String					RETURN_AJAX_STATUS_ERROR	= "error";								// 失败

	public static final String					RETURN_AJAX_TIPS				= "info";								// ajax

	// 提交后的提示字符串
	// 消息参数
	protected ActionMessages					errors;

	// log
	public Log										logger							= LogFactory.getLog(this.clazz);

	protected ActionMessages					messages;

	protected JSONObject							ajaxJsonObj;

	protected boolean								ajaxSubmit;

	/**
	 * Action的执行函数。从这个函数进入具体的action.返回后在这里处理异常
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		ActionForward actionForward = new ActionForward();
		HttpSession session = req.getSession();
		initParameter((BaseForm) form);
		// 大部分js框架（jquery，exit，yui）会在ajax请求里加上一个名称为“X-Requested-With”的header，通过这个可以识别是否为ajax请求
		if (req.getHeader("X-Requested-With") != null) {
			this.ajaxSubmit = true;
		}
		try {
			// 执行实际的Action
			actionForward = super.execute(mapping, form, req, res);
			if (actionForward == null) {
				if (this.ajaxSubmit) {
					return null;
				}
				// 如果返回的actionForward对象为空，表示是重复提交
				actionForward = (ActionForward) session.getAttribute("forward");
				this.errors = (ActionMessages) session.getAttribute("errors");
				this.messages = (ActionMessages) session.getAttribute("messages");
			} else {
				// add by wangnan 解决forward转发请求时的消息问题
				if (actionForward.getPath().indexOf(".ao?method=") != -1) {
					req.setAttribute("ACTION_FORWARD_DO", "Y");
				} else {
					if ("Y".equals(req.getAttribute("ACTION_FORWARD_DO"))) {
						this.errors = (ActionMessages) req.getAttribute(Globals.ERROR_KEY);
						this.messages = (ActionMessages) req.getAttribute(Globals.MESSAGE_KEY);
					}
				}
				// saveToken(req); close by wangnan 调度造成此功能失败，请直接在Action中操作
			}
		} catch (AppException e) {
			// 前台提示系统出现异常
			addError(e.getKeyValue());
			// 需要抛出给用户的异常
			if (e.getE() != null) {
				e.getE().printStackTrace();
			}
			// 如果是ajax提交则直接返回
			if (this.ajaxSubmit) {
				return returnAjax(req, res);
			}
			actionForward = mapping.findForward(PAGE_FORWARD_FAIL);
			if (actionForward.getPath().indexOf(".ao?method=") != -1) {
				req.setAttribute("ACTION_FORWARD_DO", "Y");
			}
		} catch (NoSuchMethodException e) {
			// Action中没有相应的方法
			actionForward = (ActionForward) session.getAttribute("forward");
			this.errors = (ActionMessages) session.getAttribute("errors");
			this.messages = (ActionMessages) session.getAttribute("messages");
		} catch (Exception e) {
			// 不需要显示原因的异常
			actionForward = mapping.findForward(PAGE_FORWARD_FAIL);
			addError("抱歉，系统出现异常，请与管理员联系");
			this.logger.error(e);
			e.printStackTrace();
		}
		// 保存状态，如果重复提交则给出这些信息
		session.setAttribute("forward", actionForward);
		session.setAttribute("messages", this.messages);
		session.setAttribute("errors", this.errors);
		// 返回
		saveErrors(req, this.errors);
		saveMessages(req, this.messages);
		return actionForward;
	}

	/**
	 * @function:提示成功消息(绿色)
	 * @param value
	 * @author: LiKun    2011-10-25 下午04:57:20
	 */
	protected void addMessage(String value) {
		if (this.ajaxSubmit) {
			try {
				// Ext需要该参数
				this.ajaxJsonObj.putOpt(RETURN_AJAX_STATUS_SUCCESS, true);
				this.ajaxJsonObj.putOpt(RETURN_AJAX_STATUS, RETURN_AJAX_STATUS_SUCCESS);
				this.ajaxJsonObj.putOpt(RETURN_AJAX_TIPS, value);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			this.addMessages(MessageCode.MESSAGES_COMMON_ANY, value, null);
		}
	}

	/**
	 * @function:提示成功消息(橙色)
	 * @param req
	 * @param key
	 * @param value
	 * @author: likun    2010-6-18 上午10:05:18
	 */
	protected void addWarning(String value) {
		if (this.ajaxSubmit) {
			try {
				// Ext需要该参数
				this.ajaxJsonObj.putOpt(RETURN_AJAX_STATUS_SUCCESS, false);
				this.ajaxJsonObj.putOpt(RETURN_AJAX_STATUS, RETURN_AJAX_STATUS_WARN);
				this.ajaxJsonObj.putOpt(RETURN_AJAX_TIPS, value);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			this.addErrors(MessageCode.MESSAGES_COMMON_ANY, value, null);
		}
	}

	/**
	 * @function:提示成功消息(红色)
	 * @param value
	 * @author: LiKun    2011-10-25 下午04:58:00
	 */
	protected void addError(String value) {
		if (this.ajaxSubmit) {
			try {
				// Ext需要该参数
				this.ajaxJsonObj.putOpt(RETURN_AJAX_STATUS_SUCCESS, false);
				this.ajaxJsonObj.putOpt(RETURN_AJAX_STATUS, RETURN_AJAX_STATUS_ERROR);
				this.ajaxJsonObj.putOpt(RETURN_AJAX_TIPS, value);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			this.addErrors(MessageCode.MESSAGES_COMMON_ANY, value, null);
		}
	}

	/**
	 * @param key Message key for this error message
	 * @param value First replacement value
	 * @param property Property name (or ActionMessages.GLOBAL_MESSAGE)
	 */
	private void addErrors(String key, String value, String property) {
		this.errors = this.errors == null ? new ActionMessages() : this.errors;
		if (property == null) {
			this.errors.add(value, value == null ? new ActionMessage(key) : new ActionMessage(key, value));
		} else {
			this.errors.add(property, value == null ? new ActionMessage(key) : new ActionMessage(key, value));
		}
	}

	/**
	 * @param key Message key for this message
	 * @param value First replacement value
	 * @param property Property name (or ActionMessages.GLOBAL_MESSAGE)
	 */
	private void addMessages(String key, String value, String property) {
		this.messages = this.messages == null ? new ActionMessages() : this.messages;
		if (property == null) {
			this.messages.add(value, value == null ? new ActionMessage(key) : new ActionMessage(key, value));
		} else {
			this.messages.add(property, value == null ? new ActionMessage(key) : new ActionMessage(key, value));
		}
	}

	/**
	 * @param key Message key for this message
	 * @param values <p>The replacement values for this mesasge.</p>
	 */
	@SuppressWarnings("unused")
	private void addMessages(String key, String[] values) {
		this.messages = this.messages == null ? new ActionMessages() : this.messages;
		this.messages.add(key, new ActionMessage(key, values));
	}

	/**
	 * @function:基础业务处理类
	 * @return
	 * @author: Liujuan 2009-1-14 上午10:36:53
	 */
	public ICommonBO getCommonService() {
		return (ICommonBO) getService(ServiceDefine.COMMON_SERVICE);
	}

	/**
	 * @function:基础业务处理类
	 * @return
	 * @author: Liujuan 2009-1-14 上午10:36:53
	 */
	public IDeletableBO getDeletabletService() {
		return (IDeletableBO) getService(ServiceDefine.DELETABLE_SERVICE);
	}

	/**
	 * spring 获取注入的bean
	 * 
	 * @param serviceBeanName
	 * @return
	 */
	public Object getService(String serviceBeanName) {
		if (wac == null) {
			wac = WebApplicationContextUtils.getWebApplicationContext(super.getServlet().getServletContext());
		}
		this.logger.info("return serivce objects named " + serviceBeanName);
		return wac.getBean(serviceBeanName);
	}

	/**
	 * Return the temporary directory for the current web application, as provided by the servlet
	 * container.
	 * 
	 * @return the File representing the temporary directory
	 */
	protected final File getTempDir() {
		return WebUtils.getTempDir(super.getServlet().getServletContext());
	}

	/**
	 * @function:初始化参数
	 * @author: Liujuan 2009-3-17 下午05:09:38
	 */
	protected void initParameter() {
		// 将参数初始化
		this.ajaxSubmit = false;
		this.errors = new ActionMessages();
		this.messages = new ActionMessages();
		this.ajaxJsonObj = new JSONObject();
		try {
			this.ajaxJsonObj.putOpt(RETURN_AJAX_STATUS, RETURN_AJAX_STATUS_SUCCESS);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @function:初始化参数，设置是否ajax提交
	 * @param form
	 * @author: Liujuan 2009-3-17 下午05:09:54
	 */
	protected void initParameter(BaseForm form) {
		initParameter();
		// 现在已改为通过请求的header中是否包含X-Requested-With来进行是否为ajax请求的判断，而无需从前台传递ajaxSubmit参数
		// 判断是否为 ajax 提交申请
		if (Utility.isNullOrEmpty(form.getAjaxSubmit())) {
			this.ajaxSubmit = false;
		} else {
			this.ajaxSubmit = true;
		}
	}

	/**
	 * @function:ajax 请求不动态刷新页面
	 * @param request
	 * @return
	 * @author: Liujuan 2009-2-19 下午02:38:44
	 */
	protected ActionForward returnAjax(HttpServletRequest request) {
		// this.ajaxSubmit = true;
		return null;
	}

	/**
	 * @function:ajax 请求不动态刷新页面，需要向页面上进行显示信息。
	 * @param request
	 * @param response
	 * @return
	 * @author: Liujuan 2009-3-17 下午04:51:54
	 */
	protected ActionForward returnAjax(HttpServletRequest request, HttpServletResponse response) {
		return this.returnAjax(request, response, this.ajaxJsonObj.toString());
	}

	/**
	 * @function:ajax 请求不动态刷新页面
	 * @param request
	 * @param response
	 * @param result 向页面返回的信息
	 * @return
	 * @author: Liujuan 2009-2-19 下午02:46:25
	 */
	protected ActionForward returnAjax(HttpServletRequest request, HttpServletResponse response, String result) {
		response.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			if (this.logger.isDebugEnabled()) {
				this.logger.debug("Return ajax Exception:", e);
			}
		}
		if (out != null) {
			out.write(result);
			out.flush();
			out.close();
		}
		return returnAjax(request);
	}

	/**
	 * 
	 */
	@Override
	protected void saveErrors(HttpServletRequest request, ActionMessages errors) {
		if (errors != null && !errors.isEmpty()) {
			super.saveErrors(request, errors);
		}
	}

	@Override
	protected void saveMessages(HttpServletRequest request, ActionMessages messages) {
		if (messages != null && !messages.isEmpty()) {
			super.saveMessages(request, messages);
		}
	}
}
