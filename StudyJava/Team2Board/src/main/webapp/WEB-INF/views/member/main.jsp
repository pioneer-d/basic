<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<br>

<%
	request.setCharacterEncoding("UTF-8");
	String admin = "관리자";
	String nick = (String)session.getAttribute("nick");	//저장된 세션 값 불러오기
		//관리자 모드 일때 모든 데이터들을 가져온다.
		 
		if(nick.equals(admin)){%>
	
			<h2>관리자로 로그인 하셨습니다.</h2><br><br>
			<h3><a href="memberList">회원관리</a></h3>	<!-- 여기 해야됨 -->
			<h3><a href = "../board/list">게시판 가기</a></h3>
			
		<% }else{
			%>
			<h2><%= nick %>님이 로그인 하셨습니다.</h2><br><br>
			<h3><a href = "../board/list">게시판 가기</a></h3>
		<%} %>


</body>
</html>