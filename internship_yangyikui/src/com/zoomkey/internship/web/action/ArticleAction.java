/*
 * Copyright: Tianjin Zoomkey Software Co,.ltd, China
 * internship_yangyikui
 * com.zoomkey.internship.web.action.ArticleAction.java
 * Created on 2013-5-17-下午05:05:02
 */

package com.zoomkey.internship.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zoomkey.common.ConstantEnumDefine;
import com.zoomkey.common.ServiceDefine;
import com.zoomkey.components.valuelist.ValueListUtil;
import com.zoomkey.internship.persistence.model.TArticle;
import com.zoomkey.internship.persistence.model.TSection;
import com.zoomkey.internship.persistence.model.TUser;
import com.zoomkey.internship.service.IArticleBO;
import com.zoomkey.internship.service.ISectionBO;
import com.zoomkey.internship.service.IUserBO;
import com.zoomkey.internship.web.form.ArticleForm;
import com.zoomkey.internship.web.form.SectionForm;
import com.zoomkey.util.DateHelper;
import com.zoomkey.util.Mapor;
import com.zoomkey.util.StringUtil;
import com.zoomkey.util.Utility;

/**
 * 类功能描述：
 *
 * @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
 * Create:  2013-5-17 下午05:05:02
 */
public class ArticleAction extends BaseAction {

	private static final String	ARTICLE_HIBERNATE_ADAPTER			= "articleHibernateAdapter";

	private static final String	SARTICLE_HIBERNATE_ADAPTER			= "sarticleHibernateAdapter";

	private static final String	SARTICLE_INDEX_HIBERNATE_ADAPTER	= "articleIndexHibernateAdapter";

	/**
	 * @function:进入文章管理界面
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-19 下午01:05:17
	 */
	public ActionForward toArticleMana(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		SectionForm sectionForm = (SectionForm) form;
		// 获得BO
		ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
		// 得到list集合
		List<Map> list = sectionBO.getAllSectionName(Utility.nullObjectToInteger(ConstantEnumDefine.AUDIRING.审核通过.getValue()));
		// set值
		sectionForm.setSectionInfoList(list);
		// 放到request中
		req.setAttribute("sectionInfoList", list);
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	/**
	 * @function:点击发文章按钮进入发文章页面
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-21 上午11:09:42
	 */
	public ActionForward toPublish(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		// 清除session
		req.getSession().removeAttribute("article");
		SectionForm sectionForm = (SectionForm) form;
		ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
		// 获得下拉版块值
		List<Map> list = sectionBO.getAllSectionName(Utility.nullObjectToInteger(ConstantEnumDefine.AUDIRING.审核通过.getValue()));
		sectionForm.setSectionInfoList(list);
		req.setAttribute("sectionInfoList", list);
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	/**
	 * @function:查询文章信息
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-17 下午05:05:47
	 */
	public ActionForward getArticleInfo(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		ArticleForm articleForm = (ArticleForm) form;
		Map queries = articleForm.getConMap();
		JSONObject json = ValueListUtil.getJsonForExt(ARTICLE_HIBERNATE_ADAPTER, queries, req);
		return returnAjax(req, res, json.toString());
	}

	/**
	 * @function:查询首页文章信息
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-27 上午10:55:42
	 */
	public ActionForward getArticleIndexInfo(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		ArticleForm articleForm = (ArticleForm) form;
		Map queries = articleForm.getConMap();
		JSONObject json = ValueListUtil.getJsonForExt(SARTICLE_INDEX_HIBERNATE_ADAPTER, queries, req);
		return returnAjax(req, res, json.toString());
	}

	/**
	 * @function:查找某版块下的文章信息
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-22 下午01:28:48
	 */
	public ActionForward getArticleOfSectionInfo(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		ArticleForm articleForm = (ArticleForm) form;
		Map queries = articleForm.getConMap();
		JSONObject json = ValueListUtil.getJsonForExt(SARTICLE_HIBERNATE_ADAPTER, queries, req);
		return returnAjax(req, res, json.toString());
	}

	/**
	 * @function:发文章
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-19 下午03:02:59
	 */
	public ActionForward createArticle(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// 获得版块的id
		int sectionId = Utility.nullObjectToInteger(req.getParameter("sectionId"));
		// 获得sectionBO
		ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
		// 获得articleBO
		IArticleBO articleBO = (IArticleBO) getService(ServiceDefine.ARTICLE_INFO_SERVICE);
		// 获得userBO
		IUserBO userBO = (IUserBO) getService(ServiceDefine.USER_INFO_SERVICE);
		// 得到版块实体
		TSection tSection = (TSection) sectionBO.getObjectById(TSection.class, sectionId);
		// 得到用户实体
		TUser user = (TUser) req.getSession().getAttribute("user");
		ArticleForm articleForm = (ArticleForm) form;
		// 赋值设置默认值
		if (req.getSession().getAttribute("article") == null) {// 发文章
			articleForm.gettArticle().setTUser(user);
			articleForm.gettArticle().setTSection(tSection);
			// 执行save操作，id为空
			articleForm.gettArticle().setId(null);
			articleForm.gettArticle().setCreateTime(DateHelper.getSimpleFormatedDayNow());
			// 发表文章的用户积分加1
			user.setCredits(user.getCredits() + 1);
			// 设置默认值
			articleForm.gettArticle().setUpdateTime(DateHelper.getSimpleFormatedDateNow());
			articleForm.gettArticle().setIsAuditing(ConstantEnumDefine.AUDIRING.审核不通过.getValue());
			articleForm.gettArticle().setIsEssence(ConstantEnumDefine.ESS.非精华.getValue());
			articleForm.gettArticle().setIsTop(ConstantEnumDefine.TOP.非置顶.getValue());
			userBO.isSuccessRegister(user);
			articleForm.gettArticle().setStatus(ConstantEnumDefine.STATUS.正常.getValue());
			TArticle tArticle = articleForm.gettArticle();
			// 执行saveArticle方法
			articleBO.saveArticle(tArticle);
			addMessage("发表文章成功");
			return returnAjax(req, res);
		} else {// 修改文章
			// 设置修改文章的修改时间
			articleForm.gettArticle().setUpdateTime(DateHelper.getSimpleFormatedDateNow());
			// 得到文章
			TArticle ta = (TArticle) req.getSession().getAttribute("article");
			// 设置文章不变的值
			articleForm.gettArticle().setCreateTime(ta.getCreateTime());
			articleForm.gettArticle().setIsAuditing(ta.getIsAuditing());
			articleForm.gettArticle().setIsEssence(ta.getIsEssence());
			articleForm.gettArticle().setIsTop(ta.getIsTop());
			articleForm.gettArticle().setTUser(ta.getTUser());
			articleForm.gettArticle().setTSection(tSection);
			articleForm.gettArticle().setStatus(ConstantEnumDefine.STATUS.正常.getValue());
			TArticle tArticle = articleForm.gettArticle();
			// 执行saveArticle方法
			articleBO.saveArticle(tArticle);
			addMessage("修改文章成功");
			return returnAjax(req, res);
		}
	}

	/**
	 * @function:审核文章
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-19 下午04:28:31
	 */
	public ActionForward autidingArticle(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// 获得id数组
		String idsValue = Utility.nullToString(req.getParameter("ids"));
		// 根据逗号分开
		String[] ids = idsValue.split(",");
		IArticleBO articleBo = (IArticleBO) getService(ServiceDefine.ARTICLE_INFO_SERVICE);
		articleBo.optAutidingArticle(ids);
		addMessage("操作成功");
		return returnAjax(req, res);
	}

	/**
	 * @function:设置文章为精华
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-20 下午05:21:21
	 */
	public ActionForward changeArticleEss(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// 获得id数组
		String idsValue = Utility.nullToString(req.getParameter("ids"));
		// split逗号分开
		String[] ids = idsValue.split(",");
		IArticleBO articleBo = (IArticleBO) getService(ServiceDefine.ARTICLE_INFO_SERVICE);
		articleBo.optChangeArticleEss(ids);
		addMessage("精华操作成功");
		return returnAjax(req, res);
	}

	/**
	 * @function:置顶
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-20 下午09:13:42
	 */
	public ActionForward setArticleTop(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		int id = Utility.nullObjectToInteger(req.getParameter("id"));
		IArticleBO articleBo = (IArticleBO) getService(ServiceDefine.ARTICLE_INFO_SERVICE);
		articleBo.optArticleTop(id);
		addMessage("置顶操作成功");
		return returnAjax(req, res);
	}

	/**
	 * @function:删除文章
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-20 上午08:42:53
	 */
	public ActionForward deleteArticleInfo(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String idsValue = Utility.nullToString(req.getParameter("ids"));
		String[] ids = idsValue.split(",");
		IArticleBO articleBo = (IArticleBO) getService(ServiceDefine.ARTICLE_INFO_SERVICE);
		articleBo.optDeleteArticle(ids);
		addMessage("删除文章成功");
		return returnAjax(req, res);
	}

	/**
	 * @function:显示文章详细信息
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-20 下午01:50:15
	 */
	public ActionForward showArticleDetail(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		int articleId = Utility.nullObjectToInteger(req.getParameter("articleId"));
		IArticleBO articleBo = (IArticleBO) getService(ServiceDefine.ARTICLE_INFO_SERVICE);
		TArticle tArticle = articleBo.getObjectOfTarticle(articleId);
		req.getSession().setAttribute("article", tArticle);
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	/**
	 * @function:修改文章信息 进入发文章界面
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-22 上午09:32:24
	 */
	public ActionForward updateArticleInfo(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		//
		SectionForm sectionForm = (SectionForm) form;
		ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
		// 得到版块的名字
		List<Map> list = sectionBO.getAllSectionName(Utility.nullObjectToInteger(ConstantEnumDefine.AUDIRING.审核通过.getValue()));
		sectionForm.setSectionInfoList(list);
		req.setAttribute("sectionInfoList", list);
		// 获取文章id
		int articleId = Utility.nullObjectToInteger(req.getParameter("id"));
		// 得到BO
		IArticleBO articleBo = (IArticleBO) getService(ServiceDefine.ARTICLE_INFO_SERVICE);
		// 根据id获得实体
		TArticle tArticle = articleBo.getObjectOfTarticle(articleId);
		// 放到session中
		req.getSession().setAttribute("article", tArticle);
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	/**
	 * @function:树形显示版块或版块下文章
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-28 下午01:08:27
	 */
	@SuppressWarnings("unchecked")
	public void processQuerySectionInfoJson(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		String Id = req.getParameter("node");// 得到版块id
		if (!StringUtil.isEmpty(Id)) {
			if (Id.equals("0")) {
				ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
				// 得到版块的名字
				TUser user = (TUser) req.getSession().getAttribute("user");
				List<Map<String, Object>> list = null;
				if (user != null) {
					// 管理员显示所有的版块包括没有审核的
					if (user.getRole() == ConstantEnumDefine.ROLE.管理员.getValue()) {
						// 得到所有的版块包括没有审核的
						list = sectionBO.getAllSectionName();
					} else {
						// 得到所有的通过审核的版块
						list = sectionBO.getAllSectionName(Utility.nullObjectToInteger(ConstantEnumDefine.AUDIRING.审核通过.getValue()));
					}
				} else {
					list = sectionBO.getAllSectionName(Utility.nullObjectToInteger(ConstantEnumDefine.AUDIRING.审核通过.getValue()));
				}
				List<Map<String, Object>> areasMapList = new ArrayList<Map<String, Object>>();
				Map<String, Object> areasMap = null;
				for (Map<String, Object> map : list) {
					areasMap = new HashMap<String, Object>();
					areasMap.put("id", Utility.nullObjectToString(map.get("id") + "*"));
					areasMap.put("text", Utility.nullObjectToString(map.get("name")));
					areasMap.put("iconCls", "icon_area");
					areasMap.put("leaf", false);
					areasMapList.add(areasMap);
				}
				JSONArray jsonArray = JSONArray.fromObject(areasMapList);
				this.returnAjax(req, res, jsonArray.toString());
			} else {
				IArticleBO articleBo = (IArticleBO) getService(ServiceDefine.ARTICLE_INFO_SERVICE);
				// 防止版块id和文章id相同
				Id = Id.substring(0, Id.length() - 1);
				// 根据版块id得到版块下的文章
				List<Object[]> article = articleBo.getArticleOfSection(Utility.nullObjectToInteger(Id));
				StringBuilder sb = new StringBuilder("[");
				// 文章id
				String articleId = "";
				// 是否精华
				String isEss = "";
				// 是否置顶
				String isTop = "";
				// 文章标题
				String articleName = "";
				Mapor essMapor = new Mapor(Mapor.DENY_SAME_VALUE_BUT_KEY);
				Mapor topMapor = new Mapor(Mapor.DENY_SAME_VALUE_BUT_KEY);
				Mapor articleMapor = new Mapor(Mapor.DENY_SAME_VALUE_BUT_KEY);
				for (Object[] objs : article) {
					// 得到版块id
					articleId = objs[0].toString();
					// 得到精华
					isEss = objs[1].toString();
					// 得到置顶
					isTop = objs[2].toString();
					// 得到版块名
					articleName = (String) objs[3];
					essMapor.put(articleId, isEss);
					topMapor.put(articleId, isTop);
					articleMapor.put(articleId, articleName);
					for (Object objTitle : articleMapor.getValuesByKey(articleId)) {
						objTitle = StringUtil.emptyToSpace((String) objTitle);
						// 精华且置顶
						if (isEss.equals("1") && isTop.equals("1")) {
							sb.append("{iconCls:'icon_zdjh',id:'")
								.append(articleId)
								.append("',text:' ")
								.append(objTitle)
								.append("',leaf:true},");
							// 置顶
						} else if (!isEss.equals("1") && isTop.equals("1")) {
							sb.append("{iconCls:'icon_zhiding',id:'")
								.append(articleId)
								.append("',text:' ")
								.append(objTitle)
								.append("',leaf:true},");
							// 精华
						} else if (isEss.equals("1") && !isTop.equals("1")) {
							sb.append("{iconCls:'icon_jinghua',id:'")
								.append(articleId)
								.append("',text:' ")
								.append(objTitle)
								.append("',leaf:true},");
							// 普通
						} else {
							sb.append("{iconCls:'icon_are',id:'")
								.append(articleId)
								.append("',text:' ")
								.append(objTitle)
								.append("',leaf:true},");
						}
					}
				}
				sb.delete(sb.length() - 1, sb.length()).append("]");
				this.returnAjax(req, res, sb.toString().replaceAll("[\\r\\n]", ""));
			}
		} else {
			this.returnAjax(req, res, "");
		}
	}

	/**
	 * @function:点击树形检索内容，显示版块文章或文章详情
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-30 上午09:50:59
	 */
	public ActionForward preArticleList(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		// 获得版块的id
		String sectionId = req.getParameter("sectionId");
		if (!StringUtil.isEmpty(sectionId)) {
			sectionId = sectionId.substring(0, sectionId.length() - 1);
			ISectionBO sectionBO = (ISectionBO) getService(ServiceDefine.SECTION_INFO_SERVICE);
			TSection section = (TSection) sectionBO.getObjectById(TSection.class, sectionId);
			req.setAttribute("sectionId", sectionId);
			req.setAttribute("tSection", section);
		}
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	/**
	 * @function:右键菜单置顶
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-30 下午02:24:46
	 */
	public ActionForward setTop(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// 获得文章id
		int id = Utility.nullObjectToInteger(req.getParameter("id"));
		IArticleBO articleBo = (IArticleBO) getService(ServiceDefine.ARTICLE_INFO_SERVICE);
		// 处理置顶位
		articleBo.optArticleTop(id);
		addMessage("置顶操作成功");
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	/**
	 * @function:右键菜单设置精华
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-30 下午02:31:32
	 */
	public ActionForward setEss(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// 获得文章id
		String idsValue = Utility.nullToString(req.getParameter("id"));
		String[] ids = idsValue.split(",");
		IArticleBO articleBo = (IArticleBO) getService(ServiceDefine.ARTICLE_INFO_SERVICE);
		articleBo.optChangeArticleEss(ids);
		addMessage("精华操作成功");
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}

	/**
	 * @function:右键菜单删除操作
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @author: yangyikui    2013-5-30 下午02:55:27
	 */
	public ActionForward deleteArticle(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String idsValue = Utility.nullToString(req.getParameter("id"));
		String[] ids = idsValue.split(",");
		IArticleBO articleBo = (IArticleBO) getService(ServiceDefine.ARTICLE_INFO_SERVICE);
		articleBo.optDeleteArticle(ids);
		addMessage("删除文章成功");
		return mapping.findForward(PAGE_FORWARD_SUCCESS);
	}
}