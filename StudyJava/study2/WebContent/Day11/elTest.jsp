<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	표현식, 액션태그를 EL태그로 간편하게 대체한다.<br>

	<%=1+2 %>	<br>
	<%=1*3 %>	<br>
	<%=1/2 %>	<br>
	<%=1 == 2 %>
	
	${1+2}<br>	
	${1*3}<br>
	${1/2}<br>
	${1==2}<br>
</body>
</html>