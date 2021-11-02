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
   			<td colspan='3' align = center >Gallery목록</td>
   		</tr>
   		<tr>
   			<td width = 100></td>
   			<td width = 100>Gallery번호</td>
   		</tr>
   			<% for(int i=1;i<result.size()+1;i++) { %>
   		<tr>
   			<td><%= i %></td>
   			<td><a href ="./GalleryInfoAction.ad?P_NUM=<%=result.get(i-1) %>"><%=result.get(i-1)%></a></td>
   		   	<td width = 50><a href="./GalleryDeleteAction.ad?P_NUM=<%= result.get(i-1) %>">삭제</a></td>
   		</tr>		
   				<% } %>
   	</table>
</body>
</html>