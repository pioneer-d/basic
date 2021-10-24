<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="writeInsert" method="post">
			<tr>
				<td> 닉네임 </td>
				<td> <input type="text" name="m_Id" value = "<%=session.getAttribute("m_Id") %>" size = "50" readonly> </td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="b_Title" size = "50"> </td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea name="b_Content" rows="10" ></textarea> </td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="입력"> &nbsp;&nbsp; <a href="list">목록보기</a></td>
			</tr>
		</form>
	</table>
	
</body>
</html>