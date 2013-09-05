<%--
	* createdate:2013-5-7 下午05:25:17
	* Copyright: Tianjin Zoomkey Software Development Co.,Ltd.
	* JSP页面功能描述: hcms  
	* @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/security.tld" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>用户管理</title>
<link href="<c:url value='/js/ext/resources/css/ext-all.css'/>" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="<c:url value='/js/base/base.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/date/calendar.jsp'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/plugins/jquery.form.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/plugins/jquery.hotkeys.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ext/ext-base.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ext/ext-all.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ext/ext-lang-zh_CN.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ext/plugins/ComboBoxTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/common/validator.js'/>"></script>	 
<script language="JavaScript"> 
</script>
<style type="text/css">
html:{ overflow:hidden}
</style>
</head> 
 <frameset rows="10%,*" border="0">
	<frame src="<c:url value='/jsp/common/header.jsp'/>" frameborder="0" scrolling="no"    />
   <frameset cols="19%,*">
    	<frame src="<c:url value='/jsp/common/left.jsp'/>" frameborder="0" scrolling="no"   />
      <frame name="userM" frameborder="0" scrolling="auto" src="<c:url value='/goToArticle.ao?method=toArticleMana'/>"  noresize="noresize"/>
    </frameset>
 </frameset> 
 </html>