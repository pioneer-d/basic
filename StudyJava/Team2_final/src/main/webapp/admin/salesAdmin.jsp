<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%> 
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList result = (ArrayList) request.getAttribute("list");	//include이기 떄문에 param을 안해도 된다.
	ArrayList result2 = (ArrayList) request.getAttribute("list2");
	int sum=0; 
	for(int i = 0 ; i < result.size(); i++){ 
		
		sum += Integer.parseInt(String.valueOf(result.get(i))); 
		}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <table border=1>
   		<tr>
   			<td colspan='3' align = center >매출목록</td>
   		</tr>
   		<tr>
   			<td width = 200>날짜</td>
   			<td width = 100>금액</td>
   		</tr>
   			<% for(int i=1;i<result.size()+1;i++) { %>
   		<tr>
   			<td><%=result2.get(i-1)%></td>
   			<td><%=result.get(i-1)%></td>
   		</tr>		
   				<% } %>
    	<tr>
   			<td>총합</td>
   			<td><%= sum %></td>
   		</tr>  				
   	</table>
</body>
</html>