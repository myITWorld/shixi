<%--
	* createdate:2013-5-27 下午05:02:06
	* Copyright: Tianjin Zoomkey Software Development Co.,Ltd.
	* JSP页面功能描述: hcms  
	* @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>标题</title>

<style type="text/css">
	*{ margin: 0;
	padding: 0;}
	</style> 
<script language="JavaScript">

</script>
<%@include file="/jsp/include/errorAndMsg.jsp"%>
<link rel="stylesheet" type="text/css"
	href="../../skins/style_1/css/articleManagement.css">
</head>
<body id="content"> 
<!-- 引入头部 --> 
      <div  >
	       <iframe width="1366px" height="60px" scrolling="no" frameborder="0" src="<c:url value='/jsp/common/header.jsp'/>">
	       </iframe>
	   </div>
<div style="diaplay:none">
<div id="top"> 
<table width="1366" border="0" style="margin-top:10px">
	<c:if test="${user==null }">
		<tr>
			<td><a href="../../jsp/user/login.jsp" target="_top"
				style="padding-left: 50px; font-size: 16px;"><em><strong>请登录</strong></em></a>
			</td>
		</tr>
	</c:if>
	<c:if test="${user!=null }">
		<tr> 
		<!-- 版主登录显示的内容 -->
			<c:if test="${user.role==1 }">
				<td align="left" width="260px">&nbsp; 欢迎 <a href="<c:url value='/user/goToUserCenter.ao?method=toUserCenter&userId=${sessionScope.user.id }' />" target="_top">《${sessionScope.user.name
}》</a> <a href="<c:url value='/user/logout.ao?method=logOut'/>"	target="_top">[退出]</a></td>
				<td align="left" width="240px">您当前积分为[${sessionScope.user.credits}]分</td>
				<td align="left"><strong><em>&nbsp; <a	href="<c:url value='/jsp/manager/Menu.jsp'/>" target="_top">	版主入口>>>></a></em></strong></td>
			</c:if> 
			<!-- 管理员登录显示的内容 -->
			<c:if test="${user.role==2 }">
				<td align="left" width="260px">&nbsp; 欢迎 <a	href="<c:url value='/user/goToUserCenter.ao?method=toUserCenter&userId=${sessionScope.user.id }'/>" target="_top">《${sessionScope.user.name
				}》</a> <a href="<c:url value='/user/logout.ao?method=logOut'/>"	target="_top">[退出]</a></td>
				<td align="left" width="240px">&nbsp;您当前积分为<<${sessionScope.user.credits	}>>分</td>
				<td  align="left">&nbsp; <a href="<c:url value='/jsp/manager/Menu.jsp'/>" target="_top">管理员入口>>>></a></td>
			</c:if> 
			<!-- 管理员登录显示的内容 -->
			<c:if test="${user.role==0 }">
				<td align="left" width="260px">&nbsp; 欢迎 <a	href="<c:url value='/user/goToUserCenter.ao?method=toUserCenter&userId=${sessionScope.user.id }'/>" target="_top">《${sessionScope.user.name
				}》</a> <a href="<c:url value='/user/logout.ao?method=logOut'/>"	target="_top">[退出]</a></td>
				<td align="left" width="240px">&nbsp;您当前积分为<<${sessionScope.user.credits	}>>分</td>
				<td  align="left">&nbsp;  </td>
			</c:if> 
			
		</tr>
	</c:if>
</table> 
</div>  
</div>
<script type="text/javascript" src="<c:url value='/jsp/article/indexHeader.js'/>"></script>
 </body>
</html>