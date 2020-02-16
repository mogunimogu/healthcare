<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
	font-size: 14px;
}
body {
	margin-bottom: 50px;
}
</style>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
   function date1(){
	   window.location.href="dateafteraction";
	   }
   function date2()
   {
     window.location.href="datediffdayaction";
   }
    $(document).ready(function(e) {
		    $('#del').mousedown(function(e) {
		        if(confirm("你确定注销吗?") == true)
				{
					window.location.href="deloginaction";
					}			
	    });
    });
</script>
</head>

<body>
<div id="container">		<!--页面布局框架样式-->
	<div id="title">
	  <img src="images/Logo.png" style="margin-top:40px; margin-left:20px;"/>
     <span><a  href="index.jsp">返回主页</a></span>
	</div>	
    <hr />
  <div id="navigation"> 	<!--导航栏样式-->
   
    </div>
  <table width="940" border="1" style="margin:0 auto">
  <tr>
    <th height="42">订单编号</th>
    <th>下单时间</th>
    <th>产品名称</th>
    <th>收货人</th>
    <th>总价</th>
  </tr>
    <s:iterator value="%{#session.itemlist}" var="ilist">
    <tr align="center">
	    <td height="47">1002${ilist.itmeId}</td>
	    <td>${ilist.itemDate}</td>
	    <td>${ilist.goods.goodsName}</td>
	    <td>${ilist.custom.customName}</td>
	    <td>${ilist.itemPrice}</td>
    </tr>
    </s:iterator>
 
  
  <tr align="center">
    <td colspan="5"><a href="#">上一页</a>&nbsp;&nbsp;<input type="button" onclick="date2()" value="查看一周以内的订单"/>&nbsp;&nbsp;&nbsp;<input type="button" onclick="date1()"  value="查看一个月以前的订单"/>&nbsp;&nbsp;<a href="#">下一页</a></td>
    </tr>
</table>

     </div>  
  </div>
    <hr />
  <div id="footbar">
    	<p> 越测越开心项目小组版权拥有&copy;copyright 2015-2018</p>
    </div>
</div>

</body>
</html>
