/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.web.action.Section.java
 * Created on 2013-5-14-下午02:55:34
 */

package com.zoomkey.internship.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zoomkey.common.ConstantEnumDefine;
import com.zoomkey.common.ServiceDefine;
import com.zoomkey.components.valuelist.ValueListUtil;
import com.zoomkey.internship.persistence.model.TSection;
import com.zoomkey.internship.service.ISectionBO;
import com.zoomkey.internship.service.IUserBO;
import com.zoomkey.internship.web.form.SectionForm;
import com.zoomkey.internship.web.form.UserForm;
import com.zoomkey.util.DateHelper;
import com.zoomkey.util.Utility;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
 * Create:  2013-5-14 下午02:55:34
 */
public class SectionAction extends BaseAction {

	private static final String	SECTION_HIBERNATE_ADAPTER	= "sectionHibernateAdapter";

	/**
	 * @function:获得版块的名字并显示在下拉中
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-14 下午04:30:35
	 */
	public ActionForward preQuerySection(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		SectionForm sectionForm = (SectionForm) form;
		ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
		List<Map> list = sectionBO.getSectionName();
		sectionForm.setSectionInfoList(list);
		req.setAttribute("userInfoList", list);
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	/**
	 * @function:提升为版主
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-14 下午04:30:31
	 */
	public ActionForward becomeModerator(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// 获得用户的id
		int id = Utility.nullObjectToInteger(req.getParameter("Id"));
		// 获得版块的id
		int sectionId = Utility.nullObjectToInteger(req.getParameter("sectionId"));
		ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
		IUserBO userBO = (IUserBO) getService(ServiceDefine.USER_INFO_SERVICE);
		sectionBO.updateSectionor(id, sectionId);
		// 改变用户的权限
		userBO.updateRole(id, ConstantEnumDefine.ROLE.版主.getValue());
		// TSection sectionObj = sectionForm.gettSection();
		// TSection ts = (TSection) sectionBO.getObjectById(TSection.class, sectionId);
		addMessage("提升版主成功");
		return returnAjax(req, res);
	}

	/**
	 * @function:查询版块的信息显示在表格中
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-16 上午08:47:07
	 */
	public ActionForward getSecInfo(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		SectionForm sectionForm = (SectionForm) form;
		Map queries = sectionForm.getConMap();
		JSONObject json = ValueListUtil.getJsonForExt(SECTION_HIBERNATE_ADAPTER, queries, req);
		return returnAjax(req, res, json.toString());
	}

	/**
	 * @function:跳转并把下拉信息放进去
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-16 上午09:45:57
	 */
	public ActionForward toSectionMana(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		UserForm userForm = (UserForm) form;
		IUserBO userBO = (IUserBO) getService(ServiceDefine.USER_INFO_SERVICE);
		List<Map> list = userBO.getUserNameInfo();
		userForm.setUsernameList(list);
		req.setAttribute("usernameList", list);
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	/**
	 * @function:创建版块
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-16 上午10:16:05
	 */
	public ActionForward createSection(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		SectionForm sectionForm = (SectionForm) form;
		int userId = Utility.nullObjectToInteger(req.getParameter("userId"));// 获得用户的id
		sectionForm.gettSection().setUserId(userId);
		// 设置创建时间
		sectionForm.gettSection().setCreateTime(DateHelper.getSimpleFormatedDayNow());
		// 设置修改时间
		sectionForm.gettSection().setUpdateTime(DateHelper.getSimpleFormatedDayNow());
		// 设置状态
		sectionForm.gettSection().setStatus(ConstantEnumDefine.STATUS.正常.getValue());
		TSection tSection = sectionForm.gettSection();
		ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
		IUserBO userBO = (IUserBO) getService(ServiceDefine.USER_INFO_SERVICE);
		sectionBO.saveSectionInfo(tSection);
		// 设置用户的权限
		userBO.updateRole(userId, ConstantEnumDefine.ROLE.版主.getValue());
		addMessage("创建版块成功");
		return returnAjax(req, res);
	}

	/**
	 * @function:删除版块（置位）
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-16 下午01:39:09
	 */
	public ActionForward deleteSectionInfo(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		// 获得要删除的版块的id
		String idsValue = Utility.nullToString(req.getParameter("ids"));
		String[] ids = idsValue.split(",");
		ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
		sectionBO.optDeleteSection(ids);
		addMessage("删除版块成功");
		return returnAjax(req, res);
	}

	/**
	 * @function:修改版块
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-17 上午08:33:51
	 */
	public ActionForward updateSectionInfo(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		SectionForm sectionForm = (SectionForm) form;
		// 获得版块的id
		int sectionId = Utility.nullObjectToInteger(req.getParameter("id"));
		TSection tSection = sectionForm.gettSection();
		ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
		sectionBO.updateSectionInfo(tSection.getSectionName(), tSection.getIsAuditing(), tSection.getVisitCredits(),
			DateHelper.getSimpleFormatedDayNow(), sectionId);
		addMessage("修改版块成功");
		return returnAjax(req, res);
	}

	/**
	 * @function:右键菜单"修改"进入修改界面
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-30 下午03:15:45
	 */
	public ActionForward updateSection(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		// 获得版块id
		String sectionId = req.getParameter("sectionId");
		// 处理
		sectionId = sectionId.substring(0, sectionId.length() - 1);
		ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
		// 得到版块实体
		TSection section = (TSection) sectionBO.getObjectById(TSection.class, sectionId);
		req.setAttribute("section", section);
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	/**
	 * @function:右键菜单修改版块信息
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-30 下午04:19:34
	 */
	public ActionForward updateSec(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		SectionForm sectionForm = (SectionForm) form;
		TSection tSection = sectionForm.gettSection();
		ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
		sectionBO.optModify(tSection);
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("/goToSection.ao?method=toSectionMana");
		return actionForward;
	}
}
