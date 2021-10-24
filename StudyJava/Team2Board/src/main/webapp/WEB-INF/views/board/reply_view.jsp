<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="reply" method="post">
			<input type="hidden" name="BOARD_NUM" value="${reply_view.BOARD_NUM}">
			<input type="hidden" name="BOARD_GROUP" value="${reply_view.BOARD_GROUP}">
			<input type="hidden" name="BOARD_STEP" value="${reply_view.BOARD_STEP}">
			<input type="hidden" name="BOARD_INDENT" value="${reply_view.BOARD_INDENT}">
			<tr>
				<td> 번호 </td>
				<td> ${reply_view.BOARD_NUM} </td>
			</tr>
			<tr>
				<td> 히트 </td>
				<td> ${reply_view.BOARD_HIT} </td>
			</tr>
			<tr>
				<td> 닉네임 </td>
				<td> <input type="text" name="MEMBER_NICK" value="<%=session.getAttribute("nick") %>" readonly></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="BOARD_TITLE" value="${reply_view.BOARD_TITLE}"></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea rows="10"  name="BOARD_CONTENT">${reply_view.BOARD_CONTENT}</textarea></td>
			</tr>
			<tr >
				<td colspan="2"><input type="submit" value="답변"> <a href="list" >목록</a></td>
			</tr>
		</form>
	</table>
	
</body>
</html>