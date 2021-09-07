<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
	String path = request.getRealPath("fileFolder");

	int size = 1024 * 1024 * 10;	//10M
	String file = "";
	String oriFile = "";	//파일 이름 중복 방지
	
	try{
		MultipartRequest multi = new MultipartRequest(request, path, size, "EUC-KR", new DefaultFileRenamePolicy());
																							//이름 뒤 1,2,3이렇게 하나씩 입력되는 것
		Enumeration files = multi.getFileNames();
		String str = (String)files.nextElement();
		
		file = multi.getFilesystemName(str);		//중복 되었을때 이름..?
		oriFile = multi.getOriginalFileName(str);	//실제 이름
				
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	성공

</body>
</html>


