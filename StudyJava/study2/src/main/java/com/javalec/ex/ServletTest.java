package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/st")	//������̼��� ���� ���� ���
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletTest() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�̰� consoleâ�� ���ð�.
		System.out.println("doGet");
		
		//�̰� HTML������ ���ð�.-
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
		
		//�̰� consoleâ�� ���ð�.
		System.out.println("doPost�޼ҵ� �Դϴ�.");
		
		//�̰� HTML������ ���ð�.-
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
