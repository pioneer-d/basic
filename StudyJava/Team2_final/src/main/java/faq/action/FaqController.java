package faq.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet("/FaqController")
public class FaqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		String RequestURI=request.getRequestURI();		// ��û���� ��ü URL ���
		String contextPath=request.getContextPath();	// ������Ʈ �̸������� URL
		String command=RequestURI.substring(contextPath.length());
		
		ActionForward forward=null;	//Action �������̽�. �������ε��Ͽ� �ϰ��� �ڵ��ϱ� ����.
		Action action=null;	


		if(command.equals("/faqList.fa")){	//������ ������
			action= new FaqListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		
		
		//�������� ��� �ֵ��� ������ ��ġ�� �޼ҵ�.
		if(forward.isRedirect()){	//��� isRedirect�̰� true��� ���̴ϱ� redirect�� �Ѿ.
			response.sendRedirect(forward.getPath());
		}else{ 	//��� isRedirect�� false�ϱ� forward�� �Ѿ.
			//RequestDispatcher <= forward������� �Ѿ �� �ְ� ����
			RequestDispatcher dispatcher=
					request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}

	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
