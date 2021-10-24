<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- c:foreach인식하기 위해 taglib이거 써주자!!!!  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	window.onload = alert('삭제할 권한이 없습니다.');
</script>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>번호</td>
		<td>닉네임</td>
		<td>제목</td>
		<td>날짜</td>
		<td>히트</td>
	</tr>
	<c:forEach items="${list}" var="dto">	<!-- AllayList출력 역할. jstl -->
	<tr>
		<td>${dto.BOARD_NUM}</td>
		<td>${dto.MEMBER_NICK}</td>
		<td>
			<c:forEach begin="1" end="${dto.BOARD_INDENT}">-</c:forEach> <!-- indent값 만큼 -가 추가되는듯? -->
			<a href="content_view?BOARD_NUM=${dto.BOARD_NUM}">${dto.BOARD_TITLE}</a></td>
		<td>${dto.BOARD_DATE}</td>
		<td>${dto.BOARD_HIT}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan ="5"> <a href="write_view">글작성</a> &nbsp <a href="../member/login">로그아웃</a></td>
	</tr>
	</table>
</body>
</html>