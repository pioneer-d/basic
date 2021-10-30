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
<%
	String session_Id = (String)session.getAttribute("m_Id");
%>
<form action = "reply" method = "post">
	<table width="500" cellpadding="0" cellspacing="0" border="1">
			<input type = "hidden" name = "b_Group" value = "${data.b_Group}">
			<input type = "hidden" name = "b_Indent" value = "${data.b_Indent}">
			<input type = "hidden" name = "b_Step" value = "${data.b_Step}">
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="m_Id" value="<%=session_Id%>" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="b_Title" value="${data.b_Title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="b_Content">${data.b_Content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type = "submit" value = "답변완료">
					&nbsp;&nbsp; <a href="list">목록보기</a> &nbsp;&nbsp; 
			</tr>
	</table>
</form>
</body>
</html>