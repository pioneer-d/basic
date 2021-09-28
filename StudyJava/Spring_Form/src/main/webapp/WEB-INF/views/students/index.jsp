<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action = "student" method ="post">
		student name : <input type = "text" name = "name">	<!-- 이때 name이 controller에서 parameter로 쓰일 값. -->
		<hr>								<!-- 이때 name이 아닌 id로 하면 안됨! -->
		<input type = "submit" value = "제출">
	</form>

</body>
</html>