<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ũ��Ʈ�� �ڵ� ����</title>
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
		}	//�� �߰�ȣ�� while���� �߰�ȣ�̴�. �� ��ũ��Ʈ���� ������ ������ �̾��� �� �ִٴ� ��.
	%>


</body>
</html>