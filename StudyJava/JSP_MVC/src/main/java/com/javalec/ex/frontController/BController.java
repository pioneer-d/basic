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
import com.javalec.ex.command.BDeleteCommand;
import com.javalec.ex.command.BListCommand;
import com.javalec.ex.command.BWriteCommand;
import com.javalec.ex.command.BModifyCommand;
import com.javalec.ex.command.BReplyCommand;
import com.javalec.ex.command.BReplyViewCommand;

@WebServlet("*.do")
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");		//�ѱ� ���ڵ�
		
		String view = null;		//�������� ���� ���� ����
		BCommand command = null;	//Ŀ��� ����
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/write_view.do")) {			//list���� ���ۼ��ϱ�
			view = "write_view.jsp";
		}else if(com.equals("/write.do")) {			//write_view���� �Ϸ��ϱ�
			command = new BWriteCommand();
			command.execute(request, response);
			view = "list.do";
		}else if(com.equals("/list.do")) {			//list�� ���ư���
			command = new BListCommand();
			command.execute(request, response);			
			view = "list.jsp";
		}else if(com.equals("/content_view.do")) {	//content_view ����
			command = new BContentCommand();
			command.execute(request, response);
			view = "content_view.jsp";
		}else if(com.equals("/modify.do")) {		//content_view���� �����ϱ�
			command = new BModifyCommand();
			command.execute(request, response);
			view = "list.do";
		}else if(com.equals("/delete.do")) {		//content_view���� �����ϱ�
			command = new BDeleteCommand();
			command.execute(request, response);
			view = "list.do";
		}else if(com.equals("/reply_view.do")) {	//content_view���� �亯�ϱ�
			command = new BReplyViewCommand();
			command.execute(request, response);
			view = "reply_view.jsp";
		}else if(com.equals("/reply.do")) {			//reply_view.jsp���� �亯 �Ϸ�
			command = new BReplyCommand();
			command.execute(request, response);
			view = "list.do";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request,response);
		
	}

}
