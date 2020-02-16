<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="s" uri="/struts-tags"%>
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
	$(document).ready(function(e) {
        $("td[class=proName]").mouseover(function(e) {
            $(this).children().css("color","#06F");
			$(this).parent().next().show();
			$(this).css('cursor','pointer');
        });
		 $("td[class=proName]").mouseout(function(e) {
            $(this).children().css("color","#000");
			$(this).parent().next().hide();
        });
	$(document).mousedown(function(e) {
        
    });
    
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
   	<span style="color:#FFF; font-size:14px; margin-left:50px; line-height:40px;">尊敬的用户:${cus.customName}，你好！&nbsp;&nbsp;您的<a style="color:#FFF" href="listshopaction">购物车</a>中共有<span style="color:#F00"><input type="hidden" value="${counts}" id="nums" />${counts}</span>件商品</span>
    </div>
  <table width="940" border="1" style="margin:0 auto;">
  <tr>
    <td width="142" align="center" bgcolor="#999999">商品名称</td>
    <td width="162" align="center" bgcolor="#999999">商品图片</td>
    <td width="158" align="center" bgcolor="#999999">商品价格</td>
    <td width="118" align="center" bgcolor="#999999">产地</td>
    <td width="165" align="center" bgcolor="#999999">库存</td>
    <td width="155" align="center" bgcolor="#999999">操作</td>
  </tr>
  <s:iterator value="%{#session.goodlist}" var="glist">
       <tr>
    <td class="proName" height="105" align="center"><a style=" text-decoration:underline;">${glist.goodsName}</a><input type="hidden" name="shopcart.goods.goodsId" value="${glist.goodsId}"/></td>
    <td align="center"><img src="${glist.goodsImages} "/></td>
    <td align="center">￥<span>${glist.goodsPrice}</span></td>
    <td align="center">中国</td>
    <td align="center"><input type="hidden" name="shopcart.SCount" value="1"/>${glist.goodsStock}</td>
    <td align="center"><a  href="addshopaction?shopcart.goods.goodsId=${glist.goodsId}&shopcart.SCount=1">加入购物车</a></td>
  </tr>
    <tr class="proDetails" hidden="hidden">
    <td height="35" colspan="6" align="left" bgcolor="#FFFFCC" >${glist.goodsIntroduce}</td>
    </tr>
  </s:iterator>
 
  
</table>

  
</div>
    <hr />
  <div id="footbar">
    	<p> 越测越开心项目小组版权拥有&copy;copyright 2015-2018</p>
  </div>
</div>
</body>
</html>

