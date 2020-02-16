<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>HealthCareHome_share</title>

<link href="healthcare.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body,td,th {
	font-family: "黑体";
	font-size: 12px;
}

body {
	margin-bottom: 50px;
}
</style>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$("a[class=reply_open]").toggle(function() {
			$(this).html("收起");
			$("div[class=replybox]").slideUp();
		}, function() {
			$(this).html("查看");
			$("div[class=replybox]").slideDown();
		});
		$("a[class=reply]").click(function(e) {

		});

	});
</script>
</head>

<body>
	<div id="container">
		<!--页面布局框架样式-->
		<div id="title">
			<img src="images/Logo.png" style="margin-top:40px; margin-left:20px;" />
			<span><a href="index.jsp">返回主页</a>&nbsp;&nbsp;</span>
		</div>
		<hr />
		<div id="navigation">
			<!--导航栏样式-->
			<form id="loginform">
				当前用户：${cus.customName }
			</form>
		</div>
		<h1 align="center">消息列表</h1>
		<div id="share_Newcontent">
			<div id="share_Newcontent_Title">
				<a href="index.jsp"><span>返回首页</span></a>&nbsp;|<a href="shownewstitle"><span>NBA快线</span></a>&nbsp;|<a
					href="showpublish"><span>互动分享</span></a><br />
				<br />
			</div>
            <table align="center">
            <tr>
            	<th>发布人</th>
            	<th>发布内容</th>
            	<th>评论人</th>
            	<th>评论内容</th>
            	<th>点赞数 </th>
            
            </tr>
            <s:iterator value="rlist">
            	<tr>
            		<td align="center" style="width: 100px;">${publish.custom.customName }</td>
            		<td align="center" style="width: 200px;">${publish.publishMassqge }</td>
            		<td align="center" style="width: 200px;">${custom.customName}</td>
            		<td align="center" style="width: 200px;">${replyMassage }</td>
            		<td align="center"><img alt="" src="images/support2.png">${count }</td>
            	</tr>
            </s:iterator>
           
            </table>
		<hr />
		<div id="footbar">
			<p>越测越开心项目小组版权拥有&copy;copyright 2015-2018</p>
		</div>
	</div>

</body>
</html>