<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP���� ǥ���� �ۼ� ����</title>
</head>
<body>

	<%!
	int i = 10;
	String str = "test";

	public int sum(int a, int b) {
		return a + b;
	}%>

	<%-- �̷������� ����Ѵ�. ������� String�̰�, ';'�� ����� �� ����. --%>
	<%= i %><br>
	<%= str %><br>
	<%= sum(1,5) %>
</body>
</html>