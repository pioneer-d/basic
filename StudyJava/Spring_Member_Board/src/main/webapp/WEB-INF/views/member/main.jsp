<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	일반사용자면 자기 정보 볼 수 있는 페이지
	<br>
	<a href = "board/main">게시판으로 가기</a>	<!-- 이렇게 하면 member/board/main 이렇게 되어버림. 문제발생 예상 -->
	<a href = "myInfo">내정보 확인</a>
	<br>
	관리자면 사용자 관리할 수 있는 페이지
	<br>
	<a href = "memberInfo">사용자 관리</a>
</body>
</html>