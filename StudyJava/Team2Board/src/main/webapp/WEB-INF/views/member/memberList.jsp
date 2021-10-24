<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border=1>
			<tr>
				<td colspan='2'>회원 목록</td>
			</tr>
			<c:forEach items="${list}" var="dto">	<!-- 리스트 받아오기 -->
			<tr>
				<td>${dto.MEMBER_NICK}</td>
				<td><a href="memberDelete?MEMBER_NICK=${dto.MEMBER_NICK}">삭제</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan = "2"><a href = "login">로그아웃</a>
			</tr>
		</table>
	</div>
</body>
</html>