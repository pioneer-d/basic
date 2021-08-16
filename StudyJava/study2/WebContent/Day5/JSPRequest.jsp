<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>
	<%-- sendRedirect의 활용 --%>
	<form action="JSPSend.jsp">
	당신의 나이는? <input type = "text" name = "age" size = "5">
	<input type = "submit" value = "제출">
	</form>
</body>
</html>