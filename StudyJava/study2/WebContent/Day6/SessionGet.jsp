<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>

	<%
		//먼저 sessio은 Object로 받는다..?
		Object session1 = session.getAttribute("sessionN");
		Object session2 = session.getAttribute("sessionN2");
		
		String strSession = (String)session1;
		int intSession = (Integer)session2;
		
		out.println(strSession + "<br>");
		out.println(intSession);
	%>
	<br>
	<%=strSession %>
	<br>
	<%=intSession %>
		
</body>
</html>