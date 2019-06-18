<%@ page language="java" import="java.util.*,table.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	body{
		background:url("img/background.jpg")
	}
	.register{
		position:absolute;
		text-top:20px;
		text-align:left;
		top:40%;
		left:50%;
		margin:-150px 0 0 -400px;
		width:800px;
		height:260px;
		border:0px solid #008800;
  		background-color: #fff;
  		font-size:24px;
  		opacity:0.85;
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
    .return{
   		 position:absolute;
		font-size:24px;
		color:blue;
		left:40%;
		top:15%;
	}
 
</style>

<meta http-equiv="utf-8" content="text/html; charset=utf-8">
<title>火车订票系统</title>
</head>
<body>
<% 
	User user=(User)session.getAttribute("User");
%>
<center><h1>火车订票系统</h1></center>
<div class="return"><a href="main.jsp">返回</a></div>
	<div class="register">
		<table border="1px" align="center" width="100%">
			<tr>
				<td>用户名</td><td><%=user.getUser_name() %></td>
			</tr>
			<tr>
				<td>性别</td><td><%=user.getUser_sex() %></td>
			</tr>
			<tr>
				<td>电话号码</td><td><%=user.getUser_telenum()  %></td>
			</tr>
			<tr>
				<td>身份证号</td><td><%=user.getUser_idcard() %></td>
			</tr>
			<tr>
				<td>账户余额</td><td><%=user.getBalance() %></td>
			</tr>
			<tr>
				<td>是否为管理员</td><td><%=user.getUser_su().contains("on")?"是":"否" %></td>
			</tr>
			<tr>
				<td>邮箱</td><td><%=user.getUser_email() %></td>
			</tr>
		</table>
	</div>
</body>
</html>