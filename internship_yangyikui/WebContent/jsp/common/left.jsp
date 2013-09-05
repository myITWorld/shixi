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
<link rel="stylesheet" type="text/css" href="<c:url value='/skins/style_1/css/style.css'/>" />
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
<link rel="stylesheet" type="text/css" href="../../skins/style_1/css/left.css">
<script language="JavaScript">

</script>
</head>
<body id="content">  
<!-- 页面首部 --> 
	<div id="left" style="width:200px; height:550px; float:left; ">
    <table border="1" CELLSPACING=0 CELLPADDING=2 >
    <c:if test="${user.role==2 }">
  <tr>
    <td width="92" height="94">&nbsp;
      <h3><a href="<c:url value='/goToArticle.ao?method=toArticleMana'/>" target="userM">文章管理</a></h3></td>  
  </tr>
  <tr>
    <td height="81">&nbsp;
      <h3>
      
     <a href="<c:url value='/getSectionName.ao?method=preQuerySection'/>" target="userM">用户管理</a>  
      </h3></td>
  </tr>
  <tr>
    <td height="89">&nbsp;
      <h3>
       <a href="<c:url value='/goToSection.ao?method=toSectionMana'/>" target="userM">版块管理</a>  
      </h3></td>
  </tr>
  </c:if>
 
    <c:if test="${user.role==1 }">
  <tr>
    <td width="92" height="94">&nbsp;
      <h3><a href="<c:url value='/goToArticle.ao?method=toArticleMana'/>" target="userM">文章管理</a></h3></td>  
  </tr>
 
  <tr>
    <td height="89">&nbsp;
      <h3>
       <a href="<c:url value='/goToSection.ao?method=toSectionMana'/>" target="userM">版块管理</a>  
      </h3></td>
  </tr>
  </c:if> 
</table> 
    </div> 
</body>
</html>