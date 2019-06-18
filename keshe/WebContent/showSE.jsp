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
	}
	.return{
		font-size:24px;
		color:blue;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>车票</title>
</head>
<body>
<center><h1>火车订票系统</h1></center>
<% 	
	int length=0;
	List<SE> allSE=(List<SE>)session.getAttribute("allSE");
	List<Time> sTime=(List<Time>)session.getAttribute("sTime");
	List<Time> eTime=(List<Time>)session.getAttribute("eTime");
	List<TT> tt=(List<TT>)session.getAttribute("tt");
	String url=null,url1=null;
	if(allSE!=null)
		length=allSE.size();
	int i=0;
	int price=0;
%>
<div class=show><a class="return" href="main.jsp">返回</a>
	<table align="center" width="90%"border="1px" cellspacing="0" cellpadding="0">
		<tr class="type">
			<td>始末Id</td>
			<td>车次</td>
			<td>列车号</td>
			<td>起点</td>
			<td>终点</td>
			<td>发车时间</td>
			<td>到站时间</td>
			<td>总路程(Km)</td>
			<td>票价(¥)</td>
			<td>余票</td>
			<td>时刻表</td>
			<td>购买</td>
		</tr>	
<%
	while(i<length){
		price=allSE.get(i).getSE_total()/4;
		url="mainAction!SE_showTime?TT_id="+sTime.get(i).getTT_id();
		url+="&sId="+sTime.get(i).getTim_id()+"&eId="+eTime.get(i).getTim_id();
		url1="mainAction!buyTicket?TT_id="+sTime.get(i).getTT_id()+"&SE_id="+allSE.get(i).getSE_id();
		url1+="&Tic_price="+price;
		session.setAttribute("time", sTime.get(i).getTim_start().substring(0,11));
		session.setAttribute("start_sta", sTime.get(i).getTim_sta_name());
		session.setAttribute("end_sta", eTime.get(i).getTim_sta_name());
%>			
		<tr >
			<td><%=allSE.get(i).getSE_id()   %></td>
			<td><%=sTime.get(i).getTT_id()   %></td>
			<td><%=tt.get(i).getTra_id()  %></td>
			<td><%=sTime.get(i).getTim_sta_name() %></td>
			<td><%=eTime.get(i).getTim_sta_name() %></td>
			<td><%=sTime.get(i).getTim_start().substring(0,16) %></td>
			<td><%=eTime.get(i).getTim_end().substring(0,16) %></td>
			<td><%=allSE.get(i).getSE_total() %></td>
			<td><%=price %></td>
			<td><%=tt.get(i).getTT_leftSeat() %></td>
<%		
		out.println("<td><button><a href="+url+">时刻表</a></button></td>");
		if(tt.get(i).getTT_leftSeat()>0)
			out.println("<td><button><a href="+url1+">购买</a></button></td></tr>");
		else
			out.println("</tr>");
		i++;
	}
		out.println("</table>");
%>
</div>
</body>
</html>