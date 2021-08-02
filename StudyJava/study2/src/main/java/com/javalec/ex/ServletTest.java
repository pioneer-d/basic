package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/st")	//어노테이션을 통한 맵핑 기능
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletTest() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//이건 console창에 나올것.
		System.out.println("doGet");
		
		//이건 HTML문서로 나올것.-
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<body>");
		writer.println("Hello World");
		writer.println("</body>");
		writer.println("</head>");
		writer.println("</html>");
		writer.close();

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//이건 console창에 나올것.
		System.out.println("doPost메소드 입니다.");
		
		//이건 HTML문서로 나올것.-
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<body>");
		writer.println("Hello World");
		writer.println("</body>");
		writer.println("</head>");
		writer.println("</html>");
		writer.close();
	}

}
