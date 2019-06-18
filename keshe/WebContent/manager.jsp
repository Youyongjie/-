<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	body{
		background:url("img/background.jpg")
	}
	.manager{
		position:absolute;
		text-top:20px;
		text-align:center;
		top:35%;
		left:50%;
		margin:-100px 0 0 -600px;
		width:1200px;
		height:500px;
		border:1px solid #008800;
  		background-color: #fff;
  		opacity:0.95;
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
        font-size: 30px;
        color: #999999;
        line-height: 14px;
    }
    .info{
    	font-size:24px;
    	color:blue;
    }
    input{
    	font-size:21px;
    }
</style>

<meta http-equiv="utf-8" content="text/html; charset=utf-8">
<title>火车订票系统</title>
</head>
<body>
<div style="text-align:center;font-size:24px;">
管理员:<%=(String) session.getAttribute("user") %>
</div>
	<center><h1>火车订票系统</h1></center>
<h1 align="center">欢迎来到管理界面</h1>
<br/><br/><br/><br/><br/>
	<div class="manager">
		<div class="info">更新列车</div>
		<form id="Train"action="updateAction!updateTrain" method="get">
			<input type="text" name="train.Tra_id" placeholder="列车号">
			<input type="text" name="train.Tra_max" placeholder="列车载客量">
			<input type="text" name="train.Tra_type" placeholder="列车型号">
			<input type="submit" value="增加列车" name="operation">
			<input type="submit" value="显示所有列车"name="operation">
		</form><br/>
		
<div class="info">更新车次</div>
		<form id="TT" action="updateAction!updateTT" method="get">
			<input type="text" name="Tra_id" placeholder="列车号">
		    <input type="date" name="TT_time" placeholder="车次日期">
			<input type="submit" value="增加车次" name="operation">
			<input type="submit" value="显示所有车次"name="operation">
		</form><br/>
		<div class="info">更新时刻表</div>
		<form  id="Time"action="updateAction!updateTime" method="get">
			<input type="text" name="time1.TT_id" placeholder="车次"><br/>
			<input type="text" name="time1.Tim_seq" placeholder="序号">
			<input type="text" name="time1.Tim_sta_name" placeholder="站点名字">
			<input type="text" name="time1.Tim_distance" placeholder="与上一站距离">
			<input type="time" name="time1.Tim_start">
			<input type="time" name="time1.Tim_end"><br/>
			<input type="text" name="time2.Tim_seq" placeholder="序号">
			<input type="text" name="time2.Tim_sta_name" placeholder="站点名字">
			<input type="text" name="time2.Tim_distance" placeholder="与上一站距离">
			<input type="time" name="time2.Tim_start">
			<input type="time" name="time2.Tim_end"><br/>
			<input type="text" name="time3.Tim_seq" placeholder="序号">
			<input type="text" name="time3.Tim_sta_name" placeholder="站点名字">
			<input type="text" name="time3.Tim_distance" placeholder="与上一站距离">
			<input type="time" name="time3.Tim_start">
			<input type="time" name="time3.Tim_end"><br/>
			<input type="text" name="time4.Tim_seq" placeholder="序号">
			<input type="text" name="time4.Tim_sta_name" placeholder="站点名字">
			<input type="text" name="time4.Tim_distance" placeholder="与上一站距离">
			<input type="time" name="time4.Tim_start">
			<input type="time" name="time4.Tim_end"><br/>
			<input type="text" name="time5.Tim_seq" placeholder="序号">
			<input type="text" name="time5.Tim_sta_name" placeholder="站点名字">
			<input type="text" name="time5.Tim_distance" placeholder="与上一站距离">
			<input type="time" name="time5.Tim_start">
			<input type="time" name="time5.Tim_end"><br/>
			<input type="submit" value="增加时刻表" name="operation">
			<input type="submit" value="显示所有时刻车次表" name="operation">
		</form><br/>
	</div>
</body>
</html>