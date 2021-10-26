<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String session_Id = (String)session.getAttribute("m_Id");
%>
		<script>
			var session_id = "<c:out value='<%=session_Id%>'/>";
			var board_id = "<c:out value='${data.m_Id}'/>";
			if(session_id != board_id){
				alert("권한이 없습니다")
				history.back();
			}else if(session_id != "admin"){
				alert("권한이 없습니다")
				history.back();
			}
		</script>
<form action = "modify" method = "post">
	<table width="500" cellpadding="0" cellspacing="0" border="1">
			<input type="hidden" name="b_Num" value="${data.b_Num}">
			<tr>
				<td>번호</td>
				<td>${data.b_Num}</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${data.b_Hit}</td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="m_Id" value="${data.m_Id}" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="b_Title" value="${data.b_Title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="b_Content">${data.b_Content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type = "submit" value = "수정완료">
					&nbsp;&nbsp; <a href="list">목록보기</a> &nbsp;&nbsp; 
					<a href="delete?b_Num=${data.b_Num}&m_Id=${data.m_Id}">삭제</a> 
					&nbsp;&nbsp; <a href="?b_Num=${data.b_Num}">답변</a></td>
			</tr>
	</table>
</form>
</body>
</html>