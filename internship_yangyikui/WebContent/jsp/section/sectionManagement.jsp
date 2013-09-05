<%--
	* createdate:2013-5-15 下午12:51:37
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
	<title>版块管理</title>
<link rel="stylesheet" type="text/css" href="../../skins/style_1/css/sectionManagement.css">	  
<script type="text/javascript">
var context = "<%=request.getContextPath()%>";
</script>
</head>
<body id="content">  
 
  <!-- 查询 -->
  <div style="display:none">
    	<div id="top">
    	<html:form action="/section/querySectionInfo.ao?method=getSecInfo">
    	  <table width="1141"  align="left">
    	    <tr>
    	     <c:if test="${user.role==2 }">
    	      <td width="77" height="29" align="right">版块名称：</td>
    	      <td width="155" align="left">&nbsp;<html:text property="attribute(sectionName)" styleId="name" style="width:142px" ></html:text></td>
    	      <td width="284" align="left">&nbsp;<input type="button" value="查询" id="seachbtn" class="btn"  onclick="querySectionInfo();"   isLoading='no'  onkeypress="cursorSwitch_();"></input> </td>
    	      <td width="137" align="center">&nbsp; <input class="btn" type="button" value="新建版块"  onClick="createSection();"/></td>
    	      <td width="103" align="center">&nbsp; <input class="btn" type="button" value="删除"  onclick="deleteSection();" /></td>
    	      <td width="176" align="center">&nbsp; <input class="btn" type="button" value="修改"  id="bcSection" style="width:110" onClick="updateSectionInfo();"   /></td>
    	    </c:if>  
  	      </tr>
  	    </table>
  	    </html:form>
   	</div>  
   	</div>
  <!-- 新建版块开始-->
 	<div  style="display:none">
        <div id="createSectionWindow" style="margin-left:50px; margin-top:20px" > 
        <html:form action="/section/createSection.ao?method=createSection" method="post" styleId="createSectionForm"  >
         <fieldset class="expandFieldset collapsedFieldset"  style="padding: 0px; margin-right: 35px;">
         <legend class="areaSpan"><span><label for="" style="font-size:14px">版块信息</label></span></legend>
				<table align="center" border="0" width="480">
				<!-- 隐藏用户id -->
				   <tr>
				      <td  align="right"></td>
			         <td ><html:hidden property="tSection.id"></html:hidden>
			          <html:hidden property="attribute(id)" value="${user.id }" styleId="userId"/>
			        </td>
			         <td ></td>
				   </tr>
				   <tr>
				      <td width="131" height="32" align="right">版块名称：</td>
			         <td width="190"><html:text property="tSection.sectionName" styleId="sectionName" style="width:183px"  ></html:text></td>
			         <td width="129"><span id="sname" style="color:red">*</span> </td>
				   </tr>
				   <tr>
				      <td height="33" align="right">版块简介：</td>
			         <td><html:textarea property="tSection.sectionIntro" styleId="sectionIntro" style="width:80"></html:textarea></td>
			         <td><span id="spassword" style="color:red">*</span></td>
				   </tr>
				   <tr>
				      <td height="33" align="right">版　　主：</td>
			         <td>
			          <html:select property="attribute(id)"  styleId="section" size="1" style="width:183px">
			       	 <html:option value="0">请选择版主</html:option>
			       	 <html:optionsCollection property="usernameList" label="name"  value="id" name="userForm"/> 
			       	 </html:select> 
			         </td>
			         <td><span id="spwd" style="color:red">*</span></td>
				   </tr>
				   <tr>
				      <td height="33" align="right">是否审核：</td>
				      <td colspan="2">
	     	         	<html:radio property="tSection.isAuditing" styleId="auditing" value="1" >是</html:radio>
							<html:radio property="tSection.isAuditing" styleId="auditing" value="0">否</html:radio>
				      </td>
				   </tr>
				   <tr>　
				      <td height="35" align="right">访问积分：</td>
				      <td>
	     		    <html:text property="tSection.visitCredits" style="width:183px"  styleId="visitCredits" ></html:text> </td>
				      <td></td>
				   </tr>
				   <tr>
				      <td height="37" colspan="3" align="center"><input type="button" id="btn"  class="content_save" value="保存" onClick="createSectionInfo();" ></input><html:reset value="取消" styleClass="content_cancel" onclick="clearFormData();" ></html:reset></td>
				   </tr>
			</table>
				</fieldset>
				</html:form>
        </div>
        </div>
       <!-- 新建版块结束 -->
       
       <!-- 修改版块开始 -->
       
   <div style="display:none">
     <div id="updateSectionWindow" style="margin-left:5px; margin-top:20px" > 
        <html:form action="/section/updateSection.ao?method=updateSectionInfo" method="post" styleId="updateSectionForm"  >
         <fieldset class="expandFieldset collapsedFieldset"  style="padding: 0px; margin-right: 5px;">
         <legend class="areaSpan"><span><label for="" style="font-size:14px">版块信息</label></span></legend>
				<table align="center" border="0" width="400">
				<!-- 隐藏用户id -->
				   <tr>
				      <td  align="right"></td>
			         <td align="center"><html:hidden property="tSection.id"></html:hidden></td>
			         <td ></td>
				   </tr>
				   <tr>
				      <td width="181" height="32" align="right">版块名称：</td>
			         <td width="156"><html:text property="tSection.sectionName"  styleId="upSectionName" style="width:142px"  ></html:text></td>
			         <td width="129"></td>
				   </tr> 
				   <tr>
				      <td height="33" align="right">是否审核：</td>
				      <td colspan="2">
	     	         	<html:radio property="tSection.isAuditing" styleId="upAuditing" value="1" >是</html:radio>
							<html:radio property="tSection.isAuditing" styleId="upAuditing" value="0">否</html:radio>
				      </td>
				   </tr>
				   <tr>　
				      <td height="35" align="right">访问积分：</td>
				      <td>
	     		    <html:text property="tSection.visitCredits" style="width:142px"  styleId="upVisitCredits" ></html:text> </td>
				      <td></td>
				   </tr>
				   <tr>
				      <td height="37" colspan="3" align="center"><input type="button" id="btn"  class="content_save" value="保存" onClick="updateSectionSibmit();" ></input><html:reset value="取消" styleClass="content_cancel" onclick="cancelUdate();" ></html:reset></td>
				   </tr>
			</table>
				</fieldset>
				</html:form> 
        </div>
        </div> 
       
<%@include file="/jsp/include/errorAndMsg.jsp"%> 
<script type="text/javascript" src="<c:url value='/jsp/section/sectionManagement.js'/>"></script>	
 
<script language="JavaScript"> 
					//新建验证 
					var validateArray = [
					                     {name:'tSection.sectionName',require:true, msg: "版块名名不能为空",event:'onblur'},
					                     {name:'tSection.sectionIntro',require:true, msg: "版块简介不能为空",event:'onblur'} 
					                     ];
					injectCommonValidator("createSectionForm",validateArray);
					//修改版块验证
					var validateArray = [
					                     {name:'tSection.sectionName',require:true, msg: "版块名名不能为空",event:'onblur'},
					                     {name:'tSection.visitCredits',require:true, msg: "访问积分不能为空",event:'onblur'} 
					                     ];
					injectCommonValidator("updateSectionForm",validateArray);  
</script>      
  <script type="text/javascript"> 
  $(document).ready(function(){ 
		 $("input[id=auditing][value=1]").attr("checked",true);//设置radio的默认值  
	});
  </script>
</body>
</html>