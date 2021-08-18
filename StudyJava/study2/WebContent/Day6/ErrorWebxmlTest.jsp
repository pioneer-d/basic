<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>
<%--web.xml에 오류코드 500번이 나올 시 어디로 가라고 지정해놓은 상태이다.(예외처리를 했다 --%>

	<%
		int i = 40/0;
	%>

</body>
</html>