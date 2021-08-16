<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP에서 표현식 작성 예제</title>
</head>
<body>

	<%!
	int i = 10;
	String str = "test";

	public int sum(int a, int b) {
		return a + b;
	}%>

	<%-- 이런식으로 출력한다. 결과값은 String이고, ';'를 사용할 수 없다. --%>
	<%= i %><br>
	<%= str %><br>
	<%= sum(1,5) %>
</body>
</html>