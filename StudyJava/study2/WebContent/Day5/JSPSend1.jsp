<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>

	<%
		String sAge = request.getParameter("age");	
	%>
	����� ���̴�<%=sAge %>�� �Դϴ�.
	<br> �ַ� ���� �� �� �ֽ��ϴ�.
	<br>
	<a href="JSPRequest.jsp">ó������ �̵��ϱ�.</a>

</body>
</html>