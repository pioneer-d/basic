<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP���� �ڹ��ڵ� ���� ����</title>
</head>
<body>

<!-- �̶� ������ �ڹ��ڵ�� �������� ���ȴ�. -->
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