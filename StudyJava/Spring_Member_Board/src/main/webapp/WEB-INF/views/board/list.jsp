<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String m_Id = (String)session.getAttribute("m_Id");
	%>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>��ȣ</td>
			<td>���̵�</td>
			<td>����</td>
			<td>��¥</td>
			<td>��Ʈ</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.b_Num}</td>
				<td>${dto.m_Id}</td>
				<td><c:forEach begin="1" end="${dto.b_Indent}">-</c:forEach>
					<a href="?b_Num=${dto.b_Num}">${dto.b_Title}</a></td>
				<td>${dto.b_Date}</td>
				<td>${dto.b_Hit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write">���ۼ�</a> &nbsp <a
				href="../member/login">�α׾ƿ�</a></td>
		</tr>
	</table>
</body>
</html>