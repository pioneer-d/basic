<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	        #btn_group button{
            border: 1px solid skyblue;
            background-color: rgba(0,0,0,0);
            color: skyblue;
            padding: 5px;
        }
</style>
</head>
<body>

	<table border = "1" align = "center" bordercolor = "green" width = "500" heigth = "300">
		<tr colspan = "2" border = "1" align = "center" >�α���</tr>
		<tr>
			���̵� : <input type = "text" colspan = "2" border = "1" align = "center" placeholder = "id" name = "id" >
		</tr>
		<tr>
			��й�ȣ : <input type = "password" colspan = "2" border = "1" align = "center" placeholder = "password" name = "password" >
		</tr>
		<tr>
			<div id = "btn_group">
			<td><input type = "button" onclick = "location.href = 'main'" value = "�α���"></td>
			<td><input type = "button" onclick = "location.href = 'join'" value = "ȸ������"></td>
			</div>
		</tr>
	</table>



	<br>
	<a href = "join">ȸ������</a>
	<br>
	<a href = "main">�α���</a>
	
</body>
</html>