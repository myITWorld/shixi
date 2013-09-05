<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/security.tld" prefix="security" %>
<%@page import="org.apache.struts.Globals"%>
<%@page import="org.apache.struts.action.ActionMessages"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.struts.action.ActionMessage"%>
<%@page import="org.apache.struts.taglib.TagUtils"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/skins/style_1/css/style.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/skins/style_1/css/tree.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/js/ext/resources/css/ext-all.css'/>" />
<script type="text/javascript" src="<c:url value='/js/base/base.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/plugins/jquery.form.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery/plugins/jquery.hotkeys.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ext/ext-base.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ext/ext-all.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ext/ext-lang-zh_CN.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ext/zoomkey/GridPanel.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/js/ext/resources/css/ext-font-patch.css'/>" />
<script type="text/javascript" src="<c:url value='/js/jquery/plugins/jquery.bgiframe.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/common/validator.js'/>"></script>
<style>
/*解决下拉树的文本框和下拉箭头对不齐的问题*/
.ext-ie6 .x-form-text, .ext-ie7 .x-form-text {
    margin:0px 0; /* ie bogus margin bug */
    height:18px; /* ie quirks */
    line-height:18px;
}
</style>
<script type="text/javascript">

/**
 * 系统上下文，用于js文件中定义url
 * @type {String}
 */
var context = "${pageContext.request.contextPath}";

$(function(){
	//给页面所有的列表行加上onmouseover效果
	$("tr.even_row").hover(function(){
	  	this.style.backgroundColor = "#e4f2fb";
	  	//$(this).addClass("top_border");
	 },function(){
	 	this.style.backgroundColor = "#ffffff";
	  	//this.style=this.style+"border-top:1px solid #ff0000";
	  //	$(this).addClass("top_border");
	 });
	$("tr.even_row_gray").hover(function(){
	  	this.style.backgroundColor = "#e4f2fb";
	 },function(){
	 	// modified by Wang Cheng 2011-2-15 [XB-137] begin
	 	this.style.backgroundColor = "#F0EEEE";
	 	// [XB-137] end
	 });
	 //当页面的保存按钮被点击时，将其disable，防止重复提交
 	 $(":button[value='保存']").live("click", function(){
	 	setBtnBrevityDisable_(this, 30000);
	 /*	window.setTimeout(function(){
		 	if(document.all.moduleDiv.style.display=='none'){
			 	showLoadingTip();
		 	}else{
		 		hideLoadingTip();
		 	}
	 	},300);*/
	 });
	 //当页面的查询按钮被点击时，显示loading信息
	 $("input[type=button][value='查询'][isLoading!='no']").click(function(){
	 		setBtnBrevityDisable_(this);
	 		window.setTimeout(function(){
			 	if(document.all.moduleDiv.style.display=='none' || document.all.moduleDiv.style.display==''){
				 	showLoadingTip();
			 	}else{
			 		hideLoadingTip();
			 	}
		 	},100);
	 });
	 //页面加载后将loading图标隐藏
	window.setTimeout(function(){ 
			hideLoadingTip();
		},200);
	 //给页面弹出div增加拖拽效果
	 easyDragEffect_();

	// modified by Wang Cheng 2011-2-15 [XB-137] begin
 	// 鼠标经过改变按钮颜色
	$(".btn").mouseover(function(){
		$(this).addClass("btn_over");
	});
	$(".btn").mouseout(function(){
		$(this).removeClass("btn_over");
	});
	// 鼠标经过改变表格标题颜色
//		$("#current_list_3 table thead td").mouseover(function(){
//			$(this).addClass("current_list_3_thead_td_over");
//		});
//		$("#current_list_3 table thead td").mouseout(function(){
//			$(this).removeClass("current_list_3_thead_td_over");
//		});
	// [XB-137] end
});

Ext.onReady(function(){
	Ext.BLANK_IMAGE_URL = context+"/js/ext/resources/images/default/s.gif";
});

/*******************防重复提交：按钮点击后失效********************/
function setBtnBrevityDisable_(bt , time){
	if(time == undefined){
		time = 1000;
	}
	bt.disabled = true;	
	// modified by Wang Cheng 2011-2-15 [XB-137] begin
	// 单击按钮时不能自动执行removeClass方法，这里需要在执行一次，不知为什么
	$(bt).removeClass("btn_over");
	// [XB-137] end
	window.setTimeout(function(bu){bt.disabled = false},time);
}

//显示loading图标
function showLoadingTip(){
	document.all.moduleDiv.style.display='none'; 
	$("#public_loading").show();
}
//隐藏loading图标
function hideLoadingTip(){
	$(document).find("#public_loading").hide();
	$(window.parent.document).find("#public_loading").hide();
}

/***************屏蔽右键、后退键、F5*****************/
/*document.oncontextmenu = function(){
	window.event.returnValue=false;
}

document.onkeydown = function(){   
		 //屏蔽退格删除键     
   if (((event.keyCode == 8) && (event.srcElement.type != "text" && event.srcElement.type != "textarea" && event.srcElement.type != "password")) 
		||  //屏蔽 F5 刷新键    
      (event.keyCode==116)
      ||  //Ctrl + R          
      (event.ctrlKey && event.keyCode==82)){ 
     event.keyCode=0;    
     event.returnValue=false;    
   }    
} */
/*
 *frame框架页面在头部frame显示消息时需要调用此函数
 *messageObj： 封装了作物消息 arrayList 和  错误状态 state
 */
function showFrameTip(messageObj){
	if(messageObj != undefined && messageObj != null){
		var message = '';
		with(messageObj){
			for(var ms=0;ms<infos.length;ms++){
				message += infos[ms]+"  "; 
			}
			showMessage(message,state);
		}
	}else{
		alert('系统消息提示功能异常!');
		return;
	}
}
function closeDiv(){
	var infoDiv = document.getElementById("moduleDiv");
	infoDiv.style.display = "none";
	document.all.messageInfo.innerHTML="";
}
/*
 *显示 返回的提示信息
 *ajax提交，自动解析传递过来的信息，在页面上进行展示
 */
function showJsonMessage(tips){
	if(!tips){
		return false;
	}
	showMessage(tips.info, tips.state);
	return showMessageState(tips.state);
}

function showMessageState(state){
	if(state && (state=='warn' || state=="error")){
		return false;
	}else{
		return true;
	}
}
/*
 *显示 返回的提示信息
 *info:提示字符串，自己注意控制换行
 *state：信息提示类型， success 成功，error 失败
 */
function showMessage(info,state){
	closeDiv();
	if(!info||!state){
		return false;
	}
	//如果是iframe列表结构的页面，提示信息需要显示在父级页面上
	if(parent && parent!=window && parent.showMessage){
		parent.showMessage(info,state);
		// 恢复保存按钮
		enableSaveBtn();
		return false;
	}
	//进行消息提示前将loading图标隐藏，避免显示冲突
	hideLoadingTip();
	clearTimeout(timer);
	document.all.messageInfo.innerHTML = info;
	modifyInfo(state);
	// 恢复保存按钮
	enableSaveBtn();
}
var timer ;
function modifyInfo(state){
	//设置ｄｉｖ提示样式和信息
	switch(state){
		case 'error' :
			document.all.moduleDiv.className='messageDiv_error';
			break;
		case 'success' :
			document.all.moduleDiv.className='messageDiv_ok';
			break;
		case 'warn' :
			document.all.moduleDiv.className='messageDiv_warn';
			break;
		default :
			alert('消息提示参数设置类型错误！')
	}
	document.all.moduleDiv.style.display='block'; 
	timer = window.setTimeout("closeDiv()",8000); 
	//document.all.moduleDiv.focus();//added to get focus
}

/**
 * 恢复保存按钮（支持普通按钮、Ext按钮）
 */
function enableSaveBtn(){
	setTimeout(function(){
		$(":button[value='保存']").attr("disabled", false);
	}, 3000);
}
/**
 * 将光标绑定到指定的按钮上
 */
function focusBindBtn(btnId){
       $("#"+btnId).focus()
}
/*********************** Ext列宽度定义开始 ****************************/
/**
 * 超短，适用于：收费相关字段（如优惠金额、实收采暖费等等）
 */
var small_ = 68;
/**
 * 短，适用于：客户卡号、楼、单元、室、客户类型、电话、日期等
 */
var short_ = 95;

/**
 * 中，适用于：供热站、客户名称、小区、时间等
 */
var middle_ = 125;

/**
 * 长，适用于：地址（小区 + 楼 + 单元 + 室）等
 */
var long_ = 230;

/**
 * 超长，适用于：
 */
var super_long_ = 400;

/*********************** Ext列宽度定义结束 ****************************/

/*********************** Ext列表样式定义开始 *******************************/
/**
 * column内容居右
 * @param {Float} 需要处理的json数值
 */
function gridRightFormat(val){
	val = null == val ? "" : val;
   return '<span style="float:right;padding-right:10px;">' + val + '</span>';
}

/*********************** Ext列表样式定义结束 *****************************/

/*******************弹出div框的拖拽效果 START********************/
function easyDragEffect_(){
	 //给所有页面的新建、修改弹出窗口增加拖拽效果
	 if($("#tc_div_add").length>0){
		 divDrag_("tc_div_add","tcdiv_tit","tcdiv_list");
	 };
	  if($("#tc_div_modify").length>0){
		 divDrag_("tc_div_modify","tcdiv_tit","tcdiv_list");
	 };
}
function divDrag_(od_id,od_title_id,od_content_id){
	
	//移动体
	var od = document.getElementById(od_id);
	//可拖拽域
	//var od_title = document.getElementById(od_title_id);
	var od_title = $(od).children("div[id="+od_title_id+"]").get(0);
	//拖拽时隐藏域
	//var od_content = document.getElementById(od_content_id);
	var od_content = $(od).children("div[id="+od_content_id+"]").get(0);
	if(!od || !od_title || !od_content){
		return false;
	}
	//移动体的初始左、上间距
	var odLeft = 300;
	var odTop = 50;   //注意这个值要跟style.css中的tc_div和tc_divtm两个定义保持同步修改。
	//原鼠标x值、y值、是否为鼠标按左键事件
	var mx , my , mouseD;
	var odrag;
	var isIE = document.all ? true : false;
	//在移动体下增加iframe遮罩层，用于遮盖select元素
	$(od).bgiframe();
	//样式定义
	var ordClass = "tc_div";
	var transClass = "tc_divtm";
	
	$(od_title).bind("mousedown", function(e){
		odrag = this;
		var e = e ? e : event;
		if(e.button == (document.all ? 1 : 0))
		{
			mouseD = true;			
			mx = e.clientX;
			my = e.clientY;
			od.style.left = od.offsetLeft +odLeft + "px";
			od.style.top = od.offsetTop - odTop + "px";
			if(isIE)
			{
				od.setCapture();
			}
			else
			{
				window.captureEvents(event.mousemove);
			}
		} 
	});
	
	$(document).bind("mousemove", function(e){
  		if(mouseD==true && odrag && od.style.display != 'none')
		{
			//移动体增加透明样式，并将内容区隐藏
			$(od).removeClass(ordClass);
			$(od).addClass(transClass);	
			od_content.style.visibility ="hidden";
			//计算移动距离，并重新设置定位
			var mrx = e.clientX - mx;
			var mry = e.clientY - my;	
			od.style.left = parseInt(od.style.left) +mrx + "px";
			od.style.top = parseInt(od.style.top) + mry + "px";
			mx = e.clientX;
			my = e.clientY;		
		}
	}); 
	
	$(document).bind("mouseup", function(e){
		if(mouseD){
	  		mouseD = false;
			odrag = "";
			//去除移动体的透明样式，并将内容区显示
			$(od).removeClass(transClass);
			$(od).addClass(ordClass);	
			od_content.style.visibility ="visible";
			if(isIE)
			{
				od.releaseCapture();
			}
			else
			{
				window.releaseEvents(od.mousemove);
			}	
		}
	}); 
}

/*******************弹出div框的拖拽效果 END********************/
//div显示时让其居中
$.fn.extend({
	centerShow:function(){
		this.css("left","50%");
		this.css("top","25%");
		return this.show();
	}
});
//-->
</script>
<div id="bodyDiv">	
	<div id="moduleDiv"><%-- 成功样式为messageDiv_ok;失败样式为messageDiv_error --%>
		<span id="messageInfo" class="messageDiv_content"></span>
	</div>
</div>
<div id="public_loading" style="color:#333333;display:none;position:absolute;width:300px;top:1%;left:50%;margin-left:-150px;text-align:center;padding:7px 0 0 0;font:bold 14px Arial, Helvetica, sans-serif;">
	<%-- modified by Wang Cheng 2011-2-15 [XB-137] begin --%>
	<span style="margin-top:-10px;display:inline-block;"><img src="<c:url value='/skins/style_1/images/loading4.gif' />" style=" margin-right:10px;"  /></span><span style="margin-top:-19px; display:inline-block;">正在处理，请稍候...</span>
	<%-- [XB-137] end --%>
</div>
<%
	/** 提供无框架页面返回时的消息显示 */
	String status = null;
	ActionMessages infos = (ActionMessages) request.getAttribute(Globals.MESSAGE_KEY);
	if(infos!=null && infos.size()>0){
		status = "success";
	}else{
		infos = (ActionMessages) request.getAttribute(Globals.ERROR_KEY);
		status = "error";
	}
	if(infos!=null && infos.size()>0){
		StringBuilder messages = new StringBuilder();
		Iterator items = infos.get();
		while(items.hasNext()){
			  ActionMessage report = (ActionMessage) items.next();
			  messages.append(TagUtils.getInstance().message(
	                     pageContext,
	                     null,
	                     Globals.LOCALE_KEY,
	                     report.getKey(),
	                     report.getValues()));
			  
		      if(items.hasNext()){
		    	  messages.append("; ");
		      }
		}
		if(messages.length()>0){
			out.println("<script type=\"text/javascript\">");
		    out.println("showMessage('"+messages.toString()+"','"+status+"');");
			out.println("</script>");
		}
	}
%>
<%@include  file="/jsp/include/validate.jsp"%>