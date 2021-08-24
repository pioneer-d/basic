package com.javalec.ex.Day8;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Day8/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement stmt;
	
	private String S_ID, S_PW, S_NAME, S_GENDER;
	private int S_AGE;
	
	
    public JoinOk() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		
		S_ID = request.getParameter("id");
		S_PW = request.getParameter("pw");
		S_AGE = Integer.parseInt(request.getParameter("age"));
		S_NAME = request.getParameter("name");
		S_GENDER = request.getParameter("gender");
		
		String query = "insert into STUDYMEMBER values('" + S_ID + "','" + S_PW + "','" + S_AGE + "','" + S_NAME + "','" + S_GENDER + "')";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			stmt = connection.createStatement();
			
			//저번과 달리 resultSet이 필요없음. 불러오는게 아닌 올리는 것이니까.
			//이것의 반환값은 int이다. 몇개가 수정이 됐는지가 반환값이다.
			int i = stmt.executeUpdate(query);
			if(i == 1) {
				System.out.println("회원가입 DB에 입력 완료.");
				response.sendRedirect("joinResult.jsp"); 	//회원가입 완료시 이동
			}else {
				System.out.println("회원가입 실패");
				response.sendRedirect("join.jsp");
			}
			
		}catch(Exception e) {
			e.getMessage();
		}finally {
			try {
				connection.close();
				stmt.close();
				
			}catch(Exception e2) {
				e2.getMessage();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	}

