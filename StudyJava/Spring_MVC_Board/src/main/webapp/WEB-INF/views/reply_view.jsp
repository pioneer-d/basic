<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width = "500" cellpadding = "0" border = "1">
		<form action = "reply" method = "post">
			<input type = "hidden" name = "bId" value = "${reply_view.bId }">
			<input type = "hidden" name = "bGroup" value = "${reply_view.bGroup }">
			<input type = "hidden" name = "bIndent" value = "${reply_view.bIndent }">
			<input type = "hidden" name = "bStep" value = "${reply_view.bStep }">
			<tr>
				<td>이름</td>
				<td> <input type = "text" name = "bName" value = "${reply_view.bName }"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td> <input type = "text" name = "bTitle" value = "${reply_view.bTitle }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td> <textarea rows = "10" name = "bContent">${reply_view.bContent }</textarea></td>
			</tr>
			<tr>
				<td colspan = "2"> <input type = "submit" value = "답변"> 
				&nbsp;&nbsp; <a href = "list">목록보기</a>
			</tr>					
		</form>
	</table>

</body>
</html>