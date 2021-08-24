<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="JoinOk" method = "post">
	아이디 : <input type = "text" name = "id" size = "10"><br>
	비밀번호 : <input type = "password" name = "pw" size = "10" ><br>
	나이 : <input type = "text" name = "age" size = "10"><br>
	이름 : <input type = "text" name = "name" size = "10"><br>
	성별 : <input type = "radio" name = "gender" value = "man">남자
		  <input type = "radio" name = "gender" value = "woman">여자<br>
	<input type = "submit" value = "회원가입"> - <input type = "reset" value = "다시입력">
</form>
</body>
</html>