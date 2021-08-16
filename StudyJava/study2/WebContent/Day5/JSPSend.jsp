<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>
	
	<%! int age; %>

	<% 
	String sAge = request.getParameter("age");
	age = Integer.parseInt(sAge);
	%>
	
	<%
	
	if(age >= 20){	//이때 ?뒤로 입력하는 것이 전송 할 데이터이다. URL에는 나이가 보여지는데,(get방식으로) 왜 request.getParameter로 하면 null이지?
		response.sendRedirect("JSPSend1.jsp?age = "+age);
	}else if(age <20){
		response.sendRedirect("JSPSend2.jsp?age = "+age);
	}
	
	
	%>

</body>
</html>