<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = alert('아이디, 비밀번호가 일치하지 않거나 등록되어 있지 않은 회원입니다..');
</script>
</head>
<body>
	<form action = "loginCommand" method = "post">
		<div align = center>
		<table border = 1>
			<tr>
				<td colspan = 2 align = center><h3>로그인창</h3></td>
			</tr>
			
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "id"></td>	
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "pwd"></td>
			</tr>
			
			<tr>
				<td colspan = 2 align = center>
				<input type = "submit" value = "로그인">	
				<a href = "joinForm">회원가입</a>
			</tr>
		</table>
		</div>
	</form>
</body>
</html>
