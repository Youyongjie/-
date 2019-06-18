<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	body{
		background:url("img/background.jpg")
	}
	.search{
		position:absolute;
		text-top:20px;
		text-align:center;
		top:40%;
		left:50%;
		margin:-150px 0 0 -350px;
		width:700px;
		height:360px;
		border:1px solid #008800;
  		background-color:#D4D4D4;
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
    .title{
    	font-size:24px;
    	color:blue;
    }
    .info{
    	font-size:28px;
    }
    .search_btn{
      margin:center;
      width: 320px;
      height: 46px;
      font-size: 20px;
      font-family: "Microsoft YaHei";
      border-radius: 4px;
      border: none;
      background-color: #009dff;
    }
</style>

<meta http-equiv="utf-8" content="text/html; charset=utf-8">
<title>火车订票系统</title>
</head>
<body>
<div style="text-align:center;font-size:24px;">
用户:<%=(String) session.getAttribute("user") %>
<a style="color:red;" href="mainAction!info">个人中心</a>
<a style="color:red;" href="mainAction!bought">已购车票</a>
</div>
<center><h1>火车订票系统</h1></center>
<div class="search">
<form action="mainAction!search" method="get">
	<div class="title">车票查询</div><br/>
	<input style="width: 250px;height:30px;font-size:24px;"type="date" name="time"/><br/><br>
	
	<input class="common"type="text" list="itemlist" name="start_sta" placeholder="起点"/>
	<!-- //datalist的id要与list属性名称一致 -->
	<datalist id="itemlist">
    	<option>福州</option>
    	<option>厦门</option>
    	<option>泉州</option>
    	<option>仙游</option>
    	<option>莆田</option>
    	<option>宁德</option>
	</datalist>
	<input class="common"type="text" list="itemlist1" name="end_sta" placeholder="终点"/>
	<!-- //datalist的id要与list属性名称一致 -->
	<datalist id="itemlist1">
    	<option>福州</option>
    	<option>厦门</option>
    	<option>泉州</option>
    	<option>仙游</option>
    	<option>莆田</option>
    	<option>宁德</option>
	</datalist><br><br><br><br>
	<input class="search_btn" type="submit" value="搜索"/>
</form>	
</div>
</body>
</html>