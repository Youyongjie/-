<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	.register{
		position:absolute;
		text-top:20px;
		text-align:center;
		top:40%;
		left:50%;
		margin:-150px 0 0 -200px;
		width:400px;
		height:370px;
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
    .su_label {
    	float: left;
        margin-left: 40px;
        font-family: "Microsoft yahei";
        font-size: 14px;
        color: #999999;
        line-height: 14px;
    }
</style>

<meta http-equiv="utf-8" content="text/html; charset=utf-8">
<title>火车订票系统</title>
</head>
<body>
<center><h1>火车订票系统</h1></center>
	<div class="register">
	<form action="userAction!register" method="get">
	  	<input class="common"type="text"   name="user.User_name" placeholder="用户名" /><br/>
	  	<input class="common"type="text"   name="user.User_pass" placeholder="密码" /><br/>				<!-- todo -->
		<input class="common"type="text"   name="user.User_sex" placeholder="性别" /><br/>
		<input class="common"type="text"   name="user.balance" placeholder="初始金额" /><br/>
		<input class="common"type="text"   name="user.User_email" placeholder="邮箱"/><br/>
		<input class="common"type="text"   name="user.User_telenum" placeholder="手机号码" /><br/>  		<!-- todo -->
		<input class="common"type="text"   name="user.User_idcard" placeholder="身份证号" /><br/>
		<input type="checkbox" name="user.User_su" />
		<div class="su_label">是否为管理员</div><br><br/>
		<input class="common"type="submit" value="注册"/>
	</form>
	</div>
</body>
</html>