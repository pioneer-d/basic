package com.javalec.ex.Day12;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FrontController1() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("");
		System.out.println("actionDo");
		
		String uri = request.getRequestURI();	//전체 주소를 담고있다.
		System.out.println("uri : "+uri);
		
		String path = request.getContextPath();	//패키지명부터 do까지의 주소를 담고있다.
		System.out.println("path : "+path);
		
		String command = uri.substring(path.length());
		System.out.println("command : "+command);
		
		if(command.equals("/Day12/insert.do")) {
			System.out.println("insert");
		}else if(command.equals("/update.do")) {
			System.out.println("update");
		}else if(command.equals("/Day12/select.do")) {
			System.out.println("select");
		}else if(command.equals("/delete.do")) {
			System.out.println("delete");
		}
	}

}
