<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- c:foreach�ν��ϱ� ���� taglib�̰� ������!!!!  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	window.onload = alert('������ ������ �����ϴ�.');
</script>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>��ȣ</td>
		<td>�г���</td>
		<td>����</td>
		<td>��¥</td>
		<td>��Ʈ</td>
	</tr>
	<c:forEach items="${list}" var="dto">	<!-- AllayList��� ����. jstl -->
	<tr>
		<td>${dto.BOARD_NUM}</td>
		<td>${dto.MEMBER_NICK}</td>
		<td>
			<c:forEach begin="1" end="${dto.BOARD_INDENT}">-</c:forEach> <!-- indent�� ��ŭ -�� �߰��Ǵµ�? -->
			<a href="content_view?BOARD_NUM=${dto.BOARD_NUM}">${dto.BOARD_TITLE}</a></td>
		<td>${dto.BOARD_DATE}</td>
		<td>${dto.BOARD_HIT}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan ="5"> <a href="write_view">���ۼ�</a> &nbsp <a href="../member/login">�α׾ƿ�</a></td>
	</tr>
	</table>
</body>
</html>