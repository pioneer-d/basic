<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>

	<%
		//��Ű ��ü�� ����� �Ű����� ���� ��Ű�� �̸�, �ڰ� ��Ű�� ��.
		Cookie cookie = new Cookie("cookieN","cookieV");
		cookie.setMaxAge(60*60);	//��Ű�� �����ð� (1�ð��̴�.)	�� �ð��� 0���� �ϸ� ��Ű ������ ����.
		response.addCookie(cookie);
		
	%>
	
	<a href = "CookieGet.jsp">��Ű �ѱ��</a>

</body>
</html>