<%@page import="com.javalec.ex.Day9.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javalec.ex.Day9.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<%
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberDTO> dto = dao.memberSelect();
	
	for(int i = 0; i<dto.size(); i++){
		MemberDTO dto1 = dto.get(i);
		String id = dto1.getS_ID();
		String pw = dto1.getS_PW();
		int age = dto1.getS_AGE();
		String name = dto1.getS_NAME();
		String gender = dto1.getS_GENDER();
		
		out.println("아이디 : " + id + "비밀번호 : " + pw + "나이 : " + age + "이름 : " + name + "성별 : " + gender + "<br>");
		
	}


%>

</body>
</html>