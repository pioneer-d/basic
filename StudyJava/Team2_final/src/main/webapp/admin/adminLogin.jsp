<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action = "./AdminLoginAction.ad" method = "post">
		<div align = center>
		<table border = 1>
			<tr>
				<td colspan = 2 align = center><h3>�α���â</h3></td>
			</tr>
			
			<tr>
				<td>���̵�</td>
				<td><input type = "text" name = "id" id = 'id'></td>	<!-- �̰��� session���� ������ ����. -->
			</tr>
			
			<tr>
				<td>��й�ȣ</td>
				<td><input type = "password" name = "pwd" id = "pwd"></td>
			</tr>
			
			<tr>
				<td colspan = 2 align = center>
				<input type = "submit" value = "�α���" >
				<button onclick="history.back()">�ڷΰ���</button>
			</tr>
		</table>
		</div>
	</form>
</body>
</html>