<%--
	* createdate:2013-5-7 下午01:58:13
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
<title>登录界面</title>
<%@include file="/jsp/include/errorAndMsg.jsp"%>  
<link rel="stylesheet" type="text/css" href="../../skins/style_1/css/login.css">
<script type="text/javascript">
 
function checkForm(){
var name = $("#name").val(); 
var password = $("#password").val();
if(""==name||null==name){
	alert("用户名不能为空");
	return false;
}

if(""==password||null==password){
	alert("密码不能为空");
	return false;
}
} 
</script>
<style type="text/css">

*{ margin:0; border:0}
html{ overflow:hidden}
#content{background:#5E85C6;}
#login{  background-image:url(../../skins/style_1/images/login.png);width:667px;height:390px; margin-left:400px; margin-top:100px;border:1px solid black} 
table{ position:absolute; top:379px; left:445px} 
#name, #password{width:121px;height:19px}
#lgbtn{width:78px;height:22px}
</style>
</head>
<body id="content" >  
<div id="login" >
<html:form action="/login.ao?method=login" method="post" onsubmit="return checkForm();" styleId="loginform"  >
<table width="585" >
  <tr>
    <td width="106" height="27">&nbsp;</td>
    <td width="140">&nbsp;<html:text property="tUser.name"   styleId="name"  ></html:text></td>
    <td width="83">&nbsp;</td>
    <td width="134">&nbsp;<html:password property="tUser.password" styleId="password"></html:password></td>
    <td width="98">&nbsp;<html:submit value="登录" styleId="lgbtn"></html:submit></td>
  </tr>
</table>
</html:form> 
</div>
<!-- 验证 -->
<script type="text/javascript">
var validateArray = [{name:'tUser.name',require:true, msg: "用户名不能为空",event:'onblur'},
                     {name:'tUser.name',dataType:"Custom",regexp:/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/, msg: "邮箱格式不正确",event:'onblur'},
                     
                     {name:'tUser.password',require:true, msg: "密码不能为空",event:'onblur'}
                     ];
injectCommonValidator("loginform",validateArray); 
</script>
</body>
</html>