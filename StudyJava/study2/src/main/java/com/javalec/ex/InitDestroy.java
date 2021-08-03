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
public class InitDestroy extends HttpServlet {		//Servlet의 생명주기를 할 수 있는 서블릿.
	private static final long serialVersionUID = 1L;

	//처음에 최초 한번 실행됨.
	public void init() throws ServletException {
		System.out.println("init()");
	}

	//어노테이션을 활용한 선처리
	@PostConstruct
	private void initPostConstruct() {	//init전에 실행됨
		System.out.println("initPostConstruct()");
	}

	//마지막 한번 실행됨.
	public void destroy() {
		System.out.println("destroy()");
		//서버 종료시 실행됨.
	}
	
	@PreDestroy
	private void destroyPreDestroy() {	//destroy후에 실행됨
		System.out.println("destroyPreDestroy");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
		//새로고침 누르면 init이 아닌 doGet이 계속 실행되는 것을 볼 수 있움.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()");
	}

}
