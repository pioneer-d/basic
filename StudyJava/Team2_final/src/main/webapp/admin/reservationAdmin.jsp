<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList result = (ArrayList) request.getAttribute("list");	//include이기 떄문에 param을 안해도 된다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<td colspan='3' align=center>예약목록</td>
		</tr>
		<tr>
			<td width=100></td>
			<td width=200>예약번호</td>
		</tr>
		<% for(int i=1;i<result.size()+1;i++) { %>
		<tr>
			<td><%= i %></td>
			<td><a href ="./ReservationInfoAction.ad?RESERVATION_NUM=<%=result.get(i-1) %>"><%=result.get(i-1)%></a></td>
			<td width=50><a href="./ReservationDeleteAction.ad?RESERVATION_NUM=<%= result.get(i-1) %>">삭제</a></td>
		</tr>
		<% } %>
		<tr>
			<td colspan='3' align=center>
			<a href = "./ReservationAddJsp.ad">추가하기</a>
			</td>
		</tr>
	</table>

</body>
</html>