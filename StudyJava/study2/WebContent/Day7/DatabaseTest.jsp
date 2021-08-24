<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%
	//이들은 내부객체가 아니므로 지시자를 통해 import해야함.
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";	//이때 1521은 port번호 이다.
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
		//JDBC드라이버 로드 과정
		Class.forName(driver);
		//데이터 베이스 연결
		connection = DriverManager.getConnection(url, uid, upw);
		//sql실행문 준비
		statement = connection.createStatement();
		//sql문 실행
		resultSet = statement.executeQuery(query);
		
		while(resultSet.next()){	//next를 통해 모든 데이터를 수집.
			String id = resultSet.getString("S_ID");
			String pw = resultSet.getString("S_PW");
			int age = resultSet.getInt("S_AGE");
			String name = resultSet.getString("S_NAME");
			
			out.println("아이디 : "+id+"<br>");
			out.println("비밀번호 : "+pw+"<br>");
			out.println("나이 : "+age+"<br>");
			out.println("이름 : "+name+"<br>");
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