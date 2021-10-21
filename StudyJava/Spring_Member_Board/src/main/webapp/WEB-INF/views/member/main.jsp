<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String m_Id = (String)session.getAttribute("m_Id");
	%>
	<%
		if(m_Id == null){%>
	<script>
		alert("존재하지 않는 아이디거나 비밀번호가 일치하지 않습니다");		<%-- 로그인 실패시 --%>
		history.back();
	</script>
	<%}else if(m_Id.equals("admin")){%>
		<h1>관리자님 환영합니다</h1>								<%-- 관리자 로그인시 --%>
		<a href = "board/list">게시판으로 가기</a>	<!-- 이렇게 하면 member/board/main 이렇게 되어버림. 문제발생 예상 -->
		<a href = "memberInfo">사용자 관리</a>
	<%}else{%>
		<h1><%=m_Id%>님 환영합니다</h1>							<%-- 일반사용자 로그인시 --%>
		<a href = "board/list">게시판으로 가기</a>	<!-- 이렇게 하면 member/board/main 이렇게 되어버림. 문제발생 예상 -->
		<a href = "myInfo">내정보 확인</a>
	<%}%>
	
</body>
</html>