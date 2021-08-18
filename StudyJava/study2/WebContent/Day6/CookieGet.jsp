<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>

	<%
		Cookie[] cookie = request.getCookies();	//쿠키값을 받음.
		
		for(int i = 0; i<cookie.length; i++){
			out.println(cookie[i].getName());
			out.println(cookie[i].getValue());
		}
	%>
	
		

</body>
</html>