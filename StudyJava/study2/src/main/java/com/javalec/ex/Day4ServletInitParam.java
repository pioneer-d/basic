package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//여기를 주석처리 했다는건 web.xml에서 맵핑을 했다는 뜻@!
//@WebServlet("/Day4ServletInitParam")

public class Day4ServletInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Day4ServletInitParam() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
		
		//web.xml에서 초기화 파라미터를 불러온다!
		//원래 ServletConfig라는 클래스에 있는 메소드 이지만 HttpServlet이 클래스가 상속 받고 있어서 바로 사용 가능.
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
