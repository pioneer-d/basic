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
		
		//post�� �ѱ� ���ڵ� ����̴�.
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String[] hobby = request.getParameterValues("hobby");
		String subject = request.getParameter("subject");
		String os = request.getParameter("os");

		//�����Ұ��� text������ html�� ���ڵ� UTF-8
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println("�̸� : "+name+"<br>");
		writer.println("���̵� : "+id+"<br>");
		writer.println("��й�ȣ : "+pw+"<br>");
		writer.println("��� : "+Arrays.toString(hobby)+"<br>");
		writer.println("���� : "+subject+"<br>");
		writer.println("�ü�� : "+os+"<br>");
		writer.println("</body></html>");
		
		writer.close();
	
	}

}
