<%--
	* createdate:2013-5-15 下午12:51:37
	* Copyright: Tianjin Zoomkey Software Development Co.,Ltd.
	* JSP页面功能描述: hcms  
	* @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
--%>
<%@page import="com.zoomkey.internship.persistence.model.TUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/security.tld" prefix="security" %>
 <%@include file="/jsp/include/errorAndMsg.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>发表文章</title>

<script type="text/javascript" src="<c:url value='/jsp/article/publishArticle.js'/>"></script>	 
 
<script type="text/javascript">
var context = "<%=request.getContextPath()%>"; 
</script>
</head>
<body id="content"> 
<center>
       <!-- 发表文章布局开始 --> 
        <div id="createArticleWindow" style="width:1093px;height:550px; border:2px solid #99BBE8" > 
        <html:form action="/article/createArticle.ao?method=createArticle" method="post" styleId="createArticleForm"  >
				<table width="630" height="480" border="0" align="center" > 
				   <tr>
				      <td width="131" height="40"  align="right"></td>
			         <td >
			           <%
			        	if(session.getAttribute("article")==null){
			        %>
			         <h1 align="center">发布文章</h1>
			         <%}else{ %>
			           <h1 align="center">修改文章</h1>
			         <%} %>
			         </td>
			         <td ></td>
				   </tr>
				<!-- 隐藏用户id -->
				   <tr>
				      <td height="1"  align="right"></td>
			         <td ><html:hidden property="tArticle.id" value="${sessionScope.article.id }"></html:hidden></td>
			         <td ></td>
				   </tr>
				   <tr>
				      <td  height="32" align="right">文章标题：</td>
			         <td width="325"><html:text property="tArticle.title" styleId="titleName" style="width:314px" value="${sessionScope.article.title }"  ></html:text></td>
			         <td width="160"><span id="sname" style="color:red">*</span> </td>
				   </tr>
				   <tr>
				      <td height="274" align="right">文章内容：</td>
			         <td><html:textarea property="tArticle.articleContent" styleId="articleContent" style="width:314;height:275"  value="${sessionScope.article.articleContent}"></html:textarea></td>
			         <td><span id="spassword" style="color:red">*</span></td>
				   </tr>
				   <tr>　
				      <td height="34" align="right">标签：</td>
				      <td>
                <html:text property="tArticle.articleLabel" style="width:250px"  styleId="articleLabel" value="${sessionScope.article.articleLabel}" ></html:text> </td>
				      <td><span id="spwd" style="color:red">*</span></td>
				   </tr>
				   <tr>
				      <td height="23" align="right">选择版块：</td>
			         <td align=left">
			         
			        <html:select property="attribute(id)"  styleId="article" style="width:250px" value="${sessionScope.article.TSection.sectionName }">
			        <%
			        	if(session.getAttribute("article")!=null){
			        %>
       	        <html:option value="${sessionScope.article.TSection.sectionName }"  styleId="defaultValue" >${sessionScope.article.TSection.sectionName }</html:option> 
       	        <%}else{ %>
       	        <html:option value="0">请选择版块名</html:option> 
       	        <%} %>
       	        <html:optionsCollection property="sectionInfoList" label="name"  value="id" name="sectionForm"/> 
       	        </html:select>
       	         
			         </td>
			         <td><span id="spwd" style="color:red">*</span></td>
				   </tr> 
				   <tr>
				      <td height="68" colspan="3" align="right" style="padding_right:30px">
				      <input type="button" id="btn"  class="content_save" value="保存" onClick="publishArticleInfo();" ></input>
				      <html:reset value="取消" styleClass="content_cancel" onclick="canclePub();" ></html:reset>
				      <input type="button" id="btn" value="返回" class="content_next" onClick="goBack();"/>
			      </tr>
</table> 
				</html:form>
        </div>
       <!-- 发表文章布局结束 --> 
       <script language="JavaScript"> 
					//验证 
					var validateArray = [
					                     {name:'tArticle.title',require:true, msg: "文章标题不能为空",event:'onblur'},
					                     {name:'tArticle.articleContent',require:true, msg: "文章内容不能为空",event:'onblur'},
					                     {name:'tArticle.articleLabel',require:true, msg: "文章标签不能为空",event:'onblur'} 
					                    
					                     ];
					injectCommonValidator("createArticleForm",validateArray); 
					</script>   
					</center> 
</body>
</html>