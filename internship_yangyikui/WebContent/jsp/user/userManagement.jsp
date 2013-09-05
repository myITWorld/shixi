<%--
	* createdate:2013-5-8 上午10:13:24
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
	<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="../../skins/style_1/css/userManagement.css">	  
<script type="text/javascript">
var context = "<%=request.getContextPath()%>";
 




</script>
</head>
<body id="content">  
 
  <!-- 查询 -->
  <div style="display:none">
    	<div id="top">
    	<html:form action="/readMsg.do?method=getInfo">
    	  <table width="1141"  align="left">
    	    <tr>
    	      <td width="187" height="29" align="right">用户名：</td>
    	      <td width="284" align="left">&nbsp;<html:text property="attribute(name)" styleId="name" style="width:142px" ></html:text></td>
    	      <td width="160" align="center">&nbsp;<input type="button" value="查询" onkeypress="cursorSwitch_();"
    	         class="btn" id="seachbtn"  onclick="queryUserInfo();"   isLoading='no'></input> </td>
    	      <td width="154" align="center">&nbsp; <input class="btn" type="button" value="新建用户"  onclick="createUser();"/></td>
    	      <td width="122" align="center">&nbsp; <input class="btn" type="button" value="屏蔽"  onclick="shieldUserInfos();"   /></td>
    	      <td width="206" align="center">&nbsp; <input class="btn" type="button" value="提升为版主" onclick="becomeModerator();" id="bcSection" style="width:110"   /></td>
  	      </tr>
  	    </table>
  	    </html:form>
   	</div>  
   	</div>
   
   
    <!-- 注册 开始-->
    <div style="display:none">
        <div id="register" style="margin-left:50px; margin-top:20px" > 
        <html:form action="/register.do?method=register" method="post" styleId="registerForm" onsubmit="return checkForm();" >
         <fieldset class="expandFieldset collapsedFieldset"  style="padding: 0px; margin-right: 35px;">
         <legend class="areaSpan"><span><label for="" style="font-size:14px">注册信息</label></span></legend>
				<table align="center" border="0" width="480">
				<!-- 隐藏用户id -->
				   <tr>
				      <td  align="right"></td>
			         <td ><html:hidden property="tUser.id"></html:hidden></td>
			         <td ></td>
				   </tr>
				   <tr>
				      <td width="181" height="32" align="right">用户名：</td>
			         <td width="104"><html:text property="tUser.name" styleId="username" style="width:142px" onblur="checkUsername()" ></html:text></td>
			         <td width="181"><span id="sname" style="color:red">*</span> </td>
				   </tr>
				   <tr>
				      <td height="33" align="right">密　码：</td>
			         <td><html:password property="tUser.password" styleId="password"></html:password></td>
			         <td><span id="spassword" style="color:red">*</span></td>
				   </tr>
				   <tr>
				      <td height="33" align="right">确认密码：</td>
			         <td><html:password property="pwd" styleId="pwd"></html:password></td>
			         <td><span id="spwd" style="color:red">*</span></td>
				   </tr>
				   <tr>
				      <td height="33" align="right">性　别：</td>
				      <td colspan="2">
	     	         	<html:radio property="tUser.gender" styleId="gender" value="1" >女</html:radio>
							<html:radio property="tUser.gender" styleId="gender" value="0">男</html:radio>
				      </td>
				   </tr>
				   <tr>　
				      <td height="35" align="right">年　龄：</td>
				      <td>
	     		    <html:text property="tUser.age" style="width:142px"  styleId="age" ></html:text> </td>
				      <td></td>
				   </tr>
				   <tr>
				      <td height="37" colspan="3" align="center"><html:submit styleId="btn"  styleClass="content_save" value="保存" ></html:submit><html:reset value="取消" styleClass="content_cancel" onclick="clearFormData();" ></html:reset></td>
				   </tr>
			</table>
				</fieldset>
				</html:form>
					
        </div>
        </div>
       <!-- 注册结束 -->
       
        <!-- 提升为版主 开始  -->
      <div style="display:none">
       <div id="bacomeSec" style="margin-left:60px;">
          <html:form action="/section/moderator.ao?method=becomeModerator" styleId="selectSectionNameForm">
        <fieldset class="expandFieldset collapsedFieldset"  style="padding: 0px; margin-right: 30px;">
         <legend class="areaSpan"><span><label for="" style="font-size:14px">版主修改</label></span></legend>
       <table width="201"  align="center" style="margin-top:20px">
       	<tr> 
       	<td> 
       	 <html:select property="attribute(id)"  styleId="section" >
       	 <html:option value="">请选择版块名</html:option>
       	 <html:optionsCollection property="sectionInfoList" label="name"  value="id" name="sectionForm"/> 
       	 </html:select>  
       	 </td>
       	<td width="54"><input type="button"  value="保存" class="content_save" onclick="selectSectionName();"/></td>
       	</tr>
       </table>
        </fieldset>
       	</html:form>
       </div>
       </div>
       <!-- 提升为版主结束 -->
<%@include file="/jsp/include/errorAndMsg.jsp"%> 
<script type="text/javascript" src="<c:url value='/jsp/user/userManagement.js'/>"></script>	 
<script language="JavaScript">   
 
$(document).ready(function(){ 
	 $("input[id=gender][value=1]").attr("checked",true);//设置radio的默认值  
});
/**
 * ajax验证用户名是否可用
 */
 function checkUsername(){ 
		var name=$("#username").val();  
		if(name.length!=0){
			$.ajax( {
				type : "post",
				url : padUrl( "/ajax.ao?method=checkIfUserExits"),
				data : {"name" : name},
				dataType : "json",
				success : function(json) {
				var message = json.msg;
				var state = json.state; 
				$("#sname").text(message);
				$("#sname").css("color","red");
				if (state) { 
					return false;
					}else
					{ 
					$("#sname").css("color","green");
					return true;
					}
				}
			});
		}
		else{
			$("#sname").text("用户名不能为空");
			return false;
			}
	}
	
</script>
<script language="JavaScript"> 
					//验证 
					var validateArray = [
					                     //{name:'tUser.name',require:true, msg: "用户名不能为空",event:'onblur'},
					                     {name:'tUser.name',dataType:"Custom",regexp:/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/, msg: "用户名必须为邮箱格式",event:'onblur'},
					                     {name:'tUser.password',require:true, msg: "密码不能为空",event:'onblur'},
					                     {name:'pwd',require:true, msg: "确认密码不能为空",event:'onblur'},
					                     {name:'tUser.age',dataType:"Number", msg: "年龄输入的必须是数字",event:'onblur'} 
					                     ];
					injectCommonValidator("registerForm",validateArray); 
					</script>
</body>
</html>