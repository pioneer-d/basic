<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
	String path = request.getRealPath("fileFolder");

	int size = 1024 * 1024 * 10;	//10M
	String file = "";
	String oriFile = "";	//���� �̸� �ߺ� ����
	
	try{
		MultipartRequest multi = new MultipartRequest(request, path, size, "EUC-KR", new DefaultFileRenamePolicy());
																							//�̸� �� 1,2,3�̷��� �ϳ��� �ԷµǴ� ��
		Enumeration files = multi.getFileNames();
		String str = (String)files.nextElement();
		
		file = multi.getFilesystemName(str);		//�ߺ� �Ǿ����� �̸�..?
		oriFile = multi.getOriginalFileName(str);	//���� �̸�
				
		
		
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

	����

</body>
</html>


