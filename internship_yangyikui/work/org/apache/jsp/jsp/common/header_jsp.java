package org.apache.jsp.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t*{ margin: 0;\r\n");
      out.write("\tpadding: 0;}\r\n");
      out.write("\t</style> \r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<body id=\"content\">  \r\n");
      out.write("<div id=\"header\" style=\"width:1366px;height:60px;\">\r\n");
      out.write(" <a href=\"../../index.jsp\" target=\"_top\"    >\t<div id=\"logo\" style=\"width:220px;height:60px; background-image:url(../../skins/style_1/images/logo.png);float: left; cursor: pointer;\"></div></a>\r\n");
      out.write("\t<div id=\"right\" style=\"width:1144px;height:60px;border:0; float:right; background-image:url(../../skins/style_1/images/beijing.png)\">\r\n");
      out.write("\t\t <div id=\"showtime\" style=\"width:250px;height:30px; float:right;margin-top: 15px; margin-right:5px\"><iframe name=\"weather_inc\" src=\"http://cache.xixik.com.cn/10/tianjin/\" width=\"300\" height=\"25\" frameborder=\"0\" marginwidth=\"0\" marginheight=\"0\" scrolling=\"no\" ></iframe></div>\r\n");
      out.write("</div>\r\n");
      out.write("\t \r\n");
      out.write("</div>\r\n");
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
}
