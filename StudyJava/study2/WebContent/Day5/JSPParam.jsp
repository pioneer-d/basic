<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- �׼��±� �� forward�� param�� ���� ������ �ѱ�� --%>
	<jsp:forward page="JSPParam2.jsp">
		<jsp:param value="qwe" name="id"/>
		<jsp:param value="qwe123" name="pw"/>
	</jsp:forward>

</body>
</html>