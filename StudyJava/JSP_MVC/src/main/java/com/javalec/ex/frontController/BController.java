package com.javalec.ex.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.command.BCommand;
import com.javalec.ex.command.BContentCommand;
import com.javalec.ex.command.BListCommand;

@WebServlet("*.do")
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("actionDo");
		
		request.setCharacterEncoding("UTF-8");		//한글 인코딩
		
		String view = null;		//뷰페이지 관련 변수 선언
		BCommand command = null;	
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/write_view.do")) {			//list에서 '글작성' 클릭시
			view = "write_view.jsp";
		}else if(com.equals("/write.do")) {			//write_view에서 '완료'클릭시
			
			view = "list.do";
		}else if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);			
			view = "list.jsp";
		}else if(com.equals("/content_view.do")) {
			command = new BContentCommand();
			command.execute(request, response);
			view = "content_view.jsp";
		}else if(com.equals("/modify.do")) {
			
			
			view = "list.do";
		}else if(com.equals("/delete.do")) {
			
			
			view = "list.do";
		}else if(com.equals("/reply_view.do")) {
			
			
			view = "reply_view.jsp";
		}else if(com.equals("/reply.do")) {
			
			
			view = "list.do";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request,response);
		
	}

}
