<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="healthcare.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script>
	$(document).ready(function(e) {
		<!--判断用户名是否存在 -->
		$('#userName').keyup(function(e) {
			var url1 = "isbynameaction";
			var data1 = "custom.customName="+$(this).val();
            $.ajax({
				url:url1,
				data:data1,
				type:"POST",
				success:(function(result){
					$("#unamespan").html(result);
					})
				});
        });
		
       <!--4位随机数验证码的产生-->
		var arr = ["1","2","3","4","5","6","7","A","B","C","D","J","H","P"];
		var str ="";
		for(var i=0;i<4;i++){
			var ranstr=arr[Math.floor(Math.random()*14)];
			str = str+ranstr;
			}
	    $("#regnumspan").html(str);
		$('#matnmun').mouseover(function(e) {
            $(this).css("cursor","pointer");
        });
		$('#matnmun').mousedown(function(e) {
            var arr = ["1","2","3","4","5","6","7","A","B","C","D","J","H","P"];
		var str ="";
		for(var i=0;i<4;i++){
			var ranstr=arr[Math.floor(Math.random()*14)];
			str = str+ranstr;
			}
	    $("#regnumspan").html(str);
        });
		
		
		
		$('#regist').submit(function(e) {
			  if($('#unamespan').html()=="用户名已存在")
    {
    return false;
    }
             if($('#userName').val() == 0)
		{
			$('#userName').next("span").html("用户名不能为空");
			return false;
			}
		else{
			$('#userName').next("span").html("");
			}
			var $flag = $('#sexid').is(':checked');
		if( $flag == false)
		{
			$('#sexspan').html("性别不能为空!").css('color','#F00');
			return false;
			}
			else{
				$('#sexspan').html("");
				}
		if($('#passWord').val()==0)
		{
			$('#passWord').next("span").html("密码不能为空");
			return false;
			}
		else if($('#passWord').val().length < 6)
		{
			$('#passWord').next("span").html("密码不能小于6");
			return false;
			}
			else{
				$('#passWord').next("span").html("");
				}
		if($('#rePassWord').val()==0)
		{
			$('#rePassWord').next("span").html("确认密码不能为空");
			return false;
			}
		else if($('#rePassWord').val().length < 6)
		{
			$('#rePassWord').next("span").html("确认密码不能小于6");
			return false;
			}
		else if($('#rePassWord').val() != $('#passWord').val()){
			$('#rePassWord').next("span").html("两次输入密码不一致");
			return false;
			}
			else{
				$('#rePassWord').next("span").html("");
				}
			var reg = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
				var flag = reg.test($('#email').val());
			if($('#email').val().length==0)
				{
					$('#email').next('span').html('邮箱不能为空!').css('color','#F00');
					return false;
				}
				else if(flag==false)
			   {
				$('#email').next('span').html('格式不正确!').css('color','#F00');
				return false;
				}
			 else{
				 $('#email').next('span').html("");
				}
			 if($('#yanzheng').val().length == 0)
			 {
					$('#isyan').html('验证码为空!').css('color','#F00');
					return false;
				 }
				 else if($('#yanzheng').val() != $('#regnumspan').html()){
					 $('#isyan').html('验证码错误!').css('color','#F00');
					 return false;
					 }
				 else{
					 
					$('#isyan').html('').css('color','#F00');
					 }
					 var $checkid = $('#checkid').is(':checked');
			    if($checkid == false)
				{
					return false;
					}
        });
		
		
    });
	

</script>
</head>

<body>
<div id="container">		<!--页面布局框架样式-->
	<div id="title">
	  <img src="images/Logo.png" style="margin-top:40px; margin-left:20px;"/>
     <span><a href="index.jsp">回到首页</a></span>
	</div>	
    <hr />
  <div id="navigation"> 	<!--导航栏样式-->
    </div>
   <div id="content">
     <div id="registForm">
   		<div id="registFormtitle"><span>用户注册</span></div>	
          <form id="regist" action="registeraction" method="post">
     		<table width="430px" style=" margin:0 auto; line-height:3xp;">
     		  <tr>
     		    <td width="114" align="right">用户名：</td>
     		    <td width="270"><input name="custom.customName" id="userName"/><span id="unamespan"></span></td>
   		    </tr>
     		  <tr>
     		    <td align="right">注册角色：</td>
     		    <td><select name="custom.role.roleId">
                		<option value="2">普通用户</option>
                        <option value="3">医生</option>
                    </select><span></span></td>
   		    </tr>
     		  <tr>
     		    <td align="right">性别：</td>
     		    <td><input id="sexid" type="radio" name="custom.customSex" value="男" />男&nbsp;<input id="sexid" type="radio" name="custom.customSex" value="女" />女 <span id="sexspan"></span></td>
   		    </tr>
     		  <tr>
     		    <td align="right">请输入密码：</td>
     		    <td><input type="password" name="custom.customPwd" id="passWord" /><span></span></td>
   		    </tr>
     		  <tr>
     		    <td align="right">请再次输入密码：</td>
     		    <td><input type="password" name="repwd" id="rePassWord"/><span></span></td>
   		    </tr>
     		  <tr>
     		    <td align="right">注册邮箱：</td>
     		    <td><input type="text" name="custom.customEmail" id="email" /><span></span></td>
   		    </tr>
     		  <tr>
     		    <td align="right">请输入验证码：</td>
     		    <td><input type="text" id="yanzheng" style="width:80px;" />&nbsp;<span id="regnumspan"></span><a id="matnmun" style="text-decoration:underline;color:#00F; font-size:9px;">看不清,换一张</a><span id="isyan"></span>
     		   </td>
   		      </tr>
     		  <tr>
     		    <td colspan="2"><input type="checkbox" id="checkid" />
   		        请阅读以下协议并确认</td>
   		    </tr>
     		  <tr>
     		    <td colspan="2">
                <div id="agreement"><textarea style="width:95%; height:95%;">
本软件受中华人民共和国著作权法和有关著作权国际公约和其它知识产权相关法律及国际公约的保护，其所有知识产权，包括但不限于著作权，归虾米网所有。本软件产品的正常使用过程中需要链接网络，本软件会设置windows防火墙以允许其访问网络，保证本软件的正常使用。本软件产品（包括但不限于本软件产品中所含的任何图像、照片、动画、录像、录音、音乐、文字和附加程序(dll、exe等)）、随附的帮助材料、及本软件产品任何副本的一切所有权和知识产权，均由虾米网拥有。用户未经虾米网书面许可不得以违反本协议所约定之方式复制和修改本产品。
1.接受条款
欢迎使用虾米客户端软件。虾米客户端根据以下协议（以下称“许可协议”)为您提供服务。“许可协议”中的所有条款均可由虾米网随时更新，且毋须另行通知。
如果您所处国的司法管辖权禁止对虾米客户端的下载或使用，请您点击“取消”按钮而不去下载或使用此软件。
您在使用虾米客户端提供的各项服务之前，请仔细阅读本“许可协议”中各项条款。您一旦点击“我接受”下载虾米客户端软件，或开始使用或继续使用虾米客户端软件，即视为您已接受本“许可协议”中各项条款并受本“许可协议”约束，也即视为您表明及保证您是在相关法律许可下使用此项服务的。
2.服务说明
虾米客户端软件及协议(包括但不限于API协议)(以下称“软件”)，及经由虾米网授权使用的服务、内容或资料(以上统称“服务”)有能力提供给用户识别歌曲的功能。
在有更新版本的时候，虾米客户端将为用户提供自动更新软件的功能，为用户提供更完善的服务。
                </textarea></div></td>
   		      </tr>
      		    <td colspan="2" align="center"><input type="submit" value="注册" />&nbsp;&nbsp;<input type="reset" name="reset" value="重置" /></td>
   		      </tr>
   		  </table>
          </form>
     </div>
   
   </div>
    <hr />
  <div id="footbar">
    	<p> 越测越开心项目小组版权拥有&copy;copyright 2015-2018</p>
    </div>
</div>
</body>
</html>

