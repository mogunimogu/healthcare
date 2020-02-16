<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'shownewscontent.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
li {
	width: 900px;
	height: 50px;
	font-size: 18px;
}
</style>
</head>

<body>
	<div id="id01">
		<div id="title" align="center">
			<img src="images/Logo.png" style="margin-top:40px; margin-left:20px;" />
		</div>
		<hr />
		<div id="navigation">
			<input type="hidden" value="${cus}" id="admin" /> <span
				style="font-size:18px; color:#FFF; line-height:40px;">&nbsp;&nbsp;当前用户:<s:if
					test="#session.cus==null">您没有登录</s:if>${cus.customName}
			</span>
			<h1 align="center">NBA体育资讯</h1>
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新闻信息>NBA体育资讯&nbsp;&nbsp;<a
			href="showpublish">互动分享</a>&nbsp;&nbsp;&nbsp;<a href="index.jsp">返回首页</a>
		<div align="center">
			<s:iterator value="nlist">
				<li><a href="shownews?newsId=${newsId }">${newsTitle }</a></li>
			</s:iterator>
		</div>
	</div>
</body>
</html>
