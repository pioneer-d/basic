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
				<div style="font-weight: bold; font-size: 18px">������ ��ȸ</div>
			</td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center">
				<div style="font-weight: bold;">�����ȣ:</div>
			</td>
			<td>&nbsp <%= arr[0] %>
			</td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center"><div
					style="font-weight: bold;">������:</div></td>
			<td>&nbsp <%= arr[1] %>
			</td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center"><div
					style="font-weight: bold;">����ó:</div></td>
			<td>&nbsp <%= arr[2] %></td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center"><div
					style="font-weight: bold;">�̸���:</div></td>
			<td>&nbsp <%= arr[3] %></td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center"><div
					style="font-weight: bold;">�ο�:</div></td>
			<td>&nbsp<%= arr[4] %></td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center"><div
					style="font-weight: bold;">�ݾ�:</div></td>
			<td><%= arr[5] %></td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center"><div
					style="font-weight: bold;">�������:</div></td>
			<td><%= arr[6] %></td>
		</tr>
		<tr>
			<td bgcolor="##FFCC00" align="center"><div
					style="font-weight: bold;">����ð�:</div></td>
			<td><%= arr[7] %></td>
		</tr>			
	</table>
	<div align = center><a href="javascript:window.history.back();">�ڷΰ���</a></div>
</body>
</html>