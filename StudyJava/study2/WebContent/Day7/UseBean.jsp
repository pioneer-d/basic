<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 여기서 빈이름을 임의로 지정해주고, 해당 클래스를 명시해준다. --%>    
<jsp:useBean id = "student" class = "com.javalec.ex.Day7StudentBean" scope = "page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>

	<%-- setProperty를 사용하여 데이터 입력하기 --%>
	<jsp:setProperty property="name" name="student" value = "정창근"/>
	<jsp:setProperty property="age" name="student" value = "24"/>
	<jsp:setProperty property="grade" name="student" value = "2"/>
	<jsp:setProperty property="studentNum" name="student" value = "10"/>
	
	이름 : <jsp:getProperty property="name" name="student"/><br>
	나이 : <jsp:getProperty property="age" name="student"/><br>
	학년 : <jsp:getProperty property="grade" name="student"/><br>
	번호 : <jsp:getProperty property="studentNum" name="student"/>

</body>
</html>