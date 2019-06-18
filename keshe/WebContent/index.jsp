<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	body{
		background:url("img/background.jpg")
	}
	.login{
		position:absolute;
		text-top:20px;
		text-align:center;
		top:50%;
		left:50%;
		margin:-150px 0 0 -200px;
		width:400px;
		height:360px;
		border:1px solid #008800;
      	background-color: #fff;
	}
	.common{
     	width: 310px;
    	height: 46px;
     	font-size: 16px;
    	font-family: "Microsoft YaHei";
    	border-radius: 4px;
    	border: 1px solid #cbcbcb;
    	padding-left: 5px;
    	padding-right: 5px;
    }
    .title{
      margin:10px;
      font-size: 40px;
      font-family: "Arial";
      color: #009dff;
    }
    .login_check_label {
    	float: left;
        margin-left: 10px;
        font-family: "Microsoft yahei";
        font-size: 14px;
        color: #999999;
        line-height: 14px;
    }
    .check_box_su{
      float: left;
      margin-left: 46px;
      width: 14px;
      height: 14px;
      border-radius:2px;
    }
    .loginto{
      margin:center;
      width: 320px;
      height: 46px;
      font-size: 20px;
      font-family: "Microsoft YaHei";
      border-radius: 4px;
      border: none;
      background-color: #009dff;
    }
    .register{
      float:left;
      margin-left:40px;
      width: 50px;
      height: 30px;
      font-size: 20px;
      font-family: "Microsoft YaHei";
      border-radius: 4px;
      border: 1px solid #cbcbcb;
      border-color:black;
      background-color: white;
    }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>火车订票系统</title>
</head>
<body>
<center><h1>火车订票系统</h1></center>

<div class="login">
	<div class="title">请登入</div>
	<form action="userAction!login" method="get">
	<input class= "common"  type="text" name="user.User_name" placeholder="账号"/><br/>
	<input class= "common" type="password" name="user.User_pass" placeholder="密码"/><br/> 
	<input class= "common"type="text" name="code" placeholder="验证码"/><br>
	<img  src="number.jsp"/>  <br/>
	<input class="check_box_su" type="checkbox" name="su"/>
	<div class="login_check_label">是否以管理员登入</div><br>
	<input class="loginto" type="submit"  value="登入"/><br>
	<input class="register"type="button" value="注册" onclick="window.location.href='register.jsp'"></input>
	</form>
</div>
	<%  
		boolean Continue=true;
		//确认输入正确的验证码  xian判断验证码
			if(session.getAttribute("permitC")!=null){
				String permitC =  (String)session.getAttribute("permitC");
				if(permitC.equals("No")){
					out.println("<script> alert(\"对不起，验证码输入错误\"); </script>");
					Continue=false;
				}
			}
        //确认账号密码
		if(session.getAttribute("permit")!=null&&session.getAttribute("permit").toString().equals("No")&& Continue){
				out.println("<script> alert(\"对不起，请确认您的账号密码!\"); </script>");
			
		}
		session.setAttribute("permit","Yes");
		session.setAttribute("permitC","Yes");
	%>
</body>
</html>