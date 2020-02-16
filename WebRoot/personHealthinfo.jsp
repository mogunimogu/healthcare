<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	
</script>
</head>

<body>
<div id="container">		<!--页面布局框架样式-->
	<div id="title">
	  <img src="images/Logo.png" style="margin-top:40px; margin-left:20px;"/>
     <span ><a href="regist.html">注册</a>&nbsp;|&nbsp;<a href="#">注销</a></span>
	</div>	
    <hr />
  <div id="navigation"> 	<!--导航栏样式-->
  	<span style="font-size:16px;color:#FFF;line-height:40px; margin-left:20px;">欢迎您：</span>
    </div>
    
    <div id="content">   <!--首页内容框架-->
    	<div id="personInfo">
        	<table width="920" height="204" border="1">

          </table>
      </div>
      <div id="lifeSigninfo">
      	<div id="lifeSignTitle"><span style="line-height:25px; margin-left:20px; font-size:14px; color:#FFF;">个人体征历史信息</span></div>
        <table width="920" border="1">
  <tr>
    <td width="290" height="178">&nbsp;</td>
    <td width="319">&nbsp;</td>
    <td width="289">&nbsp;</td>
  </tr>
  <tr>
    <td height="62" align="center">血压</td>
    <td align="center">血糖</td>
    <td align="center">心率</td>
  </tr>
</table>

      </div>
      
        <div id="lifeSigninfo">
      	<div id="lifeSignTitle"><span style="line-height:25px; margin-left:20px; font-size:14px; color:#FFF;">日消耗信息</span></div>
      
      </div>
      
  </div>
    <hr />
  <div id="footbar">
    	<p> 越测越开心项目小组版权拥有&copy;copyright 2015-2018</p>
    </div>
</div>

</body>
</html>
