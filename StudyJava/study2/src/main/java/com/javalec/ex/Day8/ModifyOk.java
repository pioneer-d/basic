package com.javalec.ex.Day8;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

@WebServlet("/Day8/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement stmt;
	
	private String S_ID, S_PW, S_NAME, S_GENDER;
	int S_AGE;
	
    public ModifyOk() {
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

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		S_ID = request.getParameter("id");
		S_PW = request.getParameter("pw");
		S_AGE = Integer.parseInt(request.getParameter("age"));
		S_NAME = request.getParameter("name");
		S_GENDER = request.getParameter("gender");
		
		String query = "update STUDYMEMBER set S_ID = '" + S_ID + "',S_PW = '" + S_PW + "',S_AGE = '" + S_AGE + "',S_NAME = '" + S_NAME + "',S_GENDER = '" + S_GENDER + "' where S_ID = '"+ S_ID +"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			stmt = connection.createStatement();
			
			
			int i = stmt.executeUpdate(query);	//입력은 ResultSet이 아닌 Statement에서 바로 입력한다.
			if(i == 1) {	//이때 1은 입력갯수.
				System.out.println("수정 DB에 입력 완료.");
				HttpSession session = request.getSession();
				session.setAttribute("id", S_ID);
				session.setAttribute("pw", S_PW);
				session.setAttribute("name", S_NAME);
				response.sendRedirect("modifyResult.jsp");
			}else {
				System.out.println("수정 실패");
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
