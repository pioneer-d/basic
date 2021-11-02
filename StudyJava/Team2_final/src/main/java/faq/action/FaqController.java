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
		
		String RequestURI=request.getRequestURI();		// 요청받은 전체 URL 출력
		String contextPath=request.getContextPath();	// 프로젝트 이름까지의 URL
		String command=RequestURI.substring(contextPath.length());
		
		ActionForward forward=null;	//Action 인터페이스. 동적바인딩하여 일관된 코딩하기 위함.
		Action action=null;	


		if(command.equals("/faqList.fa")){	//관리자 페이지
			action= new FaqListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		
		
		//마지막에 모든 애들이 무조건 거치는 메소드.
		if(forward.isRedirect()){	//얘는 isRedirect이게 true라는 뜻이니까 redirect로 넘어감.
			response.sendRedirect(forward.getPath());
		}else{ 	//얘는 isRedirect가 false니까 forward로 넘어감.
			//RequestDispatcher <= forward방식으로 넘어갈 수 있게 해줌
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
