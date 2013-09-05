<%--
	* createdate:2013-5-15 下午12:51:37
	* Copyright: Tianjin Zoomkey Software Development Co.,Ltd.
	* JSP页面功能描述: hcms  
	* @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
--%>
<%@page import="com.zoomkey.internship.persistence.model.TUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/include/errorAndMsg.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>文章管理</title>
<%-- FIXME:url需要通过c标签去写 --%>
<link rel="stylesheet" type="text/css"
	href="../../skins/style_1/css/articleManagement.css">

<script type="text/javascript">
var context = "<%=request.getContextPath()%>"; 
var sectionId = "${sectionId }"; 
</script>
</head>
<body id="content"> 
<div style="display:none">
<div id="btnTop" style="width: 1111px"><html:form
	action="/article/queryArticleInfo.ao?method=getArticleIndexInfo">
	<table width="1111" border="0" cellpadding="0" cellspacing="0">
		<tr>
		<html:hidden property="attribute(credits)" value="${user.credits }" styleId="creditsInfo"/>
		<html:hidden property="attribute(userId)" value="${user.id }" styleId="userId"/>
		<html:hidden property="attribute(name)" value="${user.name }" styleId="username"/>
	 <!--  -->
			<c:if test="${user.id==tSection.userId&&user.role==1 }">
				<td align="right">&nbsp;快速检索</td>
				<td width="140" align="left">&nbsp; <html:text style="width:125px"
					property="attribute(content)" styleId="title"
					onkeypress="cursorSwitch_();"
					onkeydown="if(event.keyCode==13){queryArticleIndexInfo();}"></html:text>
				</td>
				<td width="56" align="right"><input class="btn" type="button"
					value="发文章" id="publishArt" onClick="pubArticle();" /></td>
				<td width="42" align="right"><input class="btn" type="button"
					value="置顶" onClick="setTop();" /></td>
				<td width="42" align="right"><input class="btn" type="button"
					value="精华" onClick="changeEss();" /></td>
				<td width="116" align="left"><input class="btn" type="button"
					value="删除" onClick="deleteArticle();" /></td>
			</c:if>
			<c:if test="${user.id!=tSection.userId&&user!=null&&user.role==1 }">
			<td width="519" align="right">&nbsp;快速检索</td>
				<td width="140" align="left"><html:text
					property="attribute(content)" styleId="title"
					onkeypress="cursorSwitch_();"
					onkeydown="if(event.keyCode==13){queryArticleIndexInfo();}"></html:text>
				</td>
				<td width="424" align="left"><input class="btn" type="button"
					value="发文章" id="publishArt" onClick="pubArticle();" /></td>
			</c:if>
			<c:if test="${user.role==2 }">
				<td align="right">&nbsp;快速检索</td>
				<td width="140" align="left">&nbsp; <html:text style="width:125px"
					property="attribute(content)" styleId="title"
					onkeypress="cursorSwitch_();"
					onkeydown="if(event.keyCode==13){queryArticleIndexInfo();}"></html:text>
				</td>
				<td width="56" align="right"><input class="btn" type="button"
					value="发文章" id="publishArt" onClick="pubArticle();" /></td>
				<td width="42" align="right"><input class="btn" type="button"
					value="置顶" onClick="setTop();" /></td>
				<td width="42" align="right"><input class="btn" type="button"
					value="精华" onClick="changeEss();" /></td>
				<td width="116" align="left"><input class="btn" type="button"
					value="删除" onClick="deleteArticle();" /></td>
			</c:if>
			 
			<c:if test="${user.role==0}">
				<td width="519" align="right">&nbsp;快速检索</td>
				<td width="140" align="left"><html:text
					property="attribute(content)" styleId="title"
					onkeypress="cursorSwitch_();"
					onkeydown="if(event.keyCode==13){queryArticleIndexInfo();}"></html:text>
				</td>
				<td width="424" align="left"><input class="btn" type="button"
					value="发文章" id="publishArt" onClick="pubArticle();" /></td>
			</c:if>

			<c:if test="${user==null }">
				<td width="866" align="right">&nbsp;快速检索</td>
				<td width="232" align="left"><html:text
					property="attribute(content)" styleId="title"
					onkeypress="cursorSwitch_();"
					onkeydown="if(event.keyCode==13){queryArticleIndexInfo();}"></html:text>
				</td>
			</c:if>
		</tr>
	</table>
</html:form></div>
</div>

<script type="text/javascript"
	src="<c:url value='/jsp/article/indexCenter.js'/>"></script>
</body>
</html>