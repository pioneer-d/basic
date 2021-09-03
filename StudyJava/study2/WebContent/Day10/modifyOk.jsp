<%@page import="com.javalec.ex.Day10.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
	<jsp:useBean id = "dto" class = "com.javalec.ex.Day10.MemberDTO" scope = "page"/>
	<jsp:setProperty name = "dto" property = "*"/>
<%
	String id = (String)session.getAttribute("id");
	dto.setId(id);
	MemberDAO dao = MemberDAO.getInstance();
	int ri = dao.updateMember(dto);
	if(ri == 1){

%>	
	<script type = "text/javascript">
		alert("정보수정이 완료되었습니다");
		location.href = "login.jsp";
	</script>
<%
	}else if(ri == 0){
%>
	<script type = "text/javascript">
		alert("정보수정에 실패했습니다");
		location.href = "login.jsp";
	</script>
<%
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