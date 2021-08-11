package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//���⸦ �ּ�ó�� �ߴٴ°� web.xml���� ������ �ߴٴ� ��@!
//@WebServlet("/Day4ServletInitParam")

public class Day4ServletInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Day4ServletInitParam() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
		
		//web.xml���� �ʱ�ȭ �Ķ���͸� �ҷ��´�!
		//���� ServletConfig��� Ŭ������ �ִ� �޼ҵ� ������ HttpServlet�� Ŭ������ ��� �ް� �־ �ٷ� ��� ����.
		String id = getInitParameter("id");
		String pw = getInitParameter("pw");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("���̵� : "+id+"<br>");
		writer.println("��й�ȣ : "+pw+"<br>");
		writer.println("</body></html>");
		writer.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
