<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type = "text/javascript">

function infoConfirm(){
	if(document.reg_frm.id.value.length == 0){
		alert("아이디를 입력하세요");
		reg_frm.id.focus();
		return;
		}
		
	if(document.reg_frm.id.value.length < 4){
		alert("아이디는 최소 4글자 이상이여야 합니다");
		reg_frm.id.focus();
		return;
		}
		
	if(document.reg_frm.pw.value.length == 0){
		alert("비밀번호를 입력하세요");
		reg_frm.pw.focus();
		return;
		}
	
	if(document.reg_frm.pw.value.length < 4){
		alert("비밀번호는 최소 4글자 이상이여야 합니다");
		reg_frm.pw.focus();
		return;
		}
		
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value){
		alert("비밀번호가 일치하지 않습니다");
		reg_frm.pw.focus();
		return;
		}
	
	if(document.reg_frm.name.value.length == 0){
		alert("이름을 입력하세요");
		reg_frm.name.focus();
		return;
		}
	
	if(document.reg_frm.email.value.length == 0){
		alert("메일을 입력하세요");
		reg_frm.email.focus();
		return;
		}
		
	document.reg_frm.submit();		
	
}
</script>
</head>
<body>
	<form action="joinOk.jsp" method = "post" name = "reg_frm">
	아이디 : <input type = "text" name = "id" size = "20"><br>
	비밀번호 : <input type = "password" name = "pw" size = "20"><br>
	비밀번호 확인 : <input type = "password" name = "pw_check" size = "20"><br>
	이름 : <input type = "text" name = "name" size = "20"><br>
	메일 : <input type = "text" name = "email" size = "30"><br>
	주소 : <input type = "text" name = "address" size = "50"><br>
	<input type = "button" value = "회원가입" onclick = "infoConfirm()"> &nbsp;&nbsp;&nbsp; 
	<input type = "reset" value = "취소" onclick = "javascript:window.location = 'login.jsp'">
	</form>
	
</body>
</html>