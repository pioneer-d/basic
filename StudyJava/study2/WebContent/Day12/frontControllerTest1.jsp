<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<a href = "insert.do">insert</a>
	<hr>
	<a href = "http://localhost:8181<%=request.getContextPath() %>/update.do">update</a>
	
	<!-- request.getContextPath() == /study2를 의미함.
		 update,delete는 앞에 패키지명 Day12가 없고
		 insert,select는 앞에 패키지명 Day12가 있다.
		 이때, insert와 select는 command에따라 처리할 때 앞에 패키지명을 붙여줘야 한다. -->
	
	<hr>
	<a href = "http://localhost:8181/study2/Day12/select.do">select</a>
	<hr>
	<a href = "<%=request.getContextPath() %>/delete.do">delete</a>
</body>
</html>