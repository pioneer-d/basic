<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="member" class = "com.javalec.ex.Day11.MemberInfo" scope = "page"></jsp:useBean>
<jsp:setProperty name = "member" property = "name" value = "���ؿ�"/>
<jsp:setProperty name = "member" property = "id" value = "qwe"/>
<jsp:setProperty name = "member" property = "pw" value = "qwe123"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	EL�±� ���X<br>
<jsp:getProperty property="name" name="member"/><br>
<jsp:getProperty property="id" name="member"/><br>
<jsp:getProperty property="pw" name="member"/><br>

	EL�±� ���O<br>
${member.name }<br>
${member.id }<br>
${member.pw }<br>

	EL�±׸� Ȱ���� �ʱ�ȭ �Ķ����(initParam)�ҷ�����<br>

${initParam.id }<br>
${initParam.pw }


</body>
</html>