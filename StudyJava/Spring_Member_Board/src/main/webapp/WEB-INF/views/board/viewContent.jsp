<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify" method="post">
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
				<td><input type="text" name="b_Title" value="${data.b_Title}" readonly></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="b_Content" readonly>${data.b_Content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">
					&nbsp;&nbsp; <a href="list">목록보기</a> &nbsp;&nbsp; 
					<a href="delete?b_Num=${data.b_Num}&m_Id=${data.m_Id}">삭제</a> 
					&nbsp;&nbsp; <a href="?b_Num=${data.b_Num}">답변</a></td>
			</tr>
		</form>
	</table>

</body>
</html>