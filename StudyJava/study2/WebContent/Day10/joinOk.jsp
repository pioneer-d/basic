<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id = "dto" class = "com.javalec.ex.Day10.MemeberDTO"/>
<jsp:setProperty name = "dto" property = "*"/>
<%
	dto.setrDate(new Timestamp(System.currentTimeMillis()));

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>