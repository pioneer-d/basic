<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>

	<%
		//쿠키 객체를 만들어 매개변수 앞이 쿠키의 이름, 뒤가 쿠키기 값.
		Cookie cookie = new Cookie("cookieN","cookieV");
		cookie.setMaxAge(60*60);	//쿠키의 유지시간 (1시간이다.)	이 시간을 0으로 하면 쿠키 삭제와 같다.
		response.addCookie(cookie);
		
	%>
	
	<a href = "CookieGet.jsp">쿠키 넘기기</a>

</body>
</html>