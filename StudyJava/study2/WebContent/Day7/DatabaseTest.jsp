<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%
	//�̵��� ���ΰ�ü�� �ƴϹǷ� �����ڸ� ���� import�ؾ���.
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";	//�̶� 1521�� port��ȣ �̴�.
	String uid = "hr";
	String upw = "hr";
	String query = "select * from STUDYMEMBER";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
	try{
		//JDBC����̹� �ε� ����
		Class.forName(driver);
		//������ ���̽� ����
		connection = DriverManager.getConnection(url, uid, upw);
		//sql���๮ �غ�
		statement = connection.createStatement();
		//sql�� ����
		resultSet = statement.executeQuery(query);
		
		while(resultSet.next()){	//next�� ���� ��� �����͸� ����.
			String id = resultSet.getString("S_ID");
			String pw = resultSet.getString("S_PW");
			int age = resultSet.getInt("S_AGE");
			String name = resultSet.getString("S_NAME");
			
			out.println("���̵� : "+id+"<br>");
			out.println("��й�ȣ : "+pw+"<br>");
			out.println("���� : "+age+"<br>");
			out.println("�̸� : "+name+"<br>");
		}
		
		
	}catch(Exception e){
	}finally{
		try{
			if(resultSet != null)resultSet.close();
			if(statement != null)statement.close();
			if(connection != null)connection.close();
			
		}catch(Exception e){
		}
		
	}

%>

</body>
</html>