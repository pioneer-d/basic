<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>스크립트릿 코드 예제</title>
</head>
<body>
	
	<%
		int i = 0;
		while(true){
			i++;
			out.println("2 *"+i+"="+(2 * i)+"<br>");
		
	%>
	<br>
	<%
		if(i == 9)break;
		}	//이 중괄호는 while문의 중괄호이다. 즉 스크립트릿이 여러번 열려도 이어질 수 있다는 뜻.
	%>


</body>
</html>