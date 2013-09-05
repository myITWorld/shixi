<%--
	* createdate:2013-5-15 下午12:51:37
	* Copyright: Tianjin Zoomkey Software Development Co.,Ltd.
	* JSP页面功能描述: hcms  
	* @author <a href="mailto:yangyikui@zoomkey.com.cn">yangyikui</a>
--%>
<%@page import="com.zoomkey.internship.persistence.model.TUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@include file="/jsp/include/errorAndMsg.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>文章管理</title>
<link rel="stylesheet" type="text/css" href="../../skins/style_1/css/articleManagement.css">	 

<script type="text/javascript">
var context = "<%=request.getContextPath()%>"; 
</script>
</head>
<body id="content"> 
 
  <!-- 查询 -->
  <div style="display:none">
    	<div id="top">
    	<html:form action="/article/queryArticleInfo.ao?method=getArticleInfo">
    	  <table width="1336"  align="left">
    	    <tr>
    	      <td width="49" align="right">作者:</td>
    	      <td width="129" align="left"><html:text property="attribute(username)" styleId="name"   ></html:text></td>
    	      <td width="82"  align="right">文章标题:</td>
    	      <td width="74" align="left"><html:text property="attribute(title)" styleId="title"   ></html:text></td>
    	      <td width="68"  align="right">版块:</td>
    	      <td width="125" align="left"><html:text property="attribute(sectionName)" styleId="sectionName"   ></html:text></td>
    	      
    	      <td width="90"  align="right"><input type="button" value="查询" class="btn"   isloading='no' onclick="queryArticleInfo();" onkeypress="cursorSwitch_();"></td>
    	      <td width="106"  align="right"><input class="btn" type="button" value="发文章" id="publishArt" onclick="pubArticle();"  /></td>
    	      <td width="65"  align="right"><input class="btn" type="button" value="置顶" onclick="setTop();"   /></td>
    	      <td width="58"  align="right"><input class="btn" type="button" value="精华" onclick="changeEss();"   /></td>
    	      <td width="66"  align="right"><input class="btn" type="button" value="删除" onclick="deleteArticle();"   /></td>
    	      <td width="372"  align="left"><input class="btn" type="button" value="审核" onclick="autiding();"  /></td>
   	        </tr>
  	    </table>
  	    </html:form>
   	</div>  
   	</div>
   	  <!-- 新发文章开始-->
 	<div  style="display:none">
        <div id="createArticleWindow" style="margin-left:10px; margin-top:20px" > 
        <html:form action="/article/createArticle.ao?method=createArticle" method="post" styleId="createArticleForm"  >
         <fieldset class="expandFieldset collapsedFieldset"  style="padding: 0px; margin-right: 15px;">
         <legend class="areaSpan"><span><label for="" style="font-size:14px">文章信息</label></span></legend>
				<table align="center" border="0" width="480">
				<!-- 隐藏用户id -->
				   <tr>
				      <td  align="right"></td>
			         <td ><html:hidden property="tArticle.id" value=""></html:hidden></td>
			         <html:hidden property="attribute(id)" value="${user.id }" styleId="userId"/>
			         <td ></td>
				   </tr>
				   <tr>
				      <td width="131" height="32" align="right">文章标题：</td>
			         <td width="190"><html:text property="tArticle.title" styleId="titleName" style="width:210px"  ></html:text></td>
			         <td width="129"><span id="sname" style="color:red">*</span> </td>
				   </tr>
				   <tr>
				      <td height="33" align="right">文章内容：</td>
			         <td><html:textarea property="tArticle.articleContent" styleId="articleContent" style="width:210;height:200"></html:textarea></td>
			         <td><span id="spassword" style="color:red">*</span></td>
				   </tr>
				   <tr>　
				      <td height="35" align="right">标签：</td>
				      <td>
	     		    <html:text property="tArticle.articleLabel" style="width:210px"  styleId="articleLabel" ></html:text> </td>
				      <td><span id="spwd" style="color:red">*</span></td>
				   </tr>
				   <tr>
				      <td height="33" align="right">选择版块：</td>
			         <td>
			        <html:select property="attribute(id)"  styleId="article" style="width:210px">
       	        <html:option value="">请选择版块名</html:option>
       	        <html:optionsCollection property="sectionInfoList" label="name"  value="id" name="sectionForm"/> 
       	        </html:select>  
			         </td>
			         <td><span id="spwd" style="color:red">*</span></td>
				   </tr> 
				   <tr>
				      <td height="37" colspan="3" align="center"><input type="button" id="btn"  class="content_save" value="保存" onClick="publishArticleInfo();" ></input><html:reset value="取消" styleClass="content_cancel" onclick="canclePub();" ></html:reset></td>
				   </tr>
			</table>
				</fieldset>
				</html:form>
        </div>
        </div>
       <!-- 发文章结束结束 --> 
        <html:form action="/article/articleDetailInfo.ao?method=showArticleDetail" method="post" styleId="detailArticleInfomation"  >
        </html:form>
<script language="JavaScript"> 
					//验证 
					var validateArray = [
					                     {name:'tArticle.title',require:true, msg: "文章标题不能为空",event:'onblur'},
					                     {name:'tArticle.articleContent',require:true, msg: "文章内容不能为空",event:'onblur'},
					                     {name:'tArticle.articleLabel',require:true, msg: "文章标签不能为空",event:'onblur'},
					                     {name:'attribute(id)',require:true, msg: "文章标签不能为空",event:'onblur'} 
					                    
					                     ];
					injectCommonValidator("createArticleForm",validateArray); 
					</script>     
       


<script type="text/javascript" src="<c:url value='/jsp/article/articleManagement.js'/>"></script>	 
 
</body>
</html>