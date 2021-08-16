<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>
	
	<%-- include지시자를 통해 다른 JSP페이지를 삽입하는 방식. --%>
	<%-- 소스보기를 하면 JSP가 중간에 삽입된 형태로 나온다. --%>
	<h2> JSPInclude page 입니다.</h2>
	<%@ include file = "JSPInclude01.jsp" %>
	<h2> 다시 JSPInclude page 입니다.</h2>

</body>
</html>