/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.web.action.GoUserAction.java
 * Created on 2013-5-9-下午02:55:20
 */

package com.zoomkey.internship.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">YangYiKui</a>
 * Create:  2013-5-9 下午02:55:20
 */
public class GoUserAction extends DispatchAction {

	public ActionForward goToUser(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return mapping.findForward("success");
	}
}
