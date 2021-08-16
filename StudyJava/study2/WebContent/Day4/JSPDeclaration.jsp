<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP에서 자바코드 선언 예제</title>
</head>
<body>

<!-- 이때 선언한 자바코드는 전역으로 사용된다. -->
<%!
	int i = 10;
	String str = "test";
%>
<%!
	public int sum(int a, int b){
	return a+b;
}
%>

<%
	out.println("i : "+i+"<br>");
	out.println("str : "+str+"<br>");
	out.println("sum : "+sum(1,2)+"<br>");
%>

</body>
</html>