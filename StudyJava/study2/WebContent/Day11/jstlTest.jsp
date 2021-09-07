<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<c:set var = "vatName" value = "valvalue"/>	<!-- 변수 입력 -->
	vatName : <c:out value = "${vatName }"/>
	<br>
	
	<c:remove var = "vatName"/>	<!-- 변수제거 -->
	vatName : <c:out value = "${vatName }"/>
	<br>
	
	<c:catch var = "error">	<!-- 예외처리인듯 하다 -->
		<%=2/0 %>
	</c:catch>	
	<br>
	<c:out value = "${error }"/>
	<br>
	
	<c:if test = "${1+2 == 3 }">	<!-- 조건문 -->
		1 + 2 = 3
	</c:if>
	<c:if test = "${1+2 != 3 }">
		1 + 2 != 3
	</c:if>
	<br>
	
	<c:forEach var = "fEach" begin = "0" end = "30" step = "3">		<!-- 반복문 -->
		${fEach }
	</c:forEach>

</body>
</html>