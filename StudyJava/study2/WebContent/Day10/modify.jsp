<%@page import="com.javalec.ex.Day10.MemberDTO"%>
<%@page import="com.javalec.ex.Day10.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	String id = (String)session.getAttribute("id");
	MemberDAO dao = MemberDAO.getInstance();
	MemberDTO dto = dao.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "member.js"></script>
</head>
<body>
	<form action="modifyOk.jsp" method = "post" name = "reg_frm">
	아이디 : <input type = "text" value = "<%= id %>" readonly><br>
	비밀번호 : <input type = "password" name = "pw" size = "20"><br>
	비밀번호 확인 : <input type = "password" name = "pw_check" size = "20"><br>
	이름 : <input type = "text" name = "name" size = "20" value = "<%= dto.getName() %>" readonly><br>
	메일 : <input type = "text" name = "email" size = "20" value = "<%= dto.getEmail() %>"><br>
	주소 : <input type = "text" name = "address" size = "20" value = "<%= dto.getAddress() %>"><br>
	<input type = "button" value = "수정" onclick = "updateInfoConfirm()"> &nbsp;&nbsp;&nbsp;
	<input type = "reset" value = "취소" onclick = "javascript:window.location = 'login.jsp'">
	
	</form>

</body>
</html>