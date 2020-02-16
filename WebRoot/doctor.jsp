<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>HealthCareHome</title>

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
<script type="text/javascript" src="js/jquery.easyui.mobile.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet" type="text/css" href="css/easyui/easyui.css" />
<link rel="stylesheet" type="text/css" href="css/easyui/icon.css" />
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(e) {
		if ($('#admin').val() != "") {
			$('#loginform').hide();
		}
		if ($('#admin').val() == "") {
			$('#loginform').show();

		}

		$('#del').mousedown(function(e) {
			if (confirm("你确定注销吗?") == true) {
				window.location.href = "deloginaction";
			}
		});
		$("#order").click(function(e) {
			$("#can").show();
		});
		$("#cancel").click(function(e) {
			$("#can").hide();
		});
	});

	function submit() {
		alert(1111111111);

	}
</script>
</head>

<body>
	<!-- <iframe name="dd"> -->
	<div id="container">
		<!--页面布局框架样式-->

		<div id="title">
			<img src="images/Logo.png" style="margin-top:40px; margin-left:20px;" />
			<span><a href="index.jsp">返回主页</a>&nbsp;|&nbsp;</span>
		</div>
		<hr />
		<div id="navigation">
			<!--导航栏样式-->
			<input type="hidden" value="${cus}" id="admin" /> <span
				style="font-size:18px; color:#FFF; line-height:40px;">&nbsp;&nbsp;当前用户:<s:if
					test="#session.cus==null">您没有登录</s:if>${cus.customName}
			</span>
			<form id="loginform" action="loginaction" method="post">
				<span>用户名：</span><input type="text" name="custom.customName" /> <span>密
					码：</span><input type="password" name="custom.customPwd" /> <input
					type="submit" id="loginsumbit" value="登陆" />
			</form>
		</div>

		<div style="float: left; width: 920px; height: 300px;">
			<div id="doctorCON">
				<div id="doctorMiddle" style="overflow: auto;">
					<div
						style="width:900px; height:30px; background-color:#093;
        font-size:14px; line-height:30px; text-align:30px;">
						&nbsp;&nbsp;|名医在线</div>

					<div>
						<table width="900" border="1">
							<s:iterator value="dlist">
								<form action="insertaction" method="post">
									<tr>

										<td width="175">${doctorImg}<br />
										<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
											type="hidden" name="customSubscribe.doctorinfo.getdoctorName"
											value="${doctorName}" />${doctorName}</td>
										<td width="562" height="180px;"><p>华中科技大学同济医院</p>
											<p>专业介绍：${doctorSkill}&nbsp;&nbsp;${doctorRank}</p>
											<p>坐诊时间：${doctorTime}</p>
											<p><input type="hidden" name="CustomSubscribe.subscribeDate" />
												预约备注： ${subscribeDate}<input
													name="customSubscribe.subscribeDate" value="${subscribeDate}"></input>
											</p></td>
										<td width="161"><input type="hidden" name="doctorinfobyid" value="${doctorId}"/><input id="order" type="submit"
											value="预约" /></td>
									</tr>

								</form>
							</s:iterator>
						</table>
					</div>
				</div>
			</div>
			<div id="doctorFoot">
				<div
					style=" width:920px; height:20px;;font-size:12px; line-height:20px; text-indent:10px; background-color:#0C3;
            float:left;">|&nbsp;您的预约信息</div>
				<div style="width:920px;">
				
					
						<table width="900" border="1">
							<tr>
								<td>预约单号</td>
								<td>预约备注</td>
								<td>预约医生</td>
								<td>状态</td>
								<td></td>
							</tr>
								<s:iterator value="listcusto">
								<form action="delete" method="post">
								<tr>
									<td><input type="hidden" name="customSubscribe.subscribeId" value="${subscribeId}"/>${subscribeId}</td>
									<td>${subscribeDate}</td>
									<td>${customName}</td>
									<td>进行中</td>
									<td><input type="submit" value="取消预约" /></td>
								</tr>
								</form>
							</s:iterator>
							
						</table>
					
				</div>

			</div>

			<hr />
			<div id="footbar">
				<p>越测越开心项目小组版权拥有&copy;copyright 2015-2018</p>
			</div>
		</div>
	</div>
	<!-- </iframe> -->
</body>
</html>

