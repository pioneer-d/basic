<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<%
	Object getId = session.getAttribute("id");
	String id = (String)getId;
	
	Object getPw = session.getAttribute("pw");
	String pw = (String)getPw;
	
	Object getName = session.getAttribute("name");
	String name = (String)getName;
	
	//String name = (String)session.getAttribute("name"); 이렇게 한번에 ㄱㄱ
%>

	<h2><%=name %>님 환영합니다</h2><br>
	<a href = "modify.jsp">정보 수정하기</a>

</body>
</html>