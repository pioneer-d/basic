<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>
	<%-- jsp의 forward 활용예시 --%>
	지금 이 글은 페이지에 보여지지 않는다. forward를 사용하면 URL주소는 그대로 유지하되, 페이지만 이동한다.
	<jsp:forward page="JSPForward2.jsp"/>

</body>
</html>