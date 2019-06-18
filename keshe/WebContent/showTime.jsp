<%@ page language="java" import="java.util.List,table.*" contentType="text/html; charset=utf-8"
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
		text-top:30px;
		text-align:center;
		font-size:20px;
		top:25%;
		left:50%;
		margin:-100px 0 0 -600px;
		width:1200px;
		height:600px;
		border:0px solid #008800;
  		background-color: #fff;
  		font-size:24px;
	}
	.return{
		font-size:24px;
		color:blue;
	}
	.mark{
		color:red;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>时刻表</title>
</head>
<body>
<center><h1>火车订票系统</h1></center>
<%
	List<Time> Time=(List<Time>)session.getAttribute("Time");
	String back=(String )session.getAttribute("back");
	int length=0; 
	if(Time!=null)
		length=Time.size();
	int i=0;
%>
<div class=show><a class="return" href=<%=back %>>返回</a>
	<table align="center" width="90%"border="1px" cellspacing="0" cellpadding="6">
		<tr class="type">
			<td>车次</td>
			<td>站次序<span class="mark">(999为末站)</span></td>
			<td>站名</td>
			<td>发车时间</td>
			<td>到站时间</td>
			<td>距离上一站路程路程(Km)</td>
		</tr>	
<%
	while(i<length){
%>	
		<tr >
			<td><%=Time.get(i).getTT_id()  %></td>
			<td><%=Time.get(i).getTim_seq()   %></td>
			<td><%=Time.get(i).getTim_sta_name()   %></td>
			<td><%=Time.get(i).getTim_start().substring(0, 16)   %></td>
			<td><%=Time.get(i).getTim_end().substring(0, 16)   %></td>
			<td><%=Time.get(i).getTim_distance()   %></td>
		</tr>
		
<%		
	i++;
	}
		out.println("</table>");
%>
</div>
</body>
</html>