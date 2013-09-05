<%--
	* createdate:2013-5-7 下午05:25:17
	* Copyright: Tianjin Zoomkey Software Development Co.,Ltd.
	* JSP页面功能描述: hcms  
	* @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/security.tld" prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="/jsp/include/errorAndMsg.jsp"%>
<link rel="stylesheet" type="text/css"
	href="../../skins/style_1/css/userleft.css">
<script language="JavaScript">

</script>
</head>
<body id="content">
<div id="left" style="width: 200px; height: 550px; float: left;">
<table width="123" border="1" CELLPADDING=2 CELLSPACING=0>
	<tr>
		<td width="115" height="81" align="center" valign="middle">&nbsp;

		<h3><a href="<c:url value='/jsp/user/userInfo.jsp'/>"
			target="userM">注册信息查看</a></h3>
		</td>
	</tr>
	<c:if test="${sessionScope.user.name==sessionScope.use.name }">
		<tr>
			<td height="70" align="center" valign="middle">&nbsp;
			<h3><a href="<c:url value='/jsp/user/articleOfUser.jsp'/>"
				target="userM">已发文章</a></h3>
			</td>
		</tr>
		<tr>
			<td height="77" align="center" valign="middle">&nbsp;
			<h3><a href="<c:url value='/jsp/user/updateUserInfo.jsp'/>"
				target="userM">注册信息修改</a></h3>
			</td>
		</tr>

	</c:if>






</table>
</div>
</body>
</html>