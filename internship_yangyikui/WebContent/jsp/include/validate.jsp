<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<script type="text/javascript">

$(function(){
	//validate_();
});

 

//对所有class里包含有money的input元素进行数字校验，样式格式为validate_x-y  ,x为数字最大总长度，y为小数位最大总长度
 

/************************校验提示*************************************/
//校验通过
function success_(obj){
	//obj.css('backgroundColor','');
	return true;
};
//校验失败
function fail_(msg,obj){
	showMessage(msg,"warn");
	//obj.css('backgroundColor',"#BBBBBB");
	obj.val(0).change();
	return false;
};
	
	
</script>