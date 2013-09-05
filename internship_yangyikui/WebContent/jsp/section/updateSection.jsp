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
  <!-- 修改版块开始 -->
   <div style="display:block">
     <div id="updateSectionWindow" style="margin-left:5px; margin-top:20px" > 
        <html:form action="/section/updateSection.ao?method=updateSec" method="post" styleId="updateSectionForm"  >
         <fieldset class="expandFieldset collapsedFieldset"  style="padding: 0px; margin-right: 5px;">
         <legend class="areaSpan"><span><label for="" style="font-size:14px">修改版块</label></span></legend>
				<table align="center" border="0" width="400">
				<!-- 隐藏用户id -->
				   <tr>
				      <td  align="right"></td>
			         <td align="center"><html:hidden property="tSection.id" value="${section.id }"></html:hidden></td>
			         <td ></td>
				   </tr>
				   <tr>
				      <td width="181" height="32" align="right">版块名称：</td>
			         <td width="156"><html:text property="tSection.sectionName"  styleId="upSectionName" style="width:142px"  value="${section.sectionName }" ></html:text></td>
			         <td width="129"></td>
				   </tr> 
				   <tr>
				      <td height="33" align="right">是否审核：</td>
				      <td colspan="2">
				      <html:hidden property="attribute(au)" value="${section.isAuditing }" styleId="isA"/>
	     	         	<html:radio property="tSection.isAuditing" styleId="upAuditing" value="1" >是</html:radio>
							<html:radio property="tSection.isAuditing" styleId="upAuditing" value="0">否</html:radio>
				      </td>
				   </tr>
				   <tr>　
				      <td height="35" align="right">访问积分：</td>
				      <td>
	     		    <html:text property="tSection.visitCredits" style="width:142px"  styleId="upVisitCredits"  value="${section.visitCredits }"></html:text> </td>
				      <td></td>
				   </tr>
				   <tr>
				      <td height="37" colspan="3" align="center"><html:submit   styleId="btn"  styleClass="content_save" value="保存"   ></html:submit><html:reset value="取消" styleClass="content_cancel" onclick="cancelUp();" ></html:reset></td>
				   </tr>
			</table>
				</fieldset>
				</html:form> 
        </div>
    </div> 
       
<%@include file="/jsp/include/errorAndMsg.jsp"%>  
 
<script language="JavaScript"> 
					//验证 
					var validateArray = [
					                     {name:'tSection.sectionName',require:true, msg: "版块名名不能为空",event:'onblur'},
					                     {name:'tSection.visitCredits',require:true, msg: "访问积分不能为空",event:'onblur'} 
					                     ];
					injectCommonValidator("updateSectionForm",validateArray); 
					var autid = $("#isA").val();
			 		if(autid==1){
			 		 $("input[id=upAuditing][value=1]").attr("checked",true);//设置radio的默认值  
			 		}else{
			 			 $("input[id=upAuditing][value=0]").attr("checked",true);
				 		}
			function cancelUp(){
					location = padUrl("/goToSection.ao?method=toSectionMana");

				}
</script>      
  <script type="text/javascript"> 
  $(document).ready(function(){ 
		 $("input[id=auditing][value=1]").attr("checked",true);//设置radio的默认值  
	});
  </script>
</body>
</html>