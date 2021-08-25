<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%!
	Connection connection;
	Statement stmt;
	ResultSet rs;
	
	String S_ID, S_PW, S_NAME, S_GENDER;
	int S_AGE;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String id = (String)session.getAttribute("id");	//LoginOk에서 세션값 지정해줬음.	브라우저가 살아있으니 get가능.
		String query = "select * from STUDYMEMBER where S_ID = '"+id+"'";
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				S_ID = rs.getString("S_ID");
				S_PW = rs.getString("S_PW");
				S_AGE = Integer.parseInt(rs.getString("S_AGE"));
				S_NAME = rs.getString("S_NAME");
				S_GENDER = rs.getString("S_GENDER");
			}
		}catch(Exception e){
			e.getMessage();
		}finally{
			try{
				connection.close();
				stmt.close();
				rs.close();
				
			}catch(Exception e2){
				e2.getMessage();
			}
		}
	%>

	<form action="ModifyOk" method="post">
		아이디 : <input type="text" name="id" size="10" value="<%=S_ID %>" readonly><br> 
		비밀번호 : <input type="password" name="pw" size="10" value="<%=S_PW %>"><br> 
		나이 : <input type="text" name="age" size="10" value="<%=S_AGE %>"><br>
		이름 : <input type="text" name="name" size="10" value="<%=S_NAME %>"><br>
		성별 : <input type="radio" name="gender" value="man" checked="<%=S_GENDER %>">남자 
			  <input type="radio" name="gender" value="woman" checked="<%=S_GENDER %>">여자<br> 
			  <input type="submit" value="수정">
	</form>

</body>
</html>










