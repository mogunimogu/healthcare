<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
			<span><a href="index.jsp">返回主页</a></span>
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
				<a href=""><span>返回首页</span></a>&nbsp;|<a href="shownewstitle"><span>NBA快线</span></a>&nbsp;|<a
					href="showpublish"><span>互动分享</span></a><br />
				<br />
				<table style="color: black;">
					<tr align="center">
						<th style="width: 150px;">发布消息编号</th>
						<th style="width: 150px;">发布人图像</th>
						<th style="width: 100px;">发布人名称</th>
						<th style="width: 250px;">发布内容</th>
						<th style="width: 100px;">发布时间</th>
						<th style="width: 150px;">操作</th>
					</tr>
					<s:iterator value="plist">
						<tr style="height: 60px" align="center">
							<td style="width: 150px;">${publishId }</td>
							<td style="width: 150px;"><img src="images/female2.png"
								alt="" /></td>
							<td style="width: 100px;">${custom.customName}</td>
							<td style="width: 150px;">${publishMassqge}</td>
							<td style="width: 100px;">${publishDate }</td>
							<td style="width: 250px;"><a
								href="support?publishId=${publishId }"><img
									src="images/support2.png" /></a>&nbsp;&nbsp;<form action="reply" method="post"><input type="hidden" value="${publishId}" name="publishId"/><input type="text" name="replyMassage"/><input type="submit" value="评论"/></form>&nbsp;&nbsp;<a
								href="showreply?publishId=${publishId }">查看</a></td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
		<hr/>
		<div id="publish" align="center">
		<h1 align="center">发布信息栏</h1>
			<form action="publish" method="post">
					<img src="images/images/publish.gif" alt="" /><br/><h4>发布的内容：<input
						type="text" name="publishMassqge" /> <input type="submit"
						value="发布" /></h4>
				</form>
		</div>
		<hr />
		<div id="footbar">
			<p>越测越开心项目小组版权拥有&copy;copyright 2015-2018</p>
		</div>
	</div>

</body>
</html>