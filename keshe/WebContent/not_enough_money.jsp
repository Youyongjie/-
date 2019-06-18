<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body{
		background:url("img/background.jpg")
	}
	.show{
		position:absolute;
		text-top:100px;
		text-align:center;
		font-size:50px;
		top:40%;
		left:50%;
		margin:-30px 0 0 -200px;
		width:400px;
		height:200px;
		border:0px solid #008800;
  		background-color: #fff;
	}
	.return{
		position:absolute;
		left:800px;
		top:250px;
		font-size:24px;
		color:blue;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>余额不足</title>
</head>
<body>
<center><h1>火车订票系统</h1></center>
<a class="return" href="main.jsp">返回</a>
<div class="show">对不起你的余额不足</div>
</body>
</html>