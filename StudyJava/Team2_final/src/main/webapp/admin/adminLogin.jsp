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
				<td colspan = 2 align = center><h3>로그인창</h3></td>
			</tr>
			
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "id" id = 'id'></td>	<!-- 이것을 session으로 저장할 것임. -->
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "pwd" id = "pwd"></td>
			</tr>
			
			<tr>
				<td colspan = 2 align = center>
				<input type = "submit" value = "로그인" >
				<button onclick="history.back()">뒤로가기</button>
			</tr>
		</table>
		</div>
	</form>
</body>
</html>