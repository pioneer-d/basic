<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage = "true" %>
<!-- ����� ������ ����ó���� �� jsp��� ���� ���! �⺻���� false�̴�. true�� ���� ������ ����ó������ �޼ҵ带 ����� �� ����. -->
<% response.setStatus(200); %>
<!-- �̷��� �����ڵ� ����. �̰��� ������������ �ƴϹǷ� �� �����������. -->
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	������ ���� �̰����� ����ó���� ����.
	<br>
	<%= exception.getMessage() %>

</body>
</html>