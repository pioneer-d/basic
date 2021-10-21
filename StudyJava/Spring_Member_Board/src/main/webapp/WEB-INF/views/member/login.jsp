<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#btn_group button {
	border: 1px solid skyblue;
	background-color: rgba(0, 0, 0, 0);
	color: skyblue;
	padding: 5px;
}
</style>
</head>
<body>
<form action ="loginConfirm" method = "post">
	<table border="1" align="center" width="300" heigth="500">
		<tr>
			<th colspan="2" border="1" align="center">로그인</th>
		</tr>
		<tr>
			<td width="100">&nbsp 아이디 : &nbsp<input type="text" placeholder="id" name="id" size="20"></td>
		</tr>
		<tr>
			<td width="100">비밀번호 : <input type="password"placeholder="password" name="pwd" size="20"></td>
		</tr>
		<tr>
			<td align="center" border="1">
			<input type="submit" value="로그인"> &nbsp 
			<input type="button" onclick="location.href = 'join'" value="회원가입"></td>
		</tr>
	</table>
</form>

</body>
</html>