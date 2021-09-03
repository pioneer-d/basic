<%@page import="com.javalec.ex.Day10.MemberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id = "dto" class = "com.javalec.ex.Day10.MemberDTO" scope = "page"/>
<jsp:setProperty name = "dto" property = "*"/>
<%
	dto.setRdate(new Timestamp(System.currentTimeMillis()));
	MemberDAO dao = MemberDAO.getInstance();	//싱글톤을 통한 상수로 생성자 생성
	if(dao.confirmId(dto.getId()) == MemberDAO.MEMBER_EXISTENT){

%>
	<script type = "text/javascript">
		alert("아이디가 이미 존재합니다");
		history.back();
	</script>
<%
	}else{
		int ri = dao.insertMember(dto);
		if(ri == MemberDAO.MEMBER_JOIN_SUCCESS){
			session.setAttribute("id", dto.getId());

%>
	<script type = "text/javascript">
		alert("회원가입이 완료되었습니다");
		location.href = "login.jsp";
	</script>
<%
		}else{
%>
	<script type = "text/javascript">
		alert("회원가입에 실패하였습니다");
		location.href = "login.jsp";
	</script>
	<%
		}
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>