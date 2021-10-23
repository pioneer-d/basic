<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="50%" height="80" border="1" align="center"
		cellpadding="5" cellspacing="0" bordercolor="#0872b0">
		<tr align="center">
			<td colspan="2" align="center" bgcolor="#ccecff">
				<div style="font-weight: bold; font-size: 18px">사용자 목록</div>
			</td>
		</tr>
		<c:forEach items = "${member_list }" var = "mem">
		<tr>
			<td bgcolor="#e6e6e6" align="center">
				<div style="font-weight: bold;">사용자 아이디</div>
			</td>
			<td>&nbsp	<a href ="memberModify?m_Id=${mem}">${mem}</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<div align = center><a href="javascript:window.history.back();" >뒤로가기</a> &nbsp</div>
</body>
</html>