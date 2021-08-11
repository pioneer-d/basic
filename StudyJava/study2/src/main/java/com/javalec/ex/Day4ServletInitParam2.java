package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Param2"}, initParams = {@WebInitParam(name = "id", value = "qwer"),
													@WebInitParam(name = "pw", value = "qwe1234")})
//이번엔 초기화 파라미터 값을 web.xml이 아닌 servlet에서 직접 입력하는 방식.
//어모테이션을 활용한다.
public class Day4ServletInitParam2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Day4ServletInitParam2() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("doGet()");
		String id = getInitParameter("id");
		String pw = getInitParameter("pw");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("아이디 : "+id+"<br>");
		writer.println("비밀번호 : "+pw+"<br>");
		writer.println("</body></html>");
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
