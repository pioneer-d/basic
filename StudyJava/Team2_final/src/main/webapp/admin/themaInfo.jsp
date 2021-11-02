<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
   String[] arr = (String[]) request.getAttribute("Info");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="50%" height="80" border="1" align="center"
		cellpadding="5" cellspacing="0" bordercolor="lightgrey">
		<tr align="center">
			<td colspan="2" align="center" bgcolor="#339999">
				<div style="font-weight: bold; font-size: 18px">테마조회</div>
			</td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center" width=200>
				<div style="font-weight: bold;">방코드:</div>
			</td>
			<td>&nbsp <%= arr[0] %>
			</td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center" width=200><div
					style="font-weight: bold;">테마이름:</div></td>
			<td>&nbsp <%= arr[1] %>
			</td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center" width=200 ><div
					style="font-weight: bold;">난이도:</div></td>
			<td>&nbsp <%= arr[2] %></td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center" width=200><div
					style="font-weight: bold;">진행시간:</div></td>
			<td>&nbsp <%= arr[3] %></td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center" width=200><div
					style="font-weight: bold;">테마사진:</div></td>
			<td>&nbsp
			<%if(!(arr[4]==null)){ %>
		<a href="./themaUpload/<%=arr[4]%>">
			<%=arr[4] %>
		</a>
		<%} %>
			</td>
		</tr>	
		<tr>
			<td bgcolor="##FFCC00" align="center" width=200><div
					style="font-weight: bold;">테마소개글:</div></td>
			<td>&nbsp<%= arr[5] %></td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center" width=200><div
					style="font-weight: bold;">테마예약시간:</div></td>
			<td>&nbsp<%= arr[6] %></td>
		</tr>
	</table>
	<div align=center>
		<form action="./addReservetime.ad">
		<input type="hidden" name="ROOMNUM" value="<%= arr[0] %>">
		<input type="hidden" name="ROOMRESERVETIME" value="<%= arr[6] %>">
		yyyy-mm-dd <input type="text" name="day"> <input type="submit" value="예약시간 추가하기">
		</form>
	</div>
	<div align=center>
		<a href="javascript:window.history.back();">뒤로가기</a>
	</div>
</body>
</html>