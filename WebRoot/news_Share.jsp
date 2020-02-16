<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
     	$("a[class=reply_open]").toggle(
 	 		function () {
    			$(this).html("收起");
				$("div[class=replybox]").slideUp();
 			},function () {
  			 $(this).html("查看");
			 $("div[class=replybox]").slideDown();
  			}
		);
		$("a[class=reply]").click(function(e) {
            
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
     <span><a href="regist.html">注册</a>&nbsp;|&nbsp;<a href="#">注销</a></span>
	</div>	
    <hr />
  <div id="navigation"> 	<!--导航栏样式-->
    	<form id="loginform">
        	<span>用户名：</span><input type="text" name="Custom_name" />
            <span>密 码：</span><input type="password" name="Custom_pwd"/>
            <input type="submit" id="loginsumbit" value="登陆" />
        </form>
    </div>
    <div id="megAlertTsable">
        	<marquee id="alert" scrolldelay="90" onmouseover="this.stop()" onmouseout="this.start()"><a href="#" style="color:#F30">消息提醒！！！您有1条新的短消息</a></marquee>
        </div>
    <div id="share_Newcontent">
    	<div id="share_Newcontent_Title">
        	&nbsp;<span>世界足坛</span>&nbsp;|&nbsp;<span>NBA快线</span>&nbsp;|&nbsp;<span>健康资讯</span>
         <div id="Newcontent_tableLeft">
         	<li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
             <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
         </div>
         
         <div id="Newcontent_tableRight">
         	<li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
            <li class="news"><a href="#"> 皇家马德里传奇球星劳尔宣布本赛季结束后正式退役</a>            </li>
         </div>
        </div>
    </div>
    <div id="share_content">
    	<div id="share_content_Title">
        	&nbsp;<span>最新发布</span>&nbsp;|&nbsp;<span>最新回复</span>
        </div>
        <div id="megPublish">
        	<div id="custPic"><img src="images/female2.png" style="margin-top:30px; margin-left:15px;"/></div>
       	<div id="custName"><a href="#" style="color:#C00; font-size:15px;">张三丰</a></div>
        <div id="megPubWin">
        <textarea name="meg"></textarea>&nbsp;<input type="button" value="发布" />
        </div>
        </div>
        <div class="megpubed">
        	<div class="pubeddate">&nbsp;&nbsp;发布时间：2015-12-03 12:06:52</div>
            <div class="message">我：今天真是个好天气啊！</div>
            <div class="reply_support"> 收到2条回复&nbsp;<a class="reply_open" href="#">查看</a>&nbsp;点赞:3次</div>
        </div>
        <div class="replybox" hidden="hidden" style="height:auto">
        		<table style="margin-left:30px;">
                <tr>
                	<td style="width:60px;">回复人:</td>
                    <td style="width:40px;">回复:</td>
                    <td style="width:400px; height:auto">我也这么觉得</td>
                    <td><a class="reply" href="#">回复</a></td>
                    <div id="replybox_input">
                	 	<input type="text" name="replymeg" />
                	</div>
                </tr>
                 <tr>
                	<td style="width:60px;">回复人:</td>
                    <td style="width:40px;">回复:</td>
                    <td style="width:400px; height:auto"></td>
                    <td><a href="#">回复</a></td>
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