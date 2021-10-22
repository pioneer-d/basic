<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String[] arr = (String[]) request.getAttribute("User");	//일반 사용자 페이지인줄 알았네 바꿔야함.
    %>
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
				<div style="font-weight: bold; font-size: 18px">회원 정보 조회</div>
			</td>
		</tr>
		<tr>
			<td bgcolor="#e6e6e6" align="center">
				<div style="font-weight: bold;">아이디:</div>
			</td>
			<td>&nbsp <%= arr[0] %>
			</td>
		</tr>
		<tr>
			<td bgcolor="#e6e6e6" align="center"><div
					style="font-weight: bold;">비밀번호:</div></td>
			<td>&nbsp <%= arr[1] %>
			</td>
		</tr>
		<tr>
			<td bgcolor="#e6e6e6" align="center"><div
					style="font-weight: bold;">메일주소:</div></td>
			<td>&nbsp <%= arr[2] %></td>
		</tr>
		<tr>
			<td bgcolor="#e6e6e6" align="center"><div
					style="font-weight: bold;">이름:</div></td>
			<td>&nbsp <%= arr[3] %></td>
		</tr>
		<tr>
			<td bgcolor="#e6e6e6" align="center"><div
					style="font-weight: bold;">주민등록번호:</div></td>
			<td>&nbsp<%= arr[4] %>-<%= arr[5] %></td>
		</tr>
		<tr>
			<td bgcolor="#e6e6e6" align="center"><div
					style="font-weight: bold;">자기소개:</div></td>
			<td><%= arr[6] %></td>
		</tr>

	</table>
	<div align = center><a href="javascript:window.history.back();" >뒤로가기</a> &nbsp<a href="myInfoUpdate">수정하기</a></div>
	
</body>
</html>