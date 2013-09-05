<%--
	* createdate:2013-5-23 下午05:10:39
	* Copyright: Tianjin Zoomkey Software Development Co.,Ltd.
	* JSP页面功能描述: hcms  
	* @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<div id="title" style="margin:0 auto; font-size:20px; font-family:Tahoma, Geneva, sans-serif"><center>文章列表</center></div>
  <%
  List list = (List)session.getAttribute("list");
  if(list.size()>0){
  %>
<div id="articleInfo">
  <table width="100%" border="1">
  
    <tr>
      <td height="40" align="center">文章标题</td>
      <td height="40" align="center">作者</td> 
      <td height="40" align="center">是否审核</td>
      <td height="40" align="center">创建时间</td>
      <td height="40" align="center">标签</td>
      <td height="40" align="center">是否精华</td>
      <td height="40" align="center">是否置顶</td>
    </tr>
    <logic:iterate id="article" name="list" >
			<tr>
			<html:hidden property="attribute(id)" value="${article.id }"/>
			 <td height="40" align="center">
			   <a href="<c:url value='/article/articleDetailInfo.ao?method=showArticleDetail&articleId=${article.id }'/>" target="userM">${article.title}</a>  
		
			 </td>
			  <td height="40" align="center">${article.TUser.name } </td> 
			  <td height="40" align="center">${article.isAuditing } </td>   
			  <td height="40" align="center">${article.createTime } </td>
			  <td height="40" align="center">${article.articleLabel }  </td>   
			  <td height="40" align="center">
			   <c:if test="${article.isEssence==1 }">
				  <img  src='../../skins/style_1/images/icon/jinghua.png' alt="精华" style="margin_top:3px" />
				 </c:if>
			   <c:if test="${article.isEssence==0 }">
				              否
				 </c:if>
			  </td>
				<td height="40" align="center"> 
				   <c:if test="${article.isTop==1 }">
					  <img  src='../../skins/style_1/images/icon/zhiding.png' alt="置顶" style="margin_top:3px" />
					 </c:if>
				   <c:if test="${article.isTop==0 }">
					      否
					 </c:if>
				</td>   
			</tr>
   </logic:iterate>
  </table>
</div>  
  <%}else{ %>
   
     <a href="<c:url value='/goToArticle.ao?method=toArticleMana'/>" >还没发表文章，赶紧去发表吧！</a>  
		
   <%} %>
</body>
</html>