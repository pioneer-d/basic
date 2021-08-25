package com.javalec.ex.Day8;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//jps의 폴더가 Day8의 하위에 있으므로 명시 해줘야함.
@WebServlet("/Day8/LoginOk")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	
	private String S_ID, S_PW;
	private String getS_ID, getS_PW, getS_NAME;

       
    public LoginOk() {
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
		
		String query = "select * from STUDYMEMBER where S_ID = '" + S_ID + "' and S_PW = '" + S_PW + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				getS_ID = rs.getString("S_ID");
				getS_PW = rs.getString("S_PW");
				getS_NAME = rs.getString("S_NAME");
			}
			
//			if(getS_ID == null || getS_PW == null) {	//틀릴경우는 어케했더라
//				response.setContentType("text/html; charset = UTF-8");
//				PrintWriter writer = response.getWriter();
//				writer.println("<html><head><script type = 'text/javascript'></head><body>");
//				writer.println("alert('회원이 등록되어 있지 않거나 잘못입력하셨습니다');");
//				writer.println("</body></html>");
//				
//				writer.close();
//				response.sendRedirect("login.jsp");
//			}	
			
			HttpSession session = request.getSession();
			session.setAttribute("id", getS_ID);
			session.setAttribute("pw", getS_PW);
			session.setAttribute("name", getS_NAME);
			response.sendRedirect("loginResult.jsp");
			
			
			
		}catch(Exception e) {
			e.getMessage();
		}finally {
			try {
				connection.close();
				stmt.close();
				rs.close();
			}catch(Exception e2) {
				e2.getMessage();
			}
		}
		
		
	}

}
