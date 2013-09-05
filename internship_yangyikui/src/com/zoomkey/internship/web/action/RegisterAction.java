/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.web.action.RegisterAction.java
 * Created on 2013-5-9-下午12:48:32
 */

package com.zoomkey.internship.web.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zoomkey.common.ConstantEnumDefine;
import com.zoomkey.common.ServiceDefine;
import com.zoomkey.internship.persistence.model.TUser;
import com.zoomkey.internship.service.IUserBO;
import com.zoomkey.internship.web.form.UserForm;
import com.zoomkey.util.DateHelper;

/**
 * 类功能描述：注册
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-9 下午12:48:32
 */
public class RegisterAction extends BaseAction {

	/**
	 * @function:注册成功后跳转到管理主界面
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: YangYiKui    2013-5-10 下午01:17:04
	 */
	public ActionForward register(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		UserForm userForm = (UserForm) form;
		IUserBO userBO = (IUserBO) getService(ServiceDefine.USER_INFO_SERVICE);
		TUser tUser = new TUser(userForm.gettUser().getName(), userForm.gettUser().getPassword(), userForm.gettUser()
			.getGender(), ConstantEnumDefine.STATUS.正常.getValue(), userForm.gettUser().getAge(), ConstantEnumDefine.ROLE.用户.getValue(), DateHelper.getSimpleFormatedDayNow(), DateHelper.getSimpleFormatedDayNow(), 10);
		userBO.isSuccessRegister(tUser);
		addMessage("用戶注册成功");
		// }
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("/getSectionName.ao?method=preQuerySection");
		return actionForward;
	}

	/**
	 * @function:ajax验证某用户是否注册返回信息传到前台
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: YangYiKui    2013-5-10 下午01:17:45
	 */
	public ActionForward checkIfUserExits(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res)
				throws IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		IUserBO userBO = (IUserBO) getService(ServiceDefine.USER_INFO_SERVICE);
		JSONObject json = new JSONObject();
		if (userBO.getName(name)) {
			json.put("state", true);
			json.put("msg", "对不起，用户名已被占用");
		} else {
			json.put("state", false);
			json.put("msg", "恭喜你，用户名可用");
		}
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(json.toString());
		res.getWriter().flush();
		res.getWriter().close();
		return null;
	}
}
