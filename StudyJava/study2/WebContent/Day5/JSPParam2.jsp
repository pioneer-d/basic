<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>
	
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	%>
	<!-- h2, h3 이런것들은 알아서 <br>처리가 되어있다.  -->
	<h2>Forward를 통해 넘어온 JSPParam2페이지 입니다</h2>
	<h2>Param태그를 통해 넘어온 데이터를 확인하시오</h2>
	id : <%=id %><br>
	pw : <%=pw %>
</body>
</html>