package com.javalec.ex;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InitDestroy")
public class InitDestroy extends HttpServlet {		//Servlet�� �����ֱ⸦ �� �� �ִ� ����.
	private static final long serialVersionUID = 1L;

	//ó���� ���� �ѹ� �����.
	public void init() throws ServletException {
		System.out.println("init()");
	}

	//������̼��� Ȱ���� ��ó��
	@PostConstruct
	private void initPostConstruct() {	//init���� �����
		System.out.println("initPostConstruct()");
	}

	//������ �ѹ� �����.
	public void destroy() {
		System.out.println("destroy()");
		//���� ����� �����.
	}
	
	@PreDestroy
	private void destroyPreDestroy() {	//destroy�Ŀ� �����
		System.out.println("destroyPreDestroy");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
		//���ΰ�ħ ������ init�� �ƴ� doGet�� ��� ����Ǵ� ���� �� �� �ֿ�.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()");
	}

}
