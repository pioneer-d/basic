<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- ���⼭ ���̸��� ���Ƿ� �������ְ�, �ش� Ŭ������ ������ش�. --%>    
<jsp:useBean id = "student" class = "com.javalec.ex.Day7StudentBean" scope = "page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>

	<%-- setProperty�� ����Ͽ� ������ �Է��ϱ� --%>
	<jsp:setProperty property="name" name="student" value = "��â��"/>
	<jsp:setProperty property="age" name="student" value = "24"/>
	<jsp:setProperty property="grade" name="student" value = "2"/>
	<jsp:setProperty property="studentNum" name="student" value = "10"/>
	
	�̸� : <jsp:getProperty property="name" name="student"/><br>
	���� : <jsp:getProperty property="age" name="student"/><br>
	�г� : <jsp:getProperty property="grade" name="student"/><br>
	��ȣ : <jsp:getProperty property="studentNum" name="student"/>

</body>
</html>