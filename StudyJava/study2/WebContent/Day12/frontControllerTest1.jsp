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
	
	<!-- request.getContextPath() == /study2�� �ǹ���.
		 update,delete�� �տ� ��Ű���� Day12�� ����
		 insert,select�� �տ� ��Ű���� Day12�� �ִ�.
		 �̶�, insert�� select�� command������ ó���� �� �տ� ��Ű������ �ٿ���� �Ѵ�. -->
	
	<hr>
	<a href = "http://localhost:8181/study2/Day12/select.do">select</a>
	<hr>
	<a href = "<%=request.getContextPath() %>/delete.do">delete</a>
</body>
</html>