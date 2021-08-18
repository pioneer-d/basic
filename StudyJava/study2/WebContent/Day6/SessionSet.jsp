<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>

	<%
		session.setAttribute("sessionN", "sesstionV");
		session.setAttribute("sessionN2",12345);
	%>

	<a href = "SessionGet.jsp">세션 넘기기</a>
</body>
</html>