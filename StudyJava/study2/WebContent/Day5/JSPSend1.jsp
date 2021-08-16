<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>

	<%
		String sAge = request.getParameter("age");	
	%>
	당신의 나이는<%=sAge %>세 입니다.
	<br> 주류 등을 살 수 있습니다.
	<br>
	<a href="JSPRequest.jsp">처음으로 이동하기.</a>

</body>
</html>