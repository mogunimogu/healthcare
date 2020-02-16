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
   $(document).ready(function(e) {
	    var lens = $('[id*=num_]').length;
		        var moneycount = 0;
			   for(var i=0; i<lens;i++)
			   {
				   var $moneys  =  parseFloat($('.moneytext').eq(i).html());
				   moneycount = moneycount + $moneys; 
				   }
				   $('#moneycount').html(moneycount+".0");
				   
				   
	  $('.add,.min').click(function(e) {
         var lens = $('[id*=num_]').length;
		        var moneycount = 0;
			   for(var i=0; i<lens;i++)
			   {
				   var $moneys  =  parseFloat($('.moneytext').eq(i).html());
				   moneycount = moneycount + $moneys; 
				   }
				   $('#moneycount').html(moneycount+".0");
    });
		  
	  $('.add').bind('mousedown',function(e) {
			   var $v =  parseInt($(this).prev('[id*=num_').val());
			   $(this).prev("[id*=num_]").val($v + 1);
			   var $money = parseFloat($(this).parent().prev().children('input').val());
			    $(this).parent().next().children('input').val($money * ($v+1));
			   $(this).parent().next().children('span').html($money*($v+1)+".0");
    });
	
	 $('.min').bind('mousedown',function(e) {
			   var $v =  parseInt($(this).next('[id*=num_').val());
			   if($v > 0)
			   {
			   $(this).next("[id*=num_]").val($v - 1);
			   var $money = parseFloat($(this).parent().prev().children('input').val());
			   $(this).parent().next().children('input').val($money * ($v-1));
			   $(this).parent().next().children('span').html($money*($v-1)+".0");
			   }
				   });
				   
	 $('#delshop').bind('mousedown',function(e) {
		  var $len =$('.selectbox').length;
		   var myshopid = new Array();
		    var r = 0;
		  for(var i=0; i<$len;i++)
		  {
			  var $strat = $('.selectbox').eq(i).is(':checked');
			  
			  if($strat == true)
			  {
				  myshopid[r] =$('.selectbox').eq(i).val(); 
				  r=r+1;
				  }
		  }
		window.location.href = "delshoppaction?shopid=" + myshopid.join();
		     });
		 
        
    $('#del').mousedown(function(e) {
        if(confirm("你确定注销吗?") == true)
		{
			window.location.href="deloginaction";
			}
			
    });				   
});
   $('#selitem').mousedown(function(e) {
	   $(this).css('cursor','pointer');
	   
   
    
});
   function selitem(){
      window.location.href="listItemaction";
	   }
	  
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
   	<span style="color:#FFF; font-size:14px; margin-left:50px; line-height:40px;">尊敬的用户:${cus.customName}，你好！
    <input id="selitem" type="button" onclick="selitem()" value="查看已购买的商品"/>
    </div>
    <form action="additemaction" method="post">
       <table width="940" border="1" style="margin:0 auto">
		  <tr>
		    <th width="107" height="63">选中</th>
		    <th width="207">产品名称</th>
		    <th width="250">单价</th>
		   	<th width="167">数量</th>
		    <th width="175">总价</th>
		  </tr>
		   
		  <s:iterator value="%{#session.listshop}" var="lshop">
		    <tr>
		    <td height="122" align="center"><input type="checkbox" class="selectbox" id="boxid" name="listshopid" value="${lshop.sid}"/></td>
		    <td align="center"><a href="shopping.html">${lshop.goods.goodsName}</a></td>
		    <td align="center"><input class="moneys" type="hidden" value="${lshop.goods.goodsPrice}"/>￥<span>${lshop.goods.goodsPrice}</span></td>
		    <td align="center">
		    <input type="button" class="min"   style="width:11px; height:15px; background-image:url(images/minus.jpg)"/>&nbsp;
            <input type="text" id="num_input" readonly="readonly" name="listcount" class="price" style="width:50px; text-align:center" value="${lshop.SCount}"/>&nbsp;
            <input type="button" class="add"  style="width:11px; height:15px; background-image:url(images/adding.jpg)"/>
            </td>
		    <td align="center">￥<span class="moneytext">${lshop.SPrice}</span><input type="hidden" class="moneys" name="listprice" value="${lshop.SPrice }"/></td>
		  </tr>
		  </s:iterator>
		  <tr>
		    <td height="68" colspan="3" align="center" style="color:#F30">结算价格：￥<span id="moneycount"></span></td>
		    <td colspan="2" align="center"><input id="delshop" type="button" value="选中删除" onclick="delshop()"/>&nbsp;<input type="submit" value="立即购买" /></td>
		    </tr>
	</table>
    </form>

</div>
    <hr />
  <div id="footbar">
    	<p> 越测越开心项目小组版权拥有&copy;copyright 2015-2018</p>
</div>

</body>
</html>
