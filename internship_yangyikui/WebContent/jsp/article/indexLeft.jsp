<%--
	* createdate:2013-5-27 下午10:26:44
	* Copyright: Tianjin Zoomkey Software Development Co.,Ltd.
	* JSP页面功能描述: hcms  
	* @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>标题</title>
	<%@include file="/jsp/include/errorAndMsg.jsp"%>
<script language="JavaScript">

</script>
</head>

<body id="content"> 
<div style="width:200px; height:495px;border:4px solid #C6D8EA" id="left"> 
<html:hidden property="attribute(role)" value="${user.role }" styleId="role"/>
</div> 
<script type="text/javascript" src="<c:url value='/jsp/article/indexLeft.js'/>"></script>
 
</html>