<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page errorPage="ErrorPageControl.jsp"%>
<!-- 이런식으로 에러가 날 경우 보낼 페이지 지시자로 지정. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>

	<%
		int i = 40/0;
		//여기서 에러코드 500번 에러가 날것이다. 그럼 ErrorPageControl.jsp로 이동.
	
	%>


</body>
</html>