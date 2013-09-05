package org.apache.jsp.jsp.article;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessages;
import java.util.Iterator;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.taglib.TagUtils;

public final class indexHeader_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(7);
    _jspx_dependants.add("/jsp/include/errorAndMsg.jsp");
    _jspx_dependants.add("/WEB-INF/tld/c.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/tld/security.tld");
    _jspx_dependants.add("/jsp/include/validate.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>标题</title>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t*{ margin: 0;\r\n");
      out.write("\tpadding: 0;}\r\n");
      out.write("\t</style> \r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f6(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f7(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f8(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f9(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f10(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_005furl_005f11(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f12(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f13(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("/*解决下拉树的文本框和下拉箭头对不齐的问题*/\r\n");
      out.write(".ext-ie6 .x-form-text, .ext-ie7 .x-form-text {\r\n");
      out.write("    margin:0px 0; /* ie bogus margin bug */\r\n");
      out.write("    height:18px; /* ie quirks */\r\n");
      out.write("    line-height:18px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("/**\r\n");
      out.write(" * 系统上下文，用于js文件中定义url\r\n");
      out.write(" * @type {String}\r\n");
      out.write(" */\r\n");
      out.write("var context = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\t//给页面所有的列表行加上onmouseover效果\r\n");
      out.write("\t$(\"tr.even_row\").hover(function(){\r\n");
      out.write("\t  \tthis.style.backgroundColor = \"#e4f2fb\";\r\n");
      out.write("\t  \t//$(this).addClass(\"top_border\");\r\n");
      out.write("\t },function(){\r\n");
      out.write("\t \tthis.style.backgroundColor = \"#ffffff\";\r\n");
      out.write("\t  \t//this.style=this.style+\"border-top:1px solid #ff0000\";\r\n");
      out.write("\t  //\t$(this).addClass(\"top_border\");\r\n");
      out.write("\t });\r\n");
      out.write("\t$(\"tr.even_row_gray\").hover(function(){\r\n");
      out.write("\t  \tthis.style.backgroundColor = \"#e4f2fb\";\r\n");
      out.write("\t },function(){\r\n");
      out.write("\t \t// modified by Wang Cheng 2011-2-15 [XB-137] begin\r\n");
      out.write("\t \tthis.style.backgroundColor = \"#F0EEEE\";\r\n");
      out.write("\t \t// [XB-137] end\r\n");
      out.write("\t });\r\n");
      out.write("\t //当页面的保存按钮被点击时，将其disable，防止重复提交\r\n");
      out.write(" \t $(\":button[value='保存']\").live(\"click\", function(){\r\n");
      out.write("\t \tsetBtnBrevityDisable_(this, 30000);\r\n");
      out.write("\t /*\twindow.setTimeout(function(){\r\n");
      out.write("\t\t \tif(document.all.moduleDiv.style.display=='none'){\r\n");
      out.write("\t\t\t \tshowLoadingTip();\r\n");
      out.write("\t\t \t}else{\r\n");
      out.write("\t\t \t\thideLoadingTip();\r\n");
      out.write("\t\t \t}\r\n");
      out.write("\t \t},300);*/\r\n");
      out.write("\t });\r\n");
      out.write("\t //当页面的查询按钮被点击时，显示loading信息\r\n");
      out.write("\t $(\"input[type=button][value='查询'][isLoading!='no']\").click(function(){\r\n");
      out.write("\t \t\tsetBtnBrevityDisable_(this);\r\n");
      out.write("\t \t\twindow.setTimeout(function(){\r\n");
      out.write("\t\t\t \tif(document.all.moduleDiv.style.display=='none' || document.all.moduleDiv.style.display==''){\r\n");
      out.write("\t\t\t\t \tshowLoadingTip();\r\n");
      out.write("\t\t\t \t}else{\r\n");
      out.write("\t\t\t \t\thideLoadingTip();\r\n");
      out.write("\t\t\t \t}\r\n");
      out.write("\t\t \t},100);\r\n");
      out.write("\t });\r\n");
      out.write("\t //页面加载后将loading图标隐藏\r\n");
      out.write("\twindow.setTimeout(function(){ \r\n");
      out.write("\t\t\thideLoadingTip();\r\n");
      out.write("\t\t},200);\r\n");
      out.write("\t //给页面弹出div增加拖拽效果\r\n");
      out.write("\t easyDragEffect_();\r\n");
      out.write("\r\n");
      out.write("\t// modified by Wang Cheng 2011-2-15 [XB-137] begin\r\n");
      out.write(" \t// 鼠标经过改变按钮颜色\r\n");
      out.write("\t$(\".btn\").mouseover(function(){\r\n");
      out.write("\t\t$(this).addClass(\"btn_over\");\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\".btn\").mouseout(function(){\r\n");
      out.write("\t\t$(this).removeClass(\"btn_over\");\r\n");
      out.write("\t});\r\n");
      out.write("\t// 鼠标经过改变表格标题颜色\r\n");
      out.write("//\t\t$(\"#current_list_3 table thead td\").mouseover(function(){\r\n");
      out.write("//\t\t\t$(this).addClass(\"current_list_3_thead_td_over\");\r\n");
      out.write("//\t\t});\r\n");
      out.write("//\t\t$(\"#current_list_3 table thead td\").mouseout(function(){\r\n");
      out.write("//\t\t\t$(this).removeClass(\"current_list_3_thead_td_over\");\r\n");
      out.write("//\t\t});\r\n");
      out.write("\t// [XB-137] end\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("Ext.onReady(function(){\r\n");
      out.write("\tExt.BLANK_IMAGE_URL = context+\"/js/ext/resources/images/default/s.gif\";\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("/*******************防重复提交：按钮点击后失效********************/\r\n");
      out.write("function setBtnBrevityDisable_(bt , time){\r\n");
      out.write("\tif(time == undefined){\r\n");
      out.write("\t\ttime = 1000;\r\n");
      out.write("\t}\r\n");
      out.write("\tbt.disabled = true;\t\r\n");
      out.write("\t// modified by Wang Cheng 2011-2-15 [XB-137] begin\r\n");
      out.write("\t// 单击按钮时不能自动执行removeClass方法，这里需要在执行一次，不知为什么\r\n");
      out.write("\t$(bt).removeClass(\"btn_over\");\r\n");
      out.write("\t// [XB-137] end\r\n");
      out.write("\twindow.setTimeout(function(bu){bt.disabled = false},time);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//显示loading图标\r\n");
      out.write("function showLoadingTip(){\r\n");
      out.write("\tdocument.all.moduleDiv.style.display='none'; \r\n");
      out.write("\t$(\"#public_loading\").show();\r\n");
      out.write("}\r\n");
      out.write("//隐藏loading图标\r\n");
      out.write("function hideLoadingTip(){\r\n");
      out.write("\t$(document).find(\"#public_loading\").hide();\r\n");
      out.write("\t$(window.parent.document).find(\"#public_loading\").hide();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/***************屏蔽右键、后退键、F5*****************/\r\n");
      out.write("/*document.oncontextmenu = function(){\r\n");
      out.write("\twindow.event.returnValue=false;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("document.onkeydown = function(){   \r\n");
      out.write("\t\t //屏蔽退格删除键     \r\n");
      out.write("   if (((event.keyCode == 8) && (event.srcElement.type != \"text\" && event.srcElement.type != \"textarea\" && event.srcElement.type != \"password\")) \r\n");
      out.write("\t\t||  //屏蔽 F5 刷新键    \r\n");
      out.write("      (event.keyCode==116)\r\n");
      out.write("      ||  //Ctrl + R          \r\n");
      out.write("      (event.ctrlKey && event.keyCode==82)){ \r\n");
      out.write("     event.keyCode=0;    \r\n");
      out.write("     event.returnValue=false;    \r\n");
      out.write("   }    \r\n");
      out.write("} */\r\n");
      out.write("/*\r\n");
      out.write(" *frame框架页面在头部frame显示消息时需要调用此函数\r\n");
      out.write(" *messageObj： 封装了作物消息 arrayList 和  错误状态 state\r\n");
      out.write(" */\r\n");
      out.write("function showFrameTip(messageObj){\r\n");
      out.write("\tif(messageObj != undefined && messageObj != null){\r\n");
      out.write("\t\tvar message = '';\r\n");
      out.write("\t\twith(messageObj){\r\n");
      out.write("\t\t\tfor(var ms=0;ms<infos.length;ms++){\r\n");
      out.write("\t\t\t\tmessage += infos[ms]+\"  \"; \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tshowMessage(message,state);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\talert('系统消息提示功能异常!');\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function closeDiv(){\r\n");
      out.write("\tvar infoDiv = document.getElementById(\"moduleDiv\");\r\n");
      out.write("\tinfoDiv.style.display = \"none\";\r\n");
      out.write("\tdocument.all.messageInfo.innerHTML=\"\";\r\n");
      out.write("}\r\n");
      out.write("/*\r\n");
      out.write(" *显示 返回的提示信息\r\n");
      out.write(" *ajax提交，自动解析传递过来的信息，在页面上进行展示\r\n");
      out.write(" */\r\n");
      out.write("function showJsonMessage(tips){\r\n");
      out.write("\tif(!tips){\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tshowMessage(tips.info, tips.state);\r\n");
      out.write("\treturn showMessageState(tips.state);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function showMessageState(state){\r\n");
      out.write("\tif(state && (state=='warn' || state==\"error\")){\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("/*\r\n");
      out.write(" *显示 返回的提示信息\r\n");
      out.write(" *info:提示字符串，自己注意控制换行\r\n");
      out.write(" *state：信息提示类型， success 成功，error 失败\r\n");
      out.write(" */\r\n");
      out.write("function showMessage(info,state){\r\n");
      out.write("\tcloseDiv();\r\n");
      out.write("\tif(!info||!state){\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t//如果是iframe列表结构的页面，提示信息需要显示在父级页面上\r\n");
      out.write("\tif(parent && parent!=window && parent.showMessage){\r\n");
      out.write("\t\tparent.showMessage(info,state);\r\n");
      out.write("\t\t// 恢复保存按钮\r\n");
      out.write("\t\tenableSaveBtn();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t//进行消息提示前将loading图标隐藏，避免显示冲突\r\n");
      out.write("\thideLoadingTip();\r\n");
      out.write("\tclearTimeout(timer);\r\n");
      out.write("\tdocument.all.messageInfo.innerHTML = info;\r\n");
      out.write("\tmodifyInfo(state);\r\n");
      out.write("\t// 恢复保存按钮\r\n");
      out.write("\tenableSaveBtn();\r\n");
      out.write("}\r\n");
      out.write("var timer ;\r\n");
      out.write("function modifyInfo(state){\r\n");
      out.write("\t//设置ｄｉｖ提示样式和信息\r\n");
      out.write("\tswitch(state){\r\n");
      out.write("\t\tcase 'error' :\r\n");
      out.write("\t\t\tdocument.all.moduleDiv.className='messageDiv_error';\r\n");
      out.write("\t\t\tbreak;\r\n");
      out.write("\t\tcase 'success' :\r\n");
      out.write("\t\t\tdocument.all.moduleDiv.className='messageDiv_ok';\r\n");
      out.write("\t\t\tbreak;\r\n");
      out.write("\t\tcase 'warn' :\r\n");
      out.write("\t\t\tdocument.all.moduleDiv.className='messageDiv_warn';\r\n");
      out.write("\t\t\tbreak;\r\n");
      out.write("\t\tdefault :\r\n");
      out.write("\t\t\talert('消息提示参数设置类型错误！')\r\n");
      out.write("\t}\r\n");
      out.write("\tdocument.all.moduleDiv.style.display='block'; \r\n");
      out.write("\ttimer = window.setTimeout(\"closeDiv()\",8000); \r\n");
      out.write("\t//document.all.moduleDiv.focus();//added to get focus\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/**\r\n");
      out.write(" * 恢复保存按钮（支持普通按钮、Ext按钮）\r\n");
      out.write(" */\r\n");
      out.write("function enableSaveBtn(){\r\n");
      out.write("\tsetTimeout(function(){\r\n");
      out.write("\t\t$(\":button[value='保存']\").attr(\"disabled\", false);\r\n");
      out.write("\t}, 3000);\r\n");
      out.write("}\r\n");
      out.write("/**\r\n");
      out.write(" * 将光标绑定到指定的按钮上\r\n");
      out.write(" */\r\n");
      out.write("function focusBindBtn(btnId){\r\n");
      out.write("       $(\"#\"+btnId).focus()\r\n");
      out.write("}\r\n");
      out.write("/*********************** Ext列宽度定义开始 ****************************/\r\n");
      out.write("/**\r\n");
      out.write(" * 超短，适用于：收费相关字段（如优惠金额、实收采暖费等等）\r\n");
      out.write(" */\r\n");
      out.write("var small_ = 68;\r\n");
      out.write("/**\r\n");
      out.write(" * 短，适用于：客户卡号、楼、单元、室、客户类型、电话、日期等\r\n");
      out.write(" */\r\n");
      out.write("var short_ = 95;\r\n");
      out.write("\r\n");
      out.write("/**\r\n");
      out.write(" * 中，适用于：供热站、客户名称、小区、时间等\r\n");
      out.write(" */\r\n");
      out.write("var middle_ = 125;\r\n");
      out.write("\r\n");
      out.write("/**\r\n");
      out.write(" * 长，适用于：地址（小区 + 楼 + 单元 + 室）等\r\n");
      out.write(" */\r\n");
      out.write("var long_ = 230;\r\n");
      out.write("\r\n");
      out.write("/**\r\n");
      out.write(" * 超长，适用于：\r\n");
      out.write(" */\r\n");
      out.write("var super_long_ = 400;\r\n");
      out.write("\r\n");
      out.write("/*********************** Ext列宽度定义结束 ****************************/\r\n");
      out.write("\r\n");
      out.write("/*********************** Ext列表样式定义开始 *******************************/\r\n");
      out.write("/**\r\n");
      out.write(" * column内容居右\r\n");
      out.write(" * @param {Float} 需要处理的json数值\r\n");
      out.write(" */\r\n");
      out.write("function gridRightFormat(val){\r\n");
      out.write("\tval = null == val ? \"\" : val;\r\n");
      out.write("   return '<span style=\"float:right;padding-right:10px;\">' + val + '</span>';\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*********************** Ext列表样式定义结束 *****************************/\r\n");
      out.write("\r\n");
      out.write("/*******************弹出div框的拖拽效果 START********************/\r\n");
      out.write("function easyDragEffect_(){\r\n");
      out.write("\t //给所有页面的新建、修改弹出窗口增加拖拽效果\r\n");
      out.write("\t if($(\"#tc_div_add\").length>0){\r\n");
      out.write("\t\t divDrag_(\"tc_div_add\",\"tcdiv_tit\",\"tcdiv_list\");\r\n");
      out.write("\t };\r\n");
      out.write("\t  if($(\"#tc_div_modify\").length>0){\r\n");
      out.write("\t\t divDrag_(\"tc_div_modify\",\"tcdiv_tit\",\"tcdiv_list\");\r\n");
      out.write("\t };\r\n");
      out.write("}\r\n");
      out.write("function divDrag_(od_id,od_title_id,od_content_id){\r\n");
      out.write("\t\r\n");
      out.write("\t//移动体\r\n");
      out.write("\tvar od = document.getElementById(od_id);\r\n");
      out.write("\t//可拖拽域\r\n");
      out.write("\t//var od_title = document.getElementById(od_title_id);\r\n");
      out.write("\tvar od_title = $(od).children(\"div[id=\"+od_title_id+\"]\").get(0);\r\n");
      out.write("\t//拖拽时隐藏域\r\n");
      out.write("\t//var od_content = document.getElementById(od_content_id);\r\n");
      out.write("\tvar od_content = $(od).children(\"div[id=\"+od_content_id+\"]\").get(0);\r\n");
      out.write("\tif(!od || !od_title || !od_content){\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t//移动体的初始左、上间距\r\n");
      out.write("\tvar odLeft = 300;\r\n");
      out.write("\tvar odTop = 50;   //注意这个值要跟style.css中的tc_div和tc_divtm两个定义保持同步修改。\r\n");
      out.write("\t//原鼠标x值、y值、是否为鼠标按左键事件\r\n");
      out.write("\tvar mx , my , mouseD;\r\n");
      out.write("\tvar odrag;\r\n");
      out.write("\tvar isIE = document.all ? true : false;\r\n");
      out.write("\t//在移动体下增加iframe遮罩层，用于遮盖select元素\r\n");
      out.write("\t$(od).bgiframe();\r\n");
      out.write("\t//样式定义\r\n");
      out.write("\tvar ordClass = \"tc_div\";\r\n");
      out.write("\tvar transClass = \"tc_divtm\";\r\n");
      out.write("\t\r\n");
      out.write("\t$(od_title).bind(\"mousedown\", function(e){\r\n");
      out.write("\t\todrag = this;\r\n");
      out.write("\t\tvar e = e ? e : event;\r\n");
      out.write("\t\tif(e.button == (document.all ? 1 : 0))\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tmouseD = true;\t\t\t\r\n");
      out.write("\t\t\tmx = e.clientX;\r\n");
      out.write("\t\t\tmy = e.clientY;\r\n");
      out.write("\t\t\tod.style.left = od.offsetLeft +odLeft + \"px\";\r\n");
      out.write("\t\t\tod.style.top = od.offsetTop - odTop + \"px\";\r\n");
      out.write("\t\t\tif(isIE)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tod.setCapture();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\twindow.captureEvents(event.mousemove);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t} \r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).bind(\"mousemove\", function(e){\r\n");
      out.write("  \t\tif(mouseD==true && odrag && od.style.display != 'none')\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t//移动体增加透明样式，并将内容区隐藏\r\n");
      out.write("\t\t\t$(od).removeClass(ordClass);\r\n");
      out.write("\t\t\t$(od).addClass(transClass);\t\r\n");
      out.write("\t\t\tod_content.style.visibility =\"hidden\";\r\n");
      out.write("\t\t\t//计算移动距离，并重新设置定位\r\n");
      out.write("\t\t\tvar mrx = e.clientX - mx;\r\n");
      out.write("\t\t\tvar mry = e.clientY - my;\t\r\n");
      out.write("\t\t\tod.style.left = parseInt(od.style.left) +mrx + \"px\";\r\n");
      out.write("\t\t\tod.style.top = parseInt(od.style.top) + mry + \"px\";\r\n");
      out.write("\t\t\tmx = e.clientX;\r\n");
      out.write("\t\t\tmy = e.clientY;\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}); \r\n");
      out.write("\t\r\n");
      out.write("\t$(document).bind(\"mouseup\", function(e){\r\n");
      out.write("\t\tif(mouseD){\r\n");
      out.write("\t  \t\tmouseD = false;\r\n");
      out.write("\t\t\todrag = \"\";\r\n");
      out.write("\t\t\t//去除移动体的透明样式，并将内容区显示\r\n");
      out.write("\t\t\t$(od).removeClass(transClass);\r\n");
      out.write("\t\t\t$(od).addClass(ordClass);\t\r\n");
      out.write("\t\t\tod_content.style.visibility =\"visible\";\r\n");
      out.write("\t\t\tif(isIE)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tod.releaseCapture();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\twindow.releaseEvents(od.mousemove);\r\n");
      out.write("\t\t\t}\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}); \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*******************弹出div框的拖拽效果 END********************/\r\n");
      out.write("//div显示时让其居中\r\n");
      out.write("$.fn.extend({\r\n");
      out.write("\tcenterShow:function(){\r\n");
      out.write("\t\tthis.css(\"left\",\"50%\");\r\n");
      out.write("\t\tthis.css(\"top\",\"25%\");\r\n");
      out.write("\t\treturn this.show();\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("<div id=\"bodyDiv\">\t\r\n");
      out.write("\t<div id=\"moduleDiv\">");
      out.write("\r\n");
      out.write("\t\t<span id=\"messageInfo\" class=\"messageDiv_content\"></span>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"public_loading\" style=\"color:#333333;display:none;position:absolute;width:300px;top:1%;left:50%;margin-left:-150px;text-align:center;padding:7px 0 0 0;font:bold 14px Arial, Helvetica, sans-serif;\">\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<span style=\"margin-top:-10px;display:inline-block;\"><img src=\"");
      if (_jspx_meth_c_005furl_005f14(_jspx_page_context))
        return;
      out.write("\" style=\" margin-right:10px;\"  /></span><span style=\"margin-top:-19px; display:inline-block;\">正在处理，请稍候...</span>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("</div>\r\n");

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

      out.write('\r');
      out.write('\n');
      out.write(" \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\t//validate_();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("//对所有class里包含有money的input元素进行数字校验，样式格式为validate_x-y  ,x为数字最大总长度，y为小数位最大总长度\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("/************************校验提示*************************************/\r\n");
      out.write("//校验通过\r\n");
      out.write("function success_(obj){\r\n");
      out.write("\t//obj.css('backgroundColor','');\r\n");
      out.write("\treturn true;\r\n");
      out.write("};\r\n");
      out.write("//校验失败\r\n");
      out.write("function fail_(msg,obj){\r\n");
      out.write("\tshowMessage(msg,\"warn\");\r\n");
      out.write("\t//obj.css('backgroundColor',\"#BBBBBB\");\r\n");
      out.write("\tobj.val(0).change();\r\n");
      out.write("\treturn false;\r\n");
      out.write("};\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../../skins/style_1/css/articleManagement.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body id=\"content\"> \r\n");
      out.write("<!-- 引入头部 --> \r\n");
      out.write("      <div  >\r\n");
      out.write("\t       <iframe width=\"1366px\" height=\"60px\" scrolling=\"no\" frameborder=\"0\" src=\"");
      if (_jspx_meth_c_005furl_005f15(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("\t       </iframe>\r\n");
      out.write("\t   </div>\r\n");
      out.write("<div style=\"diaplay:none\">\r\n");
      out.write("<div id=\"top\"> \r\n");
      out.write("<table width=\"1366\" border=\"0\" style=\"margin-top:10px\">\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</table> \r\n");
      out.write("</div>  \r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f24(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write(" </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /jsp/include/errorAndMsg.jsp(13,45) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/skins/style_1/css/style.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /jsp/include/errorAndMsg.jsp(14,45) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/skins/style_1/css/tree.css");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /jsp/include/errorAndMsg.jsp(15,45) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/js/ext/resources/css/ext-all.css");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /jsp/include/errorAndMsg.jsp(16,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/js/base/base.js");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent(null);
    // /jsp/include/errorAndMsg.jsp(17,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/js/jquery/jquery.js");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f5.setParent(null);
    // /jsp/include/errorAndMsg.jsp(18,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/js/jquery/plugins/jquery.form.js");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f6 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f6.setParent(null);
    // /jsp/include/errorAndMsg.jsp(19,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f6.setValue("/js/jquery/plugins/jquery.hotkeys.js");
    int _jspx_eval_c_005furl_005f6 = _jspx_th_c_005furl_005f6.doStartTag();
    if (_jspx_th_c_005furl_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f7 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f7.setParent(null);
    // /jsp/include/errorAndMsg.jsp(20,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f7.setValue("/js/ext/ext-base.js");
    int _jspx_eval_c_005furl_005f7 = _jspx_th_c_005furl_005f7.doStartTag();
    if (_jspx_th_c_005furl_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f8 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f8.setParent(null);
    // /jsp/include/errorAndMsg.jsp(21,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f8.setValue("/js/ext/ext-all.js");
    int _jspx_eval_c_005furl_005f8 = _jspx_th_c_005furl_005f8.doStartTag();
    if (_jspx_th_c_005furl_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f9 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f9.setParent(null);
    // /jsp/include/errorAndMsg.jsp(22,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f9.setValue("/js/ext/ext-lang-zh_CN.js");
    int _jspx_eval_c_005furl_005f9 = _jspx_th_c_005furl_005f9.doStartTag();
    if (_jspx_th_c_005furl_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f10 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f10.setParent(null);
    // /jsp/include/errorAndMsg.jsp(23,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f10.setValue("/js/ext/zoomkey/GridPanel.js");
    int _jspx_eval_c_005furl_005f10 = _jspx_th_c_005furl_005f10.doStartTag();
    if (_jspx_th_c_005furl_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f10);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f11 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f11.setParent(null);
    // /jsp/include/errorAndMsg.jsp(24,45) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f11.setValue("/js/ext/resources/css/ext-font-patch.css");
    int _jspx_eval_c_005furl_005f11 = _jspx_th_c_005furl_005f11.doStartTag();
    if (_jspx_th_c_005furl_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f11);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f12 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f12.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f12.setParent(null);
    // /jsp/include/errorAndMsg.jsp(25,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f12.setValue("/js/jquery/plugins/jquery.bgiframe.min.js");
    int _jspx_eval_c_005furl_005f12 = _jspx_th_c_005furl_005f12.doStartTag();
    if (_jspx_th_c_005furl_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f12);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f13 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f13.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f13.setParent(null);
    // /jsp/include/errorAndMsg.jsp(26,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f13.setValue("/js/common/validator.js");
    int _jspx_eval_c_005furl_005f13 = _jspx_th_c_005furl_005f13.doStartTag();
    if (_jspx_th_c_005furl_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f13);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f14(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f14 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f14.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f14.setParent(null);
    // /jsp/include/errorAndMsg.jsp(404,64) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f14.setValue("/skins/style_1/images/loading4.gif");
    int _jspx_eval_c_005furl_005f14 = _jspx_th_c_005furl_005f14.doStartTag();
    if (_jspx_th_c_005furl_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f14);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f15(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f15 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f15.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f15.setParent(null);
    // /jsp/article/indexHeader.jsp(28,81) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f15.setValue("/jsp/common/header.jsp");
    int _jspx_eval_c_005furl_005f15 = _jspx_th_c_005furl_005f15.doStartTag();
    if (_jspx_th_c_005furl_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f15);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /jsp/article/indexHeader.jsp(34,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user==null }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<tr>\r\n");
        out.write("\t\t\t<td><a href=\"../../jsp/user/login.jsp\" target=\"_top\"\r\n");
        out.write("\t\t\t\tstyle=\"padding-left: 50px; font-size: 16px;\"><em><strong>请登录</strong></em></a>\r\n");
        out.write("\t\t\t</td>\r\n");
        out.write("\t\t</tr>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /jsp/article/indexHeader.jsp(41,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user!=null }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<tr> \r\n");
        out.write("\t\t<!-- 版主登录显示的内容 -->\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_c_005fif_005f2(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write(" \r\n");
        out.write("\t\t\t<!-- 管理员登录显示的内容 -->\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_c_005fif_005f3(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write(" \r\n");
        out.write("\t\t\t<!-- 管理员登录显示的内容 -->\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_c_005fif_005f4(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write(" \r\n");
        out.write("\t\t\t\r\n");
        out.write("\t\t</tr>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /jsp/article/indexHeader.jsp(44,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role==1 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<td align=\"left\" width=\"260px\">&nbsp; 欢迎 <a href=\"");
        if (_jspx_meth_c_005furl_005f16(_jspx_th_c_005fif_005f2, _jspx_page_context))
          return true;
        out.write("\" target=\"_top\">《");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.name\r\n}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("》</a> <a href=\"");
        if (_jspx_meth_c_005furl_005f17(_jspx_th_c_005fif_005f2, _jspx_page_context))
          return true;
        out.write("\"\ttarget=\"_top\">[退出]</a></td>\r\n");
        out.write("\t\t\t\t<td align=\"left\" width=\"240px\">您当前积分为[");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.credits}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("]分</td>\r\n");
        out.write("\t\t\t\t<td align=\"left\"><strong><em>&nbsp; <a\thref=\"");
        if (_jspx_meth_c_005furl_005f18(_jspx_th_c_005fif_005f2, _jspx_page_context))
          return true;
        out.write("\" target=\"_top\">\t版主入口>>>></a></em></strong></td>\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f16(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f16 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f16.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f2);
    // /jsp/article/indexHeader.jsp(45,54) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f16.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("/user/goToUserCenter.ao?method=toUserCenter&userId=${sessionScope.user.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005furl_005f16 = _jspx_th_c_005furl_005f16.doStartTag();
    if (_jspx_th_c_005furl_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f16);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f16);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f17(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f17 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f17.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f2);
    // /jsp/article/indexHeader.jsp(46,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f17.setValue("/user/logout.ao?method=logOut");
    int _jspx_eval_c_005furl_005f17 = _jspx_th_c_005furl_005f17.doStartTag();
    if (_jspx_th_c_005furl_005f17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f17);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f17);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f18(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f18 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f18.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f2);
    // /jsp/article/indexHeader.jsp(48,49) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f18.setValue("/jsp/manager/Menu.jsp");
    int _jspx_eval_c_005furl_005f18 = _jspx_th_c_005furl_005f18.doStartTag();
    if (_jspx_th_c_005furl_005f18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f18);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f18);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /jsp/article/indexHeader.jsp(51,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role==2 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<td align=\"left\" width=\"260px\">&nbsp; 欢迎 <a\thref=\"");
        if (_jspx_meth_c_005furl_005f19(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\" target=\"_top\">《");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.name\r\n				}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("》</a> <a href=\"");
        if (_jspx_meth_c_005furl_005f20(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\"\ttarget=\"_top\">[退出]</a></td>\r\n");
        out.write("\t\t\t\t<td align=\"left\" width=\"240px\">&nbsp;您当前积分为<<");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.credits	}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">>分</td>\r\n");
        out.write("\t\t\t\t<td  align=\"left\">&nbsp; <a href=\"");
        if (_jspx_meth_c_005furl_005f21(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\" target=\"_top\">管理员入口>>>></a></td>\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f19(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f19 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f19.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /jsp/article/indexHeader.jsp(52,54) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f19.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("/user/goToUserCenter.ao?method=toUserCenter&userId=${sessionScope.user.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005furl_005f19 = _jspx_th_c_005furl_005f19.doStartTag();
    if (_jspx_th_c_005furl_005f19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f19);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f19);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f20(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f20 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f20.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /jsp/article/indexHeader.jsp(53,20) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f20.setValue("/user/logout.ao?method=logOut");
    int _jspx_eval_c_005furl_005f20 = _jspx_th_c_005furl_005f20.doStartTag();
    if (_jspx_th_c_005furl_005f20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f20);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f20);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f21(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f21 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f21.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /jsp/article/indexHeader.jsp(55,38) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f21.setValue("/jsp/manager/Menu.jsp");
    int _jspx_eval_c_005furl_005f21 = _jspx_th_c_005furl_005f21.doStartTag();
    if (_jspx_th_c_005furl_005f21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f21);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f21);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /jsp/article/indexHeader.jsp(58,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role==0 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
    if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<td align=\"left\" width=\"260px\">&nbsp; 欢迎 <a\thref=\"");
        if (_jspx_meth_c_005furl_005f22(_jspx_th_c_005fif_005f4, _jspx_page_context))
          return true;
        out.write("\" target=\"_top\">《");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.name\r\n				}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("》</a> <a href=\"");
        if (_jspx_meth_c_005furl_005f23(_jspx_th_c_005fif_005f4, _jspx_page_context))
          return true;
        out.write("\"\ttarget=\"_top\">[退出]</a></td>\r\n");
        out.write("\t\t\t\t<td align=\"left\" width=\"240px\">&nbsp;您当前积分为<<");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.credits	}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(">>分</td>\r\n");
        out.write("\t\t\t\t<td  align=\"left\">&nbsp;  </td>\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f22(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f22 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f22.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f4);
    // /jsp/article/indexHeader.jsp(59,54) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f22.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("/user/goToUserCenter.ao?method=toUserCenter&userId=${sessionScope.user.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005furl_005f22 = _jspx_th_c_005furl_005f22.doStartTag();
    if (_jspx_th_c_005furl_005f22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f22);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f22);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f23(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f23 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f23.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f4);
    // /jsp/article/indexHeader.jsp(60,20) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f23.setValue("/user/logout.ao?method=logOut");
    int _jspx_eval_c_005furl_005f23 = _jspx_th_c_005furl_005f23.doStartTag();
    if (_jspx_th_c_005furl_005f23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f23);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f23);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f24(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f24 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f24.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f24.setParent(null);
    // /jsp/article/indexHeader.jsp(70,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f24.setValue("/jsp/article/indexHeader.js");
    int _jspx_eval_c_005furl_005f24 = _jspx_th_c_005furl_005f24.doStartTag();
    if (_jspx_th_c_005furl_005f24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f24);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f24);
    return false;
  }
}
