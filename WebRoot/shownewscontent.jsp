<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

</head>
<body>
<div id="id01">
		<div id="title" align="center">
			<img src="images/Logo.png" style="margin-top:40px; margin-left:20px;" />
		</div>
<h1 align="center">NBA体育资讯详细新闻内容</h1>
	新闻信息>NBA体育资讯&nbsp;&nbsp;
	<a href="shownewstitle">返回新闻主页主页</a>
	<h1 align="center">${news1.newsTitle }</h1>
	<p align="center">${news1.newsContent }</p>
	<p align="center">
		<img alt="" src="images/images/basketball${news1.newsId }.gif">
	</p>
</div>
</body>
</html>
