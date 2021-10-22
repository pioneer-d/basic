<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "myInfoConfirm" method = "post">
	<table width="50%" height="80" border="1" align="center"
		cellpadding="5" cellspacing="0" bordercolor="#0872b0">
		<tr align="center">
			<td colspan="2" align="center" bgcolor="#ccecff">
				<div style="font-weight: bold; font-size: 18px">회원 정보 조회</div>
			</td>
		</tr>
		<tr>
			<td bgcolor="#e6e6e6" align="center">
				<div style="font-weight: bold;">아이디:</div>
			</td>
			<td>&nbsp <input type = "text" name = "id" value = "${User.m_Id}">
			</td>
		</tr>
		<tr>
			<td bgcolor="#e6e6e6" align="center"><div
					style="font-weight: bold;">비밀번호:</div></td>
			<td>&nbsp <input type = "text" name = "pwd" value = "${User.m_Pwd}">
			</td>
		</tr>
		<tr>
			<td bgcolor="#e6e6e6" align="center"><div
					style="font-weight: bold;">메일주소:</div></td>
			<td>&nbsp <input type = "text" name = "mail" value = "${User.m_Email}">
			</td>
		</tr>
		<tr>
			<td bgcolor="#e6e6e6" align="center"><div
					style="font-weight: bold;">이름:</div></td>
			<td>&nbsp <input type = "text" name = "name" value = "${User.m_Name}">
			</td>
		</tr>
		<tr>
			<td bgcolor="#e6e6e6" align="center"><div
					style="font-weight: bold;">주민등록번호:</div></td>
			<td>&nbsp<input type = "text" name = "num" value = "${User.m_Num1}">-
						<input type = "text" name = "num2" value = "${User.m_Num2}">
			</td>
		</tr>
		<tr>
			<td bgcolor="#e6e6e6" align="center"><div
					style="font-weight: bold;">자기소개:</div></td>
			<td><input type = "text" name = "introduce" value = "${User.m_Intro}">
			</td>
		</tr>
	</table>
	<div align = center><a href="javascript:window.history.back();" >뒤로가기</a> &nbsp
	<input type = "submit" value = "수정완료">
	</div>
	</form>
</body>
</html>