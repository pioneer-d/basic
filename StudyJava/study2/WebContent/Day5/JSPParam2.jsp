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
	<!-- h2, h3 �̷��͵��� �˾Ƽ� <br>ó���� �Ǿ��ִ�.  -->
	<h2>Forward�� ���� �Ѿ�� JSPParam2������ �Դϴ�</h2>
	<h2>Param�±׸� ���� �Ѿ�� �����͸� Ȯ���Ͻÿ�</h2>
	id : <%=id %><br>
	pw : <%=pw %>
</body>
</html>