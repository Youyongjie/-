<%@ page language="java" import="java.util.List,table.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	
	.show{
		position:absolute;
		text-top:20px;
		text-align:center;
		top:20%;
		left:50%;
		margin:-100px 0 0 -600px;
		width:1200px;
		height:500px;
		border:0px solid #008800;
  		background-color: #fff;
  		font-size:26px;
  		
	}
	.type{
		font-size:24px;
	}
	a{
		color:black;
	}
	.return{
		font-size:24px;
		color:blue;
	}
	
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示</title>
</head>
<body>
<center><h1>火车订票系统</h1></center>
<div class="show"><a class="return" href="manager.jsp">返回</a>
<%	
	String url=null,url1=null;
	int length=0; 
	String table=request.getParameter("table");
	if(table.equals("Train")){
		List<Train> allTrain= (List<Train>)session.getAttribute("allTrain");
		if(allTrain!=null)
			length=allTrain.size();
%>
	<table align="center" width="70%"border="1px" cellspacing="0" cellpadding="10">
	<tr class="type">
		<td>列车号</td>
		<td>列车型号</td>
		<td>最大载客量</td>
		<td>删除</td>
	</tr>	
<%
		while(length--!=0){
			url="updateAction!updateTrain?operation=删除列车&Tra_id="+allTrain.get(length).getTra_id();
%>
		<tr >
			<td><%=allTrain.get(length).getTra_id() %></td>
			<td><%=allTrain.get(length).getTra_type() %></td>
			<td><%=allTrain.get(length).getTra_max() %></td>
	
<%
			out.println("<td><button><a href='"+url+"'>删除</a></button></td></tr>");
		}
		out.println("</table>");
	}else if(table.equals("TT")){
		List<TT> allTT= (List<TT>)session.getAttribute("allTT");
		if(allTT!=null)
			length=allTT.size();		
%>
		<table align="center" width="70%"border="1px" cellspacing="0" cellpadding="10">
		<tr class="type">
			<td>车次ID</td>
			<td>列车号</td>
			<td>车次时间</td>
			<td>删除</td>
		</tr>	
<%
		while(length--!=0){
			url="updateAction!updateTT?operation=删除车次&TT_id="+allTT.get(length).getTT_id();
%>
			<tr >
				<td><%=allTT.get(length).getTT_id() %></td>
				<td><%=allTT.get(length).getTra_id() %></td>
				<td><%=allTT.get(length).getTT_time().substring(0,11) %></td>
<%
			out.println("<td><button><a href='"+url+"'>删除</a></button></td></tr>");
		}
		out.println("</table>");
	}else if(table.equals("Time")){
		List<Time> SE= (List<Time>)session.getAttribute("SE");
		List<Time> left_Time= (List<Time>)session.getAttribute("SE");
		if(SE!=null)
			length=SE.size();		
%>
		<table align="center" width="100%"border="1px" cellspacing="0" cellpadding="10">
		<tr class="type">
			<td>车次ID</td>
			<td>起点</td>
			<td>终点</td>
			<td>出发时间</td>
			<td>到达时间</td>
			<td>时刻表</td>
			<td>删除</td>
		</tr>	
<%
		int i=0;
		System.out.println(length);
		while(i<length){
			url="updateAction!Time_showTime?TT_id="+SE.get(i).getTT_id();
			url+="&eId="+SE.get(i+1).getTim_id();
			url+="&sId="+SE.get(i).getTim_id();
			url1="updateAction!updateTime?operation=删除车次&TT_id="+SE.get(i).getTT_id();
%>
			<tr >
				<td><%=SE.get(i).getTT_id() %></td>
				<td><%=SE.get(i).getTim_sta_name() %></td>
				<td><%=SE.get(i+1).getTim_sta_name() %></td>
				<td ><%=SE.get(i).getTim_start().substring(0, 19) %></td>
				<td><%=SE.get(i+1).getTim_end().substring(0, 19) %></td>
<%
			i+=2;
			out.println("<td><button><a href='"+url+"'>时刻表</a></button></td>");
			out.println("<td><button><a href='"+url1+"'>删除</a></button></td></tr>");
		}
		out.println("</table>");
	}

%>		

</div>
</body>
</html>