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
	
	if(age >= 20){	//�̶� ?�ڷ� �Է��ϴ� ���� ���� �� �������̴�. URL���� ���̰� �������µ�,(get�������) �� request.getParameter�� �ϸ� null����?
		response.sendRedirect("JSPSend1.jsp?age = "+age);
	}else if(age <20){
		response.sendRedirect("JSPSend2.jsp?age = "+age);
	}
	
	
	%>

</body>
</html>