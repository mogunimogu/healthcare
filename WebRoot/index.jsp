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
  $(document).ready(function(e) {
	  if($('#admin').val() != "")
	  {
		  $('#loginform').hide();
		  }
	  if($('#admin').val() == "")
	  {
		  $('#loginform').show();
		  
		  }
	 
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
     <span><a href="regist.jsp">注册</a>&nbsp;|&nbsp;<a id="del" href="">注销</a></span>
	</div>	
    <hr />
  <div id="navigation"> 	<!--导航栏样式-->
    <input type="hidden" value="${cus}" id="admin"/>
   <span style="font-size:18px; color:#FFF; line-height:40px;">&nbsp;&nbsp;当前用户:<s:if test="#session.cus==null">您没有登录</s:if>${cus.customName} </span>
    	<form id="loginform" action="loginaction" method="post">
        	<span>用户名：</span><input type="text" name="custom.customName" />
            <span>密 码：</span><input type="password" name="custom.customPwd"/>
            <input type="submit" id="loginsumbit" value="登陆" />
        </form>
    </div>
    	<div align=""><a href="tencent://Message/?Uin=553011563&websitName=ss&Menu=yes">
   	<img border="0" alt="点击联系客服" src="http://wpa.qq.com/pa?p=1:553011563:16"/></a>
   	</div>
    <div id="content">   <!--首页内容框架-->
    	<table width="860" height="380" border="1" align="center" id="modle">
  <tr>
    <td width="430" height="190"><a href="error.jsp">个人健康信息</a></td>
    <td width="430"><a href="shownewstitle">互动分享</a></td>
  </tr>
  <tr>
    <td height="190"><a href="doctoraction">医疗服务</a></td>
    <td><a href="goodlistaction">购物商城</a></td>
  </tr>
</table>
	 <div id="blog">   <!--互动信息显示栏框架-->
      <div id="blogtitle">
       <span>&nbsp;最新发布</span>&nbsp;|&nbsp;<span>最新回复</span>
        </div>
       <table width="420" border="0" cellspacing="0" class="blogtable" >
  <tr>
    <td width="82" rowspan="3" align="center" bgcolor="#CCCCFF"><img src="images/female2.png"/><p style="margin-bottom:5px; margin-top:5px;">发布人</p></td>
    <td width="249" height="40" bgcolor="#CCCCFF" style="color:#C30">&nbsp;发布时间：2015-12-12:16:48:33</td>
    <td width="83" rowspan="2" bgcolor="#CCCCFF">&nbsp;</td>
  </tr>
  <tr>
    <td height="58" rowspan="2" valign="middle" bgcolor="#CCCCFF">&nbsp;今天天气真是好啊！！！<a href="#">回复</a></td>
    </tr>
  <tr>
    <td height="46" bgcolor="#CCCCFF"><img src="images/support2.png" /><span style="color:#C00"> +1</span></td>
  </tr>
       </table>
       
       <table width="420" border="0" cellspacing="0" class="blogtable" >
  <tr>
    <td width="82" rowspan="3" align="center" bgcolor="#CCCCFF"><img src="images/female2.png"/><p style="margin-bottom:5px; margin-top:5px;">发布人</p></td>
    <td width="249" height="40" bgcolor="#CCCCFF" style="color:#C30">&nbsp;发布时间：2015-12-12:16:48:33</td>
    <td width="83" rowspan="2" bgcolor="#CCCCFF">&nbsp;</td>
  </tr>
  <tr>
    <td height="58" rowspan="2" valign="middle" bgcolor="#CCCCFF">&nbsp;今天天气真是好啊！！！<a href="#">回复</a></td>
    </tr>
  <tr>
    <td height="46" bgcolor="#CCCCFF"><img src="images/support2.png" /><span style="color:#C00"> +1</span></td>
  </tr>
       </table>
       
  <table width="420" border="0" cellspacing="0" class="blogtable" >
  <tr>
    <td width="82" rowspan="3" align="center" bgcolor="#CCCCFF"><img src="images/female2.png"/><p style="margin-bottom:5px; margin-top:5px;">发布人</p></td>
    <td width="249" height="40" bgcolor="#CCCCFF" style="color:#C30">&nbsp;发布时间：2015-12-12:16:48:33</td>
    <td width="83" rowspan="2" bgcolor="#CCCCFF">&nbsp;</td>
  </tr>
  <tr>
    <td height="58" rowspan="2" valign="middle" bgcolor="#CCCCFF">&nbsp;今天天气真是好啊！！！<a href="#">回复</a></td>
    </tr>
  <tr>
    <td height="46" bgcolor="#CCCCFF"><img src="images/support2.png" /><span style="color:#C00"> +1</span></td>
  </tr>
       </table>
       
  <table width="420" border="0" cellspacing="0" class="blogtable" >
  <tr>
    <td width="82" rowspan="3" align="center" bgcolor="#CCCCFF"><img src="images/female2.png"/><p style="margin-bottom:5px; margin-top:5px;">发布人</p></td>
    <td width="249" height="40" bgcolor="#CCCCFF" style="color:#C30">&nbsp;发布时间：2015-12-12:16:48:33</td>
    <td width="83" rowspan="2" bgcolor="#CCCCFF">&nbsp;</td>
  </tr>
  <tr>
    <td height="58" rowspan="2" valign="middle" bgcolor="#CCCCFF">&nbsp;今天天气真是好啊！！！<a href="#">回复</a></td>
    </tr>
  <tr>
    <td height="46" bgcolor="#CCCCFF"><img src="images/support2.png" /><span style="color:#C00"> +1</span></td>
  </tr>
       </table>
       
  

     </div> 
     <div id="news">   <!--新闻显示互动-->
     	<div id="sportNews">
        <div id="sportNewstitle">
       <span>&nbsp;世界足坛</span>&nbsp;|&nbsp;<span>NBA快线</span> &nbsp;|&nbsp;<span>健康资讯</span>
        </div>
        <table id="sportNewsTable">
        <tr>
        	<td><a href="#">皇家马德里俱乐部传奇球星劳尔宣布本赛季后正式退役</a></td>
        </tr>
        <tr>
        	<td><a href="#">皇家马德里俱乐部传奇球星劳尔宣布本赛季后正式退役</a></td>
        </tr>
         <tr>
        	<td><a href="#">皇家马德里俱乐部传奇球星劳尔宣布本赛季后正式退役</a></td>
        </tr>
         <tr>
        	<td><a href="#">皇家马德里俱乐部传奇球星劳尔宣布本赛季后正式退役</a></td>
        </tr>
         <tr>
        	<td><a href="#">皇家马德里俱乐部传奇球星劳尔宣布本赛季后正式退役</a></td>
        </tr>
         <tr>
        	<td><a href="#">皇家马德里俱乐部传奇球星劳尔宣布本赛季后正式退役</a></td>
        </tr>
         <tr>
        	<td><a href="#">皇家马德里俱乐部传奇球星劳尔宣布本赛季后正式退役</a></td>
        </tr>
         <tr>
        	<td><a href="#">皇家马德里俱乐部传奇球星劳尔宣布本赛季后正式退役</a></td>
        </tr>
        </table>
       </div>
        <div id="proNews">
        <div id="proNewstitle">
       <span>&nbsp;新品上架</span>&nbsp;|&nbsp;<span>火热爆款</span>
        </div>
        <table id="proNewsTable" >
             <tr>
           	   <td class="propic"><img src="images/pro01.png" width="46" height="51"/></td>
                <td class="proinduce"><a href="#">肌肉科技增肌粉7磅瘦人增健肌健身乳清蛋白粉增重粉肌酸蛋白粉</a></td>
                <td class="prolocation">产地：澳洲</td>
            </tr>
            <tr>
           	   <td class="propic"><img src="images/pro01.png" width="46" height="51"/></td>
                <td class="proinduce"><a href="#">肌肉科技增肌粉7磅瘦人增健肌健身乳清蛋白粉增重粉肌酸蛋白粉</a></td>
                <td class="prolocation">产地：澳洲</td>
            </tr>
            <tr>
       	      <td class="propic"><img src="images/pro01.png" width="46" height="51"/></td>
              <td class="proinduce"><a href="#">肌肉科技增肌粉7磅瘦人增健肌健身乳清蛋白粉增重粉肌酸蛋白粉</a></td>
              <td class="prolocation">产地：澳洲</td>
            </tr>
        </table>
       </div>
     </div>  
  </div>
    <hr />
  <div id="footbar">
    	<p> 越测越开心项目小组版权拥有&copy;copyright 2015-2018</p>
    </div>
</div>

</body>
</html>

