package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormEx")
public class Day3FormEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Day3FormEx() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		
		//post의 한글 인코딩 방식이다.
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String[] hobby = request.getParameterValues("hobby");
		String subject = request.getParameter("subject");
		String os = request.getParameter("os");

		//응답할거임 text형태의 html로 인코딩 UTF-8
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println("이름 : "+name+"<br>");
		writer.println("아이디 : "+id+"<br>");
		writer.println("비밀번호 : "+pw+"<br>");
		writer.println("취미 : "+Arrays.toString(hobby)+"<br>");
		writer.println("과목 : "+subject+"<br>");
		writer.println("운영체제 : "+os+"<br>");
		writer.println("</body></html>");
		
		writer.close();
	
	}

}
