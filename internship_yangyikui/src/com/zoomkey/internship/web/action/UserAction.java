/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.web.action.UserAction.java
 * Created on 2013-5-7-下午03:59:38
 */

package com.zoomkey.internship.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mlw.vlh.web.mvc.ValueListHandlerHelper;
import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zoomkey.common.ServiceDefine;
import com.zoomkey.components.valuelist.ValueListUtil;
import com.zoomkey.internship.persistence.model.TUser;
import com.zoomkey.internship.service.IArticleBO;
import com.zoomkey.internship.service.IUserBO;
import com.zoomkey.internship.web.form.UserForm;
import com.zoomkey.util.Utility;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-7 下午03:59:38
 */
public class UserAction extends BaseAction {

	protected ValueListHandlerHelper	valueListHelper;

	private static final String		USER_HIBERNATE_ADAPTER	= "userHibernateAdapter";

	/**
	 * @function:登录成功后跳转
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-10 下午01:15:46
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		UserForm userForm = (UserForm) form;
		IUserBO userBO = (IUserBO) getService(ServiceDefine.USER_INFO_SERVICE);
		TUser tUser = userForm.gettUser();
		boolean r = userBO.isSuccessLogin(tUser);
		TUser tu = userBO.getObjectOfTuser(tUser.getName());
		if (r) {
			addMessage("用户登录成功");
			req.getSession().setAttribute("user", tu);
			return mapping.findForward(PAGE_FORWARD_SUCCESS);
		} else {
			return mapping.findForward(PAGE_FORWARD_FAIL);
		}
	}

	/**
	 * @function:在gridpanel中显示模糊查询出来的结果
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-10 下午04:00:43
	 */
	public ActionForward getInfo(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		UserForm userForm = (UserForm) form;
		Map queries = userForm.getConMap();
		JSONObject json = ValueListUtil.getJsonForExt(USER_HIBERNATE_ADAPTER, queries, req);
		return returnAjax(req, res, json.toString());
	}

	/**
	 * @function:屏蔽用户
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-13 下午10:27:35
	 */
	public ActionForward processShieldUserInfo(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String idsValue = Utility.nullToString(req.getParameter("ids"));
		String[] ids = idsValue.split(",");
		IUserBO userBo = (IUserBO) getService(ServiceDefine.USER_INFO_SERVICE);
		userBo.optShieldUser(ids);
		addMessage("操作成功");
		return returnAjax(req, res);
	}

	/**
	 * @function:获得用户信息进入客户中心
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-23 下午02:14:46
	 */
	public ActionForward toUserCenter(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		int userId = Utility.nullObjectToInteger(req.getParameter("userId"));
		IUserBO userBo = (IUserBO) getService(ServiceDefine.USER_INFO_SERVICE);
		IArticleBO articleBo = (IArticleBO) getService(ServiceDefine.ARTICLE_INFO_SERVICE);
		// 某用户发表的文章放到list中
		List list = articleBo.getArticleOfUser(userId);
		TUser user = (TUser) userBo.getObjectById(TUser.class, userId);
		req.getSession().setAttribute("use", user);
		req.getSession().setAttribute("list", list);
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	public ActionForward UserCenter(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		int userId = Utility.nullObjectToInteger(req.getParameter("userId"));
		IUserBO userBo = (IUserBO) getService(ServiceDefine.USER_INFO_SERVICE);
		TUser user = (TUser) userBo.getObjectById(TUser.class, userId);
		req.getSession().removeAttribute("use");
		req.getSession().setAttribute("use", user);
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	/**
	 * @function:修改客户信息
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-23 下午04:33:48
	 */
	public ActionForward updateUserInfo(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		UserForm userForm = (UserForm) form;
		IUserBO userBo = (IUserBO) getService(ServiceDefine.USER_INFO_SERVICE);
		TUser user = userForm.gettUser();
		userBo.optModify(user);
		TUser u = (TUser) req.getSession().getAttribute("user");
		user.setRegisterTime(u.getRegisterTime());
		user.setCredits(u.getCredits());
		req.getSession().removeAttribute("use");
		req.getSession().setAttribute("use", user);
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	/**
	 * @function:退出登录
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-24 上午11:24:38
	 */
	public ActionForward logOut(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		req.getSession().removeAttribute("user");
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}
}
