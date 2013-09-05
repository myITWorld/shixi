<%--
	* createdate:2013-5-23 下午03:13:35
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
 <html:form action="/user/updateInfo.do?method=updateUserInfo" method="post" styleId="registerForm" onsubmit="return checkForm();" >
         <fieldset class="expandFieldset collapsedFieldset"  style="padding: 0px; margin-right: 35px;">
         <legend class="areaSpan"><span><label for="" style="font-size:14px">注册信息</label></span></legend>
	 <table align="center" border="0" width="480">
				<!-- 隐藏用户id -->
				   <tr>
				      <td  align="right"></td>
			         <td ><html:hidden property="tUser.id" value="${use.id }"></html:hidden></td>
			         <td ></td>
				   </tr>
				   <tr>
				      <td width="181" height="32" align="right">用户名：</td>
			         <td width="104"><html:text property="tUser.name" styleId="username" style="width:142px" onblur="checkUsername()" value="${use.name }" readonly="true" ></html:text></td>
			         <td width="181"><span id="sname" style="color:red">*</span> </td>
				   </tr> 
				   <tr>
				      <td height="33" align="right">性　别：</td>
				      <td colspan="2">
				      	<html:hidden property="attribute(gender)" value="${use.gender }" styleId="genderValue"></html:hidden>
	     	         	<html:radio property="tUser.gender" styleId="gender" value="1" >男</html:radio>
							<html:radio property="tUser.gender" styleId="gender" value="0">女</html:radio>
				      </td>
				   </tr>
				   <tr>　
				      <td height="35" align="right">年　龄：</td>
				      <td>
	     		    <html:text property="tUser.age" style="width:142px"  styleId="age" value="${use.age }" ></html:text> </td>
				      <td></td>
				   </tr>
				   <tr>
				      <td height="37" colspan="3" align="center"><html:submit styleId="btn"  styleClass="content_save" value="保存" ></html:submit><html:reset value="取消" styleClass="content_cancel" onclick="history.back();" ></html:reset></td>
				   </tr>
			</table>
			</fieldset>
			
			</html:form>
			
			
			
			 <script type="text/javascript">
			 		var gender = $("#genderValue").val();
			 		if(gender==1){
			 		 $("input[id=gender][value=1]").attr("checked",true);//设置radio的默认值  
			 		}else{
			 			 $("input[id=gender][value=0]").attr("checked",true);
				 		}
			 		
			 
			 </script>
</body>
</html>