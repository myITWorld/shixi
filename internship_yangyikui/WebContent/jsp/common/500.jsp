<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="true"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>供热收费系统</title>
		<link rel="stylesheet" type="text/css" href="<c:url value='/skins/style_1/css/style.css'/>" />
		<script language="Javascript" src="<c:url value='/js/jquery.js'/>" ></script>
		<script type="text/javascript">
			function controlDiv(){
				var msDiv = $("div[@id=stackTrace]");
				if(msDiv.css("display")=="none"){
					msDiv.fadeIn("slow"); 
				}else{
					
					msDiv.fadeOut("slow");
				}
				
			}
		</script>	
	</head>
	<body style="font-size:12px;">
	<div class="error_beijing" align="center">
		<div class="message_looktbx" align="left" >
			<div style="width:80px; float:left">
				<img src="<c:url value='/skins/style_1/images/500_logo.png'/>" style="margin:10px 10px 0 10px; " />
			</div>
			<div style="float:left; width:470px; margin-top:10px;">
				<div class="message_looktit">系统异常,500错误！</div>
				<div class="message_lookxiangxi">
					<div class="message_lookxiangxi">当前访问URL <script type="text/javascript">document.writeln(location.href);</script></div>
					<p id="red">查看异常信息：</p>
					<div>
						<textarea cols="80" rows="16">
							<%
								Throwable t = (Throwable) request.getAttribute("javax.servlet.error.exception");
								if(t == null) {
									t = (Throwable) request.getAttribute("javax.servlet.jsp.jspException");
								}
								if(t != null) {
									String msg = t.getMessage();
									out.println(msg);
									int i = 0;
									Throwable th = t;
									while(th.getCause() != null && i++ < 4) {
										StackTraceElement[] st = th.getStackTrace();
										for(StackTraceElement s : st) {
											out.println(s.toString());
										}
										th = th.getCause();
									}
								}
							%>
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<div class="message_lookps">您如果在使用中发现问题请致电：022-83717863！</div>
	</div>
	</body>
</html>