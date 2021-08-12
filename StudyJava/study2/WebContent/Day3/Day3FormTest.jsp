<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<form action="FormEx" method="post">
	이름 : <input type = "text" name = "name" size = "10"><br>
	아이디 : <input type = "text" name = "id" size = "10"><br>
	비밀번호 : <input type = "text" name = "pw" size = "10"><br>
	<br>
	취미 : <input type = "checkbox" name = "hobby" value = "read">독서
	<input type = "checkbox" name = "hobby" value = "exercise">운동
	<input type = "checkbox" name = "hobby" value = "codding">코딩
	<br>
	과목 : <input type = "radio" name = "subject" value = "kor">국어
	<input type = "radio" name = "subject" value = "mat">수학
	<input type = "radio" name = "subject" value = "eng">영어
	<br>
	운영체제 : <select name = "os">
				<option value = "window">윈도우</option>
				<option value = "mac">맥</option>
				<option value = "linux">리눅스</option>
			</select>
	<br>
	<input type = "submit" value = "전송"><input type = "reset" value = "다시입력">
</form>

</body>
</html>