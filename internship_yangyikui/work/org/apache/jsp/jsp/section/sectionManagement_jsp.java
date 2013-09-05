package org.apache.jsp.jsp.section;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessages;
import java.util.Iterator;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.taglib.TagUtils;

public final class sectionManagement_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(7);
    _jspx_dependants.add("/WEB-INF/tld/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/tld/struts-logic.tld");
    _jspx_dependants.add("/WEB-INF/tld/c.tld");
    _jspx_dependants.add("/WEB-INF/tld/security.tld");
    _jspx_dependants.add("/jsp/include/errorAndMsg.jsp");
    _jspx_dependants.add("/jsp/include/validate.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fform_0026_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fmethod_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fvalue_005fstyleId_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005ftextarea_0026_005fstyleId_005fstyle_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fselect_0026_005fstyleId_005fstyle_005fsize_005fproperty;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005foption_0026_005fvalue;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005foptionsCollection_0026_005fvalue_005fproperty_005fname_005flabel_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtml_005freset_0026_005fvalue_005fstyleClass_005fonclick_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fhtml_005fform_0026_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fmethod_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fvalue_005fstyleId_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005ftextarea_0026_005fstyleId_005fstyle_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fselect_0026_005fstyleId_005fstyle_005fsize_005fproperty = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005foption_0026_005fvalue = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005foptionsCollection_0026_005fvalue_005fproperty_005fname_005flabel_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtml_005freset_0026_005fvalue_005fstyleClass_005fonclick_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fhtml_005fform_0026_005faction.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fmethod_005faction.release();
    _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fvalue_005fstyleId_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005ftextarea_0026_005fstyleId_005fstyle_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fselect_0026_005fstyleId_005fstyle_005fsize_005fproperty.release();
    _005fjspx_005ftagPool_005fhtml_005foption_0026_005fvalue.release();
    _005fjspx_005ftagPool_005fhtml_005foptionsCollection_0026_005fvalue_005fproperty_005fname_005flabel_005fnobody.release();
    _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.release();
    _005fjspx_005ftagPool_005fhtml_005freset_0026_005fvalue_005fstyleClass_005fonclick_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>版块管理</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../skins/style_1/css/sectionManagement.css\">\t  \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var context = \"");
      out.print(request.getContextPath());
      out.write("\";\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body id=\"content\">  \r\n");
      out.write(" \r\n");
      out.write("  <!-- 查询 -->\r\n");
      out.write("  <div style=\"display:none\">\r\n");
      out.write("    \t<div id=\"top\">\r\n");
      out.write("    \t");
      if (_jspx_meth_html_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("   \t</div>  \r\n");
      out.write("   \t</div>\r\n");
      out.write("  <!-- 新建版块开始-->\r\n");
      out.write(" \t<div  style=\"display:none\">\r\n");
      out.write("        <div id=\"createSectionWindow\" style=\"margin-left:50px; margin-top:20px\" > \r\n");
      out.write("        ");
      if (_jspx_meth_html_005fform_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("       <!-- 新建版块结束 -->\r\n");
      out.write("       \r\n");
      out.write("       <!-- 修改版块开始 -->\r\n");
      out.write("       \r\n");
      out.write("   <div style=\"display:none\">\r\n");
      out.write("     <div id=\"updateSectionWindow\" style=\"margin-left:5px; margin-top:20px\" > \r\n");
      out.write("        ");
      if (_jspx_meth_html_005fform_005f2(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("        </div>\r\n");
      out.write("        </div> \r\n");
      out.write("       \r\n");
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
      out.write(" \r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f15(_jspx_page_context))
        return;
      out.write("\"></script>\t\r\n");
      out.write(" \r\n");
      out.write("<script language=\"JavaScript\"> \r\n");
      out.write("\t\t\t\t\t//新建验证 \r\n");
      out.write("\t\t\t\t\tvar validateArray = [\r\n");
      out.write("\t\t\t\t\t                     {name:'tSection.sectionName',require:true, msg: \"版块名名不能为空\",event:'onblur'},\r\n");
      out.write("\t\t\t\t\t                     {name:'tSection.sectionIntro',require:true, msg: \"版块简介不能为空\",event:'onblur'} \r\n");
      out.write("\t\t\t\t\t                     ];\r\n");
      out.write("\t\t\t\t\tinjectCommonValidator(\"createSectionForm\",validateArray);\r\n");
      out.write("\t\t\t\t\t//修改版块验证\r\n");
      out.write("\t\t\t\t\tvar validateArray = [\r\n");
      out.write("\t\t\t\t\t                     {name:'tSection.sectionName',require:true, msg: \"版块名名不能为空\",event:'onblur'},\r\n");
      out.write("\t\t\t\t\t                     {name:'tSection.visitCredits',require:true, msg: \"访问积分不能为空\",event:'onblur'} \r\n");
      out.write("\t\t\t\t\t                     ];\r\n");
      out.write("\t\t\t\t\tinjectCommonValidator(\"updateSectionForm\",validateArray);  \r\n");
      out.write("</script>      \r\n");
      out.write("  <script type=\"text/javascript\"> \r\n");
      out.write("  $(document).ready(function(){ \r\n");
      out.write("\t\t $(\"input[id=auditing][value=1]\").attr(\"checked\",true);//设置radio的默认值  \r\n");
      out.write("\t});\r\n");
      out.write("  </script>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_html_005fform_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:form
    org.apache.struts.taglib.html.FormTag _jspx_th_html_005fform_005f0 = (org.apache.struts.taglib.html.FormTag) _005fjspx_005ftagPool_005fhtml_005fform_0026_005faction.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_html_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fform_005f0.setParent(null);
    // /jsp/section/sectionManagement.jsp(27,5) name = action type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fform_005f0.setAction("/section/querySectionInfo.ao?method=getSecInfo");
    int _jspx_eval_html_005fform_005f0 = _jspx_th_html_005fform_005f0.doStartTag();
    if (_jspx_eval_html_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("    \t  <table width=\"1141\"  align=\"left\">\r\n");
        out.write("    \t    <tr>\r\n");
        out.write("    \t     ");
        if (_jspx_meth_c_005fif_005f0(_jspx_th_html_005fform_005f0, _jspx_page_context))
          return true;
        out.write("  \r\n");
        out.write("  \t      </tr>\r\n");
        out.write("  \t    </table>\r\n");
        out.write("  \t    ");
        int evalDoAfterBody = _jspx_th_html_005fform_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_html_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fform_0026_005faction.reuse(_jspx_th_html_005fform_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fform_0026_005faction.reuse(_jspx_th_html_005fform_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f0);
    // /jsp/section/sectionManagement.jsp(30,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role==2 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("    \t      <td width=\"77\" height=\"29\" align=\"right\">版块名称：</td>\r\n");
        out.write("    \t      <td width=\"155\" align=\"left\">&nbsp;");
        if (_jspx_meth_html_005ftext_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write("</td>\r\n");
        out.write("    \t      <td width=\"284\" align=\"left\">&nbsp;<input type=\"button\" value=\"查询\" id=\"seachbtn\" class=\"btn\"  onclick=\"querySectionInfo();\"   isLoading='no'  onkeypress=\"cursorSwitch_();\"></input> </td>\r\n");
        out.write("    \t      <td width=\"137\" align=\"center\">&nbsp; <input class=\"btn\" type=\"button\" value=\"新建版块\"  onClick=\"createSection();\"/></td>\r\n");
        out.write("    \t      <td width=\"103\" align=\"center\">&nbsp; <input class=\"btn\" type=\"button\" value=\"删除\"  onclick=\"deleteSection();\" /></td>\r\n");
        out.write("    \t      <td width=\"176\" align=\"center\">&nbsp; <input class=\"btn\" type=\"button\" value=\"修改\"  id=\"bcSection\" style=\"width:110\" onClick=\"updateSectionInfo();\"   /></td>\r\n");
        out.write("    \t    ");
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

  private boolean _jspx_meth_html_005ftext_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_005ftext_005f0 = (org.apache.struts.taglib.html.TextTag) _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_005ftext_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005ftext_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /jsp/section/sectionManagement.jsp(32,46) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f0.setProperty("attribute(sectionName)");
    // /jsp/section/sectionManagement.jsp(32,46) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f0.setStyleId("name");
    // /jsp/section/sectionManagement.jsp(32,46) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f0.setStyle("width:142px");
    int _jspx_eval_html_005ftext_005f0 = _jspx_th_html_005ftext_005f0.doStartTag();
    if (_jspx_th_html_005ftext_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.reuse(_jspx_th_html_005ftext_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.reuse(_jspx_th_html_005ftext_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005fform_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:form
    org.apache.struts.taglib.html.FormTag _jspx_th_html_005fform_005f1 = (org.apache.struts.taglib.html.FormTag) _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fmethod_005faction.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_html_005fform_005f1.setPageContext(_jspx_page_context);
    _jspx_th_html_005fform_005f1.setParent(null);
    // /jsp/section/sectionManagement.jsp(46,8) name = action type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fform_005f1.setAction("/section/createSection.ao?method=createSection");
    // /jsp/section/sectionManagement.jsp(46,8) name = method type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fform_005f1.setMethod("post");
    // /jsp/section/sectionManagement.jsp(46,8) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fform_005f1.setStyleId("createSectionForm");
    int _jspx_eval_html_005fform_005f1 = _jspx_th_html_005fform_005f1.doStartTag();
    if (_jspx_eval_html_005fform_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("         <fieldset class=\"expandFieldset collapsedFieldset\"  style=\"padding: 0px; margin-right: 35px;\">\r\n");
        out.write("         <legend class=\"areaSpan\"><span><label for=\"\" style=\"font-size:14px\">版块信息</label></span></legend>\r\n");
        out.write("\t\t\t\t<table align=\"center\" border=\"0\" width=\"480\">\r\n");
        out.write("\t\t\t\t<!-- 隐藏用户id -->\r\n");
        out.write("\t\t\t\t   <tr>\r\n");
        out.write("\t\t\t\t      <td  align=\"right\"></td>\r\n");
        out.write("\t\t\t         <td >");
        if (_jspx_meth_html_005fhidden_005f0(_jspx_th_html_005fform_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t          ");
        if (_jspx_meth_html_005fhidden_005f1(_jspx_th_html_005fform_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t        </td>\r\n");
        out.write("\t\t\t         <td ></td>\r\n");
        out.write("\t\t\t\t   </tr>\r\n");
        out.write("\t\t\t\t   <tr>\r\n");
        out.write("\t\t\t\t      <td width=\"131\" height=\"32\" align=\"right\">版块名称：</td>\r\n");
        out.write("\t\t\t         <td width=\"190\">");
        if (_jspx_meth_html_005ftext_005f1(_jspx_th_html_005fform_005f1, _jspx_page_context))
          return true;
        out.write("</td>\r\n");
        out.write("\t\t\t         <td width=\"129\"><span id=\"sname\" style=\"color:red\">*</span> </td>\r\n");
        out.write("\t\t\t\t   </tr>\r\n");
        out.write("\t\t\t\t   <tr>\r\n");
        out.write("\t\t\t\t      <td height=\"33\" align=\"right\">版块简介：</td>\r\n");
        out.write("\t\t\t         <td>");
        if (_jspx_meth_html_005ftextarea_005f0(_jspx_th_html_005fform_005f1, _jspx_page_context))
          return true;
        out.write("</td>\r\n");
        out.write("\t\t\t         <td><span id=\"spassword\" style=\"color:red\">*</span></td>\r\n");
        out.write("\t\t\t\t   </tr>\r\n");
        out.write("\t\t\t\t   <tr>\r\n");
        out.write("\t\t\t\t      <td height=\"33\" align=\"right\">版　　主：</td>\r\n");
        out.write("\t\t\t         <td>\r\n");
        out.write("\t\t\t          ");
        if (_jspx_meth_html_005fselect_005f0(_jspx_th_html_005fform_005f1, _jspx_page_context))
          return true;
        out.write(" \r\n");
        out.write("\t\t\t         </td>\r\n");
        out.write("\t\t\t         <td><span id=\"spwd\" style=\"color:red\">*</span></td>\r\n");
        out.write("\t\t\t\t   </tr>\r\n");
        out.write("\t\t\t\t   <tr>\r\n");
        out.write("\t\t\t\t      <td height=\"33\" align=\"right\">是否审核：</td>\r\n");
        out.write("\t\t\t\t      <td colspan=\"2\">\r\n");
        out.write("\t     \t         \t");
        if (_jspx_meth_html_005fradio_005f0(_jspx_th_html_005fform_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_html_005fradio_005f1(_jspx_th_html_005fform_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t      </td>\r\n");
        out.write("\t\t\t\t   </tr>\r\n");
        out.write("\t\t\t\t   <tr>　\r\n");
        out.write("\t\t\t\t      <td height=\"35\" align=\"right\">访问积分：</td>\r\n");
        out.write("\t\t\t\t      <td>\r\n");
        out.write("\t     \t\t    ");
        if (_jspx_meth_html_005ftext_005f2(_jspx_th_html_005fform_005f1, _jspx_page_context))
          return true;
        out.write(" </td>\r\n");
        out.write("\t\t\t\t      <td></td>\r\n");
        out.write("\t\t\t\t   </tr>\r\n");
        out.write("\t\t\t\t   <tr>\r\n");
        out.write("\t\t\t\t      <td height=\"37\" colspan=\"3\" align=\"center\"><input type=\"button\" id=\"btn\"  class=\"content_save\" value=\"保存\" onClick=\"createSectionInfo();\" ></input>");
        if (_jspx_meth_html_005freset_005f0(_jspx_th_html_005fform_005f1, _jspx_page_context))
          return true;
        out.write("</td>\r\n");
        out.write("\t\t\t\t   </tr>\r\n");
        out.write("\t\t\t</table>\r\n");
        out.write("\t\t\t\t</fieldset>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_html_005fform_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_html_005fform_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fmethod_005faction.reuse(_jspx_th_html_005fform_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fmethod_005faction.reuse(_jspx_th_html_005fform_005f1);
    return false;
  }

  private boolean _jspx_meth_html_005fhidden_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_005fhidden_005f0 = (org.apache.struts.taglib.html.HiddenTag) _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_005fhidden_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhidden_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f1);
    // /jsp/section/sectionManagement.jsp(53,17) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fhidden_005f0.setProperty("tSection.id");
    int _jspx_eval_html_005fhidden_005f0 = _jspx_th_html_005fhidden_005f0.doStartTag();
    if (_jspx_th_html_005fhidden_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005fhidden_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_005fhidden_005f1 = (org.apache.struts.taglib.html.HiddenTag) _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fvalue_005fstyleId_005fproperty_005fnobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_005fhidden_005f1.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhidden_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f1);
    // /jsp/section/sectionManagement.jsp(54,13) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fhidden_005f1.setProperty("attribute(id)");
    // /jsp/section/sectionManagement.jsp(54,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fhidden_005f1.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    // /jsp/section/sectionManagement.jsp(54,13) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fhidden_005f1.setStyleId("userId");
    int _jspx_eval_html_005fhidden_005f1 = _jspx_th_html_005fhidden_005f1.doStartTag();
    if (_jspx_th_html_005fhidden_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fvalue_005fstyleId_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fvalue_005fstyleId_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f1);
    return false;
  }

  private boolean _jspx_meth_html_005ftext_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_005ftext_005f1 = (org.apache.struts.taglib.html.TextTag) _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_005ftext_005f1.setPageContext(_jspx_page_context);
    _jspx_th_html_005ftext_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f1);
    // /jsp/section/sectionManagement.jsp(60,28) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f1.setProperty("tSection.sectionName");
    // /jsp/section/sectionManagement.jsp(60,28) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f1.setStyleId("sectionName");
    // /jsp/section/sectionManagement.jsp(60,28) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f1.setStyle("width:183px");
    int _jspx_eval_html_005ftext_005f1 = _jspx_th_html_005ftext_005f1.doStartTag();
    if (_jspx_th_html_005ftext_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.reuse(_jspx_th_html_005ftext_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.reuse(_jspx_th_html_005ftext_005f1);
    return false;
  }

  private boolean _jspx_meth_html_005ftextarea_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:textarea
    org.apache.struts.taglib.html.TextareaTag _jspx_th_html_005ftextarea_005f0 = (org.apache.struts.taglib.html.TextareaTag) _005fjspx_005ftagPool_005fhtml_005ftextarea_0026_005fstyleId_005fstyle_005fproperty_005fnobody.get(org.apache.struts.taglib.html.TextareaTag.class);
    _jspx_th_html_005ftextarea_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005ftextarea_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f1);
    // /jsp/section/sectionManagement.jsp(65,16) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftextarea_005f0.setProperty("tSection.sectionIntro");
    // /jsp/section/sectionManagement.jsp(65,16) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftextarea_005f0.setStyleId("sectionIntro");
    // /jsp/section/sectionManagement.jsp(65,16) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftextarea_005f0.setStyle("width:80");
    int _jspx_eval_html_005ftextarea_005f0 = _jspx_th_html_005ftextarea_005f0.doStartTag();
    if (_jspx_th_html_005ftextarea_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005ftextarea_0026_005fstyleId_005fstyle_005fproperty_005fnobody.reuse(_jspx_th_html_005ftextarea_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005ftextarea_0026_005fstyleId_005fstyle_005fproperty_005fnobody.reuse(_jspx_th_html_005ftextarea_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005fselect_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:select
    org.apache.struts.taglib.html.SelectTag _jspx_th_html_005fselect_005f0 = (org.apache.struts.taglib.html.SelectTag) _005fjspx_005ftagPool_005fhtml_005fselect_0026_005fstyleId_005fstyle_005fsize_005fproperty.get(org.apache.struts.taglib.html.SelectTag.class);
    _jspx_th_html_005fselect_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fselect_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f1);
    // /jsp/section/sectionManagement.jsp(71,13) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fselect_005f0.setProperty("attribute(id)");
    // /jsp/section/sectionManagement.jsp(71,13) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fselect_005f0.setStyleId("section");
    // /jsp/section/sectionManagement.jsp(71,13) name = size type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fselect_005f0.setSize("1");
    // /jsp/section/sectionManagement.jsp(71,13) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fselect_005f0.setStyle("width:183px");
    int _jspx_eval_html_005fselect_005f0 = _jspx_th_html_005fselect_005f0.doStartTag();
    if (_jspx_eval_html_005fselect_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005fselect_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005fselect_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005fselect_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t       \t ");
        if (_jspx_meth_html_005foption_005f0(_jspx_th_html_005fselect_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t       \t ");
        if (_jspx_meth_html_005foptionsCollection_005f0(_jspx_th_html_005fselect_005f0, _jspx_page_context))
          return true;
        out.write(" \r\n");
        out.write("\t\t\t       \t ");
        int evalDoAfterBody = _jspx_th_html_005fselect_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005fselect_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005fselect_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fselect_0026_005fstyleId_005fstyle_005fsize_005fproperty.reuse(_jspx_th_html_005fselect_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fselect_0026_005fstyleId_005fstyle_005fsize_005fproperty.reuse(_jspx_th_html_005fselect_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005foption_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fselect_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:option
    org.apache.struts.taglib.html.OptionTag _jspx_th_html_005foption_005f0 = (org.apache.struts.taglib.html.OptionTag) _005fjspx_005ftagPool_005fhtml_005foption_0026_005fvalue.get(org.apache.struts.taglib.html.OptionTag.class);
    _jspx_th_html_005foption_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005foption_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fselect_005f0);
    // /jsp/section/sectionManagement.jsp(72,12) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005foption_005f0.setValue("0");
    int _jspx_eval_html_005foption_005f0 = _jspx_th_html_005foption_005f0.doStartTag();
    if (_jspx_eval_html_005foption_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005foption_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005foption_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005foption_005f0.doInitBody();
      }
      do {
        out.write("请选择版主");
        int evalDoAfterBody = _jspx_th_html_005foption_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005foption_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005foption_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005foption_0026_005fvalue.reuse(_jspx_th_html_005foption_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005foption_0026_005fvalue.reuse(_jspx_th_html_005foption_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005foptionsCollection_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fselect_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:optionsCollection
    org.apache.struts.taglib.html.OptionsCollectionTag _jspx_th_html_005foptionsCollection_005f0 = (org.apache.struts.taglib.html.OptionsCollectionTag) _005fjspx_005ftagPool_005fhtml_005foptionsCollection_0026_005fvalue_005fproperty_005fname_005flabel_005fnobody.get(org.apache.struts.taglib.html.OptionsCollectionTag.class);
    _jspx_th_html_005foptionsCollection_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005foptionsCollection_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fselect_005f0);
    // /jsp/section/sectionManagement.jsp(73,12) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005foptionsCollection_005f0.setProperty("usernameList");
    // /jsp/section/sectionManagement.jsp(73,12) name = label type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005foptionsCollection_005f0.setLabel("name");
    // /jsp/section/sectionManagement.jsp(73,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005foptionsCollection_005f0.setValue("id");
    // /jsp/section/sectionManagement.jsp(73,12) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005foptionsCollection_005f0.setName("userForm");
    int _jspx_eval_html_005foptionsCollection_005f0 = _jspx_th_html_005foptionsCollection_005f0.doStartTag();
    if (_jspx_th_html_005foptionsCollection_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005foptionsCollection_0026_005fvalue_005fproperty_005fname_005flabel_005fnobody.reuse(_jspx_th_html_005foptionsCollection_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005foptionsCollection_0026_005fvalue_005fproperty_005fname_005flabel_005fnobody.reuse(_jspx_th_html_005foptionsCollection_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005fradio_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:radio
    org.apache.struts.taglib.html.RadioTag _jspx_th_html_005fradio_005f0 = (org.apache.struts.taglib.html.RadioTag) _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.get(org.apache.struts.taglib.html.RadioTag.class);
    _jspx_th_html_005fradio_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005fradio_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f1);
    // /jsp/section/sectionManagement.jsp(81,17) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fradio_005f0.setProperty("tSection.isAuditing");
    // /jsp/section/sectionManagement.jsp(81,17) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fradio_005f0.setStyleId("auditing");
    // /jsp/section/sectionManagement.jsp(81,17) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fradio_005f0.setValue("1");
    int _jspx_eval_html_005fradio_005f0 = _jspx_th_html_005fradio_005f0.doStartTag();
    if (_jspx_eval_html_005fradio_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005fradio_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005fradio_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005fradio_005f0.doInitBody();
      }
      do {
        out.write('是');
        int evalDoAfterBody = _jspx_th_html_005fradio_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005fradio_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005fradio_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.reuse(_jspx_th_html_005fradio_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.reuse(_jspx_th_html_005fradio_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005fradio_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:radio
    org.apache.struts.taglib.html.RadioTag _jspx_th_html_005fradio_005f1 = (org.apache.struts.taglib.html.RadioTag) _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.get(org.apache.struts.taglib.html.RadioTag.class);
    _jspx_th_html_005fradio_005f1.setPageContext(_jspx_page_context);
    _jspx_th_html_005fradio_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f1);
    // /jsp/section/sectionManagement.jsp(82,7) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fradio_005f1.setProperty("tSection.isAuditing");
    // /jsp/section/sectionManagement.jsp(82,7) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fradio_005f1.setStyleId("auditing");
    // /jsp/section/sectionManagement.jsp(82,7) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fradio_005f1.setValue("0");
    int _jspx_eval_html_005fradio_005f1 = _jspx_th_html_005fradio_005f1.doStartTag();
    if (_jspx_eval_html_005fradio_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005fradio_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005fradio_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005fradio_005f1.doInitBody();
      }
      do {
        out.write('否');
        int evalDoAfterBody = _jspx_th_html_005fradio_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005fradio_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005fradio_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.reuse(_jspx_th_html_005fradio_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.reuse(_jspx_th_html_005fradio_005f1);
    return false;
  }

  private boolean _jspx_meth_html_005ftext_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_005ftext_005f2 = (org.apache.struts.taglib.html.TextTag) _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_005ftext_005f2.setPageContext(_jspx_page_context);
    _jspx_th_html_005ftext_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f1);
    // /jsp/section/sectionManagement.jsp(88,12) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f2.setProperty("tSection.visitCredits");
    // /jsp/section/sectionManagement.jsp(88,12) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f2.setStyle("width:183px");
    // /jsp/section/sectionManagement.jsp(88,12) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f2.setStyleId("visitCredits");
    int _jspx_eval_html_005ftext_005f2 = _jspx_th_html_005ftext_005f2.doStartTag();
    if (_jspx_th_html_005ftext_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.reuse(_jspx_th_html_005ftext_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.reuse(_jspx_th_html_005ftext_005f2);
    return false;
  }

  private boolean _jspx_meth_html_005freset_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:reset
    org.apache.struts.taglib.html.ResetTag _jspx_th_html_005freset_005f0 = (org.apache.struts.taglib.html.ResetTag) _005fjspx_005ftagPool_005fhtml_005freset_0026_005fvalue_005fstyleClass_005fonclick_005fnobody.get(org.apache.struts.taglib.html.ResetTag.class);
    _jspx_th_html_005freset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_html_005freset_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f1);
    // /jsp/section/sectionManagement.jsp(92,156) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005freset_005f0.setValue("取消");
    // /jsp/section/sectionManagement.jsp(92,156) name = styleClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005freset_005f0.setStyleClass("content_cancel");
    // /jsp/section/sectionManagement.jsp(92,156) name = onclick type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005freset_005f0.setOnclick("clearFormData();");
    int _jspx_eval_html_005freset_005f0 = _jspx_th_html_005freset_005f0.doStartTag();
    if (_jspx_th_html_005freset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005freset_0026_005fvalue_005fstyleClass_005fonclick_005fnobody.reuse(_jspx_th_html_005freset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005freset_0026_005fvalue_005fstyleClass_005fonclick_005fnobody.reuse(_jspx_th_html_005freset_005f0);
    return false;
  }

  private boolean _jspx_meth_html_005fform_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:form
    org.apache.struts.taglib.html.FormTag _jspx_th_html_005fform_005f2 = (org.apache.struts.taglib.html.FormTag) _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fmethod_005faction.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_html_005fform_005f2.setPageContext(_jspx_page_context);
    _jspx_th_html_005fform_005f2.setParent(null);
    // /jsp/section/sectionManagement.jsp(105,8) name = action type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fform_005f2.setAction("/section/updateSection.ao?method=updateSectionInfo");
    // /jsp/section/sectionManagement.jsp(105,8) name = method type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fform_005f2.setMethod("post");
    // /jsp/section/sectionManagement.jsp(105,8) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fform_005f2.setStyleId("updateSectionForm");
    int _jspx_eval_html_005fform_005f2 = _jspx_th_html_005fform_005f2.doStartTag();
    if (_jspx_eval_html_005fform_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("         <fieldset class=\"expandFieldset collapsedFieldset\"  style=\"padding: 0px; margin-right: 5px;\">\r\n");
        out.write("         <legend class=\"areaSpan\"><span><label for=\"\" style=\"font-size:14px\">版块信息</label></span></legend>\r\n");
        out.write("\t\t\t\t<table align=\"center\" border=\"0\" width=\"400\">\r\n");
        out.write("\t\t\t\t<!-- 隐藏用户id -->\r\n");
        out.write("\t\t\t\t   <tr>\r\n");
        out.write("\t\t\t\t      <td  align=\"right\"></td>\r\n");
        out.write("\t\t\t         <td align=\"center\">");
        if (_jspx_meth_html_005fhidden_005f2(_jspx_th_html_005fform_005f2, _jspx_page_context))
          return true;
        out.write("</td>\r\n");
        out.write("\t\t\t         <td ></td>\r\n");
        out.write("\t\t\t\t   </tr>\r\n");
        out.write("\t\t\t\t   <tr>\r\n");
        out.write("\t\t\t\t      <td width=\"181\" height=\"32\" align=\"right\">版块名称：</td>\r\n");
        out.write("\t\t\t         <td width=\"156\">");
        if (_jspx_meth_html_005ftext_005f3(_jspx_th_html_005fform_005f2, _jspx_page_context))
          return true;
        out.write("</td>\r\n");
        out.write("\t\t\t         <td width=\"129\"></td>\r\n");
        out.write("\t\t\t\t   </tr> \r\n");
        out.write("\t\t\t\t   <tr>\r\n");
        out.write("\t\t\t\t      <td height=\"33\" align=\"right\">是否审核：</td>\r\n");
        out.write("\t\t\t\t      <td colspan=\"2\">\r\n");
        out.write("\t     \t         \t");
        if (_jspx_meth_html_005fradio_005f2(_jspx_th_html_005fform_005f2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_html_005fradio_005f3(_jspx_th_html_005fform_005f2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t      </td>\r\n");
        out.write("\t\t\t\t   </tr>\r\n");
        out.write("\t\t\t\t   <tr>　\r\n");
        out.write("\t\t\t\t      <td height=\"35\" align=\"right\">访问积分：</td>\r\n");
        out.write("\t\t\t\t      <td>\r\n");
        out.write("\t     \t\t    ");
        if (_jspx_meth_html_005ftext_005f4(_jspx_th_html_005fform_005f2, _jspx_page_context))
          return true;
        out.write(" </td>\r\n");
        out.write("\t\t\t\t      <td></td>\r\n");
        out.write("\t\t\t\t   </tr>\r\n");
        out.write("\t\t\t\t   <tr>\r\n");
        out.write("\t\t\t\t      <td height=\"37\" colspan=\"3\" align=\"center\"><input type=\"button\" id=\"btn\"  class=\"content_save\" value=\"保存\" onClick=\"updateSectionSibmit();\" ></input>");
        if (_jspx_meth_html_005freset_005f1(_jspx_th_html_005fform_005f2, _jspx_page_context))
          return true;
        out.write("</td>\r\n");
        out.write("\t\t\t\t   </tr>\r\n");
        out.write("\t\t\t</table>\r\n");
        out.write("\t\t\t\t</fieldset>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_html_005fform_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_html_005fform_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fmethod_005faction.reuse(_jspx_th_html_005fform_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fform_0026_005fstyleId_005fmethod_005faction.reuse(_jspx_th_html_005fform_005f2);
    return false;
  }

  private boolean _jspx_meth_html_005fhidden_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_005fhidden_005f2 = (org.apache.struts.taglib.html.HiddenTag) _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_005fhidden_005f2.setPageContext(_jspx_page_context);
    _jspx_th_html_005fhidden_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f2);
    // /jsp/section/sectionManagement.jsp(112,31) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fhidden_005f2.setProperty("tSection.id");
    int _jspx_eval_html_005fhidden_005f2 = _jspx_th_html_005fhidden_005f2.doStartTag();
    if (_jspx_th_html_005fhidden_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fhidden_0026_005fproperty_005fnobody.reuse(_jspx_th_html_005fhidden_005f2);
    return false;
  }

  private boolean _jspx_meth_html_005ftext_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_005ftext_005f3 = (org.apache.struts.taglib.html.TextTag) _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_005ftext_005f3.setPageContext(_jspx_page_context);
    _jspx_th_html_005ftext_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f2);
    // /jsp/section/sectionManagement.jsp(117,28) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f3.setProperty("tSection.sectionName");
    // /jsp/section/sectionManagement.jsp(117,28) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f3.setStyleId("upSectionName");
    // /jsp/section/sectionManagement.jsp(117,28) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f3.setStyle("width:142px");
    int _jspx_eval_html_005ftext_005f3 = _jspx_th_html_005ftext_005f3.doStartTag();
    if (_jspx_th_html_005ftext_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.reuse(_jspx_th_html_005ftext_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.reuse(_jspx_th_html_005ftext_005f3);
    return false;
  }

  private boolean _jspx_meth_html_005fradio_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:radio
    org.apache.struts.taglib.html.RadioTag _jspx_th_html_005fradio_005f2 = (org.apache.struts.taglib.html.RadioTag) _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.get(org.apache.struts.taglib.html.RadioTag.class);
    _jspx_th_html_005fradio_005f2.setPageContext(_jspx_page_context);
    _jspx_th_html_005fradio_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f2);
    // /jsp/section/sectionManagement.jsp(123,17) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fradio_005f2.setProperty("tSection.isAuditing");
    // /jsp/section/sectionManagement.jsp(123,17) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fradio_005f2.setStyleId("upAuditing");
    // /jsp/section/sectionManagement.jsp(123,17) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fradio_005f2.setValue("1");
    int _jspx_eval_html_005fradio_005f2 = _jspx_th_html_005fradio_005f2.doStartTag();
    if (_jspx_eval_html_005fradio_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005fradio_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005fradio_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005fradio_005f2.doInitBody();
      }
      do {
        out.write('是');
        int evalDoAfterBody = _jspx_th_html_005fradio_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005fradio_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005fradio_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.reuse(_jspx_th_html_005fradio_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.reuse(_jspx_th_html_005fradio_005f2);
    return false;
  }

  private boolean _jspx_meth_html_005fradio_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:radio
    org.apache.struts.taglib.html.RadioTag _jspx_th_html_005fradio_005f3 = (org.apache.struts.taglib.html.RadioTag) _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.get(org.apache.struts.taglib.html.RadioTag.class);
    _jspx_th_html_005fradio_005f3.setPageContext(_jspx_page_context);
    _jspx_th_html_005fradio_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f2);
    // /jsp/section/sectionManagement.jsp(124,7) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fradio_005f3.setProperty("tSection.isAuditing");
    // /jsp/section/sectionManagement.jsp(124,7) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fradio_005f3.setStyleId("upAuditing");
    // /jsp/section/sectionManagement.jsp(124,7) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005fradio_005f3.setValue("0");
    int _jspx_eval_html_005fradio_005f3 = _jspx_th_html_005fradio_005f3.doStartTag();
    if (_jspx_eval_html_005fradio_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_005fradio_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_005fradio_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_005fradio_005f3.doInitBody();
      }
      do {
        out.write('否');
        int evalDoAfterBody = _jspx_th_html_005fradio_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_005fradio_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_html_005fradio_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.reuse(_jspx_th_html_005fradio_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005fradio_0026_005fvalue_005fstyleId_005fproperty.reuse(_jspx_th_html_005fradio_005f3);
    return false;
  }

  private boolean _jspx_meth_html_005ftext_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_005ftext_005f4 = (org.apache.struts.taglib.html.TextTag) _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_005ftext_005f4.setPageContext(_jspx_page_context);
    _jspx_th_html_005ftext_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f2);
    // /jsp/section/sectionManagement.jsp(130,12) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f4.setProperty("tSection.visitCredits");
    // /jsp/section/sectionManagement.jsp(130,12) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f4.setStyle("width:142px");
    // /jsp/section/sectionManagement.jsp(130,12) name = styleId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005ftext_005f4.setStyleId("upVisitCredits");
    int _jspx_eval_html_005ftext_005f4 = _jspx_th_html_005ftext_005f4.doStartTag();
    if (_jspx_th_html_005ftext_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.reuse(_jspx_th_html_005ftext_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005ftext_0026_005fstyleId_005fstyle_005fproperty_005fnobody.reuse(_jspx_th_html_005ftext_005f4);
    return false;
  }

  private boolean _jspx_meth_html_005freset_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_005fform_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:reset
    org.apache.struts.taglib.html.ResetTag _jspx_th_html_005freset_005f1 = (org.apache.struts.taglib.html.ResetTag) _005fjspx_005ftagPool_005fhtml_005freset_0026_005fvalue_005fstyleClass_005fonclick_005fnobody.get(org.apache.struts.taglib.html.ResetTag.class);
    _jspx_th_html_005freset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_html_005freset_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_005fform_005f2);
    // /jsp/section/sectionManagement.jsp(134,158) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005freset_005f1.setValue("取消");
    // /jsp/section/sectionManagement.jsp(134,158) name = styleClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005freset_005f1.setStyleClass("content_cancel");
    // /jsp/section/sectionManagement.jsp(134,158) name = onclick type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_html_005freset_005f1.setOnclick("cancelUdate();");
    int _jspx_eval_html_005freset_005f1 = _jspx_th_html_005freset_005f1.doStartTag();
    if (_jspx_th_html_005freset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fhtml_005freset_0026_005fvalue_005fstyleClass_005fonclick_005fnobody.reuse(_jspx_th_html_005freset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtml_005freset_0026_005fvalue_005fstyleClass_005fonclick_005fnobody.reuse(_jspx_th_html_005freset_005f1);
    return false;
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
    // /jsp/section/sectionManagement.jsp(143,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f15.setValue("/jsp/section/sectionManagement.js");
    int _jspx_eval_c_005furl_005f15 = _jspx_th_c_005furl_005f15.doStartTag();
    if (_jspx_th_c_005furl_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f15);
    return false;
  }
}
