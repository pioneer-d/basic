<%@page import="com.javalec.ex.Day10.MemberDTO"%>
<%@page import="com.javalec.ex.Day10.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	
	//submit을 통해 얻는 id와 pw
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDAO dao = MemberDAO.getInstance();
	int checkNum = dao.userCheck(id, pw);
	
	if(checkNum == -1){
%> 
	<script type = "text/javascript">
		alert("아이디가 존재하지 않습니다.");
		history.go(-1);
	</script>	
<%
	}else if(checkNum == 0){
%>
	<script type = "text/javascript">
		alert("비밀번호가 일치하지 않습니다.");
		history.go(-1);
	</script>
<%
	}else if(checkNum == 1){
		MemberDTO dto = dao.getMember(id);
		
		if(dto == null){
%>
	<script type = "text/javascript">
		alert("존재하지 않는 회원입니다.");
		history.go(-1);
	</script>	
<%
		}else{
			String name = dto.getName();
			session.setAttribute("id", id);	//request로 얻어옴
			session.setAttribute("name", name);	//db에서 출력받음
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("main.jsp");
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