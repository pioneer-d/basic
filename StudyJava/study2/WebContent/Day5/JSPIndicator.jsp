<%@ page import = "java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>
	
	<%-- JSP�� �����ڸ� ����ϴ� ���� --%>
	<%
		int[] iArr = {10,20,30};
	out.println(Arrays.toString(iArr));
	%>

</body>
</html>