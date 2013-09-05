<%--
	* createdate:2013-5-19 下午02:26:22
	* Copyright: Tianjin Zoomkey Software Development Co.,Ltd.
	* JSP页面功能描述: hcms  
	* @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
--%>
<%@page import="com.zoomkey.internship.persistence.model.TArticle"%>
<%@page import="com.zoomkey.internship.persistence.model.TUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>文章详细</title>
	<%@include file="/jsp/include/errorAndMsg.jsp"%> 
<script language="JavaScript">

</script>
</head>
<body id="content">  
 
    	<div id="top" > 
    	  <table  align="center">
    	    <tr> 
    	    <!-- 管理员 -->
    	    <c:if test="${user.role==2 }"> 
    	      <td width="258"  align="right"><input class="btn" type="button" value="置顶" onClick="setTop();"    /></td>
    	      <td width="44"  align="right"><input class="btn" type="button" value="精华"  onclick="changeEss();"  /></td>
    	      <!-- 如果是管理员发的文章可以修改 -->
    	      <c:if test="${user.name== article.TUser.name}">
    	      <td width="46"  align="right"><input class="btn" type="button" value="修改" id="publishArt" onClick="updateArticle();"  /></td>
    	      </c:if>
    	      <td width="50"  align="right"><input class="btn" type="button" value="删除" onClick="deleteArticle();"   /></td>
    	      <td width="914"  align="left"><input class="btn" type="button" value="审核通过" onClick="autiding();"  /></td>
    	     </c:if> 
    	 
    	    <!-- 版主 -->
    	    <c:if test="${user.role==1}">
    	    <!-- 进入该版主管辖下的版块文章 -->
    	       <c:if test="${user.id==article.TSection.userId }">
    	      <td width="258"  align="right"><input class="btn" type="button" value="置顶" onClick="setTop();"    /></td>
    	      <td width="44"  align="right"><input class="btn" type="button" value="精华"  onclick="changeEss();"  /></td>
    	     </c:if>
    	     </c:if>
    	     <!-- 版主所发文章可以修改 -->
    	       <c:if test="${user.role==1}">
    	      <c:if test="${user.name== article.TUser.name}">
    	      <td width="46"  align="right"><input class="btn" type="button" value="修改" id="publishArt" onClick="updateArticle();"  /></td>
    	      <td width="50"  align="right"><input class="btn" type="button" value="删除" onClick="deleteArticle();"   /></td>
    	      </c:if>
    	      </c:if>
    	      <c:if test="${user.role==1}"> 
    	       <c:if test="${user.id==article.TSection.userId }">
    	      <td width="914"  align="left"><input class="btn" type="button" value="审核通过" onClick="autiding();"  /></td>
    	     </c:if>
    	     </c:if>
    	     <!-- 登录用户为该文章的作者 -->
    	     <c:if test="${user.name== article.TUser.name}">
    	     <c:if test="${user.role==0 }">
    	       <td width="336"  align="right"><input class="btn" type="button" value="修改" id="publishArt" onClick="updateArticle();"   /></td>
    	      <td width="988"  align="left"><input class="btn" type="button" value="删除" onClick="deleteArticle();"   /></td>
    	    </c:if>
    	    </c:if>
    	     
   	   </tr> 
  	    </table> 

<table width="766" height="458" border="1" align="center" style=" margin-top: 10px" id="detailInfo">
 <!-- 隐藏id -->
  <html:hidden property="attribute(id)"  value="${sessionScope.article.id }"  styleId="id"/> 
  <html:hidden property="attribute(sectionId)" value="${sessionScope.article.TSection.id }" styleId="sectionId"/>
   
  <tr>
    <td width="132"  height="52" align="right">版块名称：</td>
    <td width="618" height="52" align="left">&nbsp;<a href="javascript:void(0)" onclick="SectionOfArticle();" target="userM" >${sessionScope.article.TSection.sectionName }</a>
   
    </td>
  </tr>
  <tr>
    <td height="31" align="right">文章标题：</td>
    <td height="31" align="left">&nbsp; 
   <c:if test="${sessionScope.article.isTop==1}">
   <img  src='../skins/style_1/images/icon/zhiding.png' alt="置顶" style="margin_top:3px" />
    </c:if>
   <c:if test="${sessionScope.article.isEssence==1}">
   <img  src='../skins/style_1/images/icon/jinghua.png' alt="精华" style="margin_top:3px" />
    </c:if>
    ${sessionScope.article.title }</td>
  </tr>
  <tr>
    <td height="32" align="right">文章作者：</td>
    <td height="32" align="left">&nbsp;${sessionScope.article.TUser.name }</td>
  </tr>
  <tr>
    <td height="28" align="right">发布时间：</td>
    <td height="28" align="left">&nbsp;${sessionScope.article.createTime}</td>
  </tr>
  <tr>
    <td height="31" align="right">修改时间：</td>
    <td height="31" align="left">&nbsp;${sessionScope.article.updateTime}</td>
  </tr>
  <tr>
    <td align="right">文章标签：</td>
    <td height="30" align="left">&nbsp;${sessionScope.article.articleLabel}</td>
  </tr>
  <tr>
    <td height="156" align="right">文章内容：</td>
    <td height="156" align="left">
   <textarea rows="12" cols="80"  readonly="false"  > 
    &nbsp;${sessionScope.article.articleContent}</textarea></td>
  </tr>
  <tr>
    <td colspan="2" align="right">&nbsp;<input type="button" id="btn" class="content_next" value="返回" onClick="history.back();" /></td>
  </tr>
</table>   
</div>
<div id="bottom" style="display:none"></div>
 <link rel="stylesheet" type="text/css" href="../../skins/style_1/css/articleDetail.css">
 <script type="text/javascript" src="<c:url value='/jsp/article/articleDetail.js'/>"></script>	
</body>
</html>