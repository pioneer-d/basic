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
			
			//������ �޸� resultSet�� �ʿ����. �ҷ����°� �ƴ� �ø��� ���̴ϱ�.
			//�̰��� ��ȯ���� int�̴�. ��� ������ �ƴ����� ��ȯ���̴�.
			int i = stmt.executeUpdate(query);
			if(i == 1) {
				System.out.println("ȸ������ DB�� �Է� �Ϸ�.");
				response.sendRedirect("joinResult.jsp"); 	//ȸ������ �Ϸ�� �̵�
			}else {
				System.out.println("ȸ������ ����");
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

