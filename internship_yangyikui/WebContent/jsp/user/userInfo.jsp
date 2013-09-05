<%--
	* createdate:2013-5-23 下午02:00:36
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
<div style="width:1088px;height:546px; border:2px solid #99BBE8">
<table width="1090px" height="544" border="1">
  <tr>
    <td width="13%" height="58" align="right">用户名：</td>
    <td width="87%" align="left">&nbsp;${sessionScope.use.name }</td>
  </tr>
  <tr>
    <td height="76" align="right">性别：</td>
    <td align="left">&nbsp;
    <c:if test="${sessionScope.use.gender==1 }">男</c:if>
    <c:if test="${sessionScope.use.gender==0 }">女</c:if></td>
  </tr>
  <tr>
    <td height="76" align="right">年龄：</td>
    <td align="left"> &nbsp;${sessionScope.use.age }岁</td>
    
  </tr>
  <tr>
    <td height="113" align="right">注册时间：</td>
    <td align="left">&nbsp;${sessionScope.use.registerTime }</td>
  </tr>
  <tr>
    <td height="98" align="right">当前积分：</td>
    <td align="left">&nbsp;${sessionScope.use.credits }分</td>
  </tr>
</table>
</div>
 
</body>
</html>