package admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/AdminController")
public class AdminController extends HttpServlet implements javax.servlet.Servlet{
	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		String RequestURI=request.getRequestURI();		// 요청받은 전체 URL 출력
		String contextPath=request.getContextPath();	// 프로젝트 이름까지의 URL
		String command=RequestURI.substring(contextPath.length());

		ActionForward forward=null;	//Action 인터페이스. 동적바인딩하여 일관된 코딩하기 위함.
		Action action=null;			//ActionForward는 클래스. forward방식,redirect를 구별하여 보낼 설정.

		if(command.equals("/Admin.ad")){	//관리자 페이지
			forward= new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("./admin/admin.jsp");
			
		}else if(command.equals("/AdminLogin.ad")){		//관리자로그인
			forward= new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("./admin/adminLogin.jsp");
			
		}else if(command.equals("/ReservationAddJsp.ad")){		//예약추가
			forward= new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("./admin/reservationAdd.jsp");
		}else if(command.equals("/FaqAddJsp.ad")){		//FAQ추가
			forward= new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("./admin/faqAdd.jsp");
		}else if(command.equals("/ThemaAddJsp.ad")){		//Thema추가
			forward= new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("./admin/themaAdd.jsp");
		}else if(command.equals("/AdminLoginAction.ad")){	//관리자로그인	
			   action = new AdminLoginAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ReservationList.ad")){		//예약회원 리스트
			   action = new ReservationList();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ThemaList.ad")){		//테마리스트
			   action = new ThemaList();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/QnaList.ad")){		//QNA리스트
			   action = new QnaList();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/FaqList.ad")){		//FAQ리스트
			   action = new FaqList();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/SalesList.ad")){		//Sales리스트
			   action = new SalesList();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/GalleryList.ad")){	//갤러리리스트	
			   action = new GalleryList();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ReservationInfoAction.ad")){	//예약정보조회 1팀
			   action = new ReservationInfoAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/QnaInfoAction.ad")){	//QNA정보조회 1개
			   action = new QnaInfoAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ThemaInfoAction.ad")){	//Thema정보조회 1개
			   action = new ThemaInfoAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/FaqInfoAction.ad")){	//FAQ정보조회 1개
			   action = new FaqInfoAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/GalleryInfoAction.ad")){	//Gallery정보조회 1개
			   action = new GalleryInfoAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ReservationDeleteAction.ad")){	//예약삭제
			   action = new ReservationDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ThemaDeleteAction.ad")){	//테마삭제
			   action = new ThemaDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/QnaDeleteAction.ad")){	//QNA삭제
			   action = new QnaDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/FaqDeleteAction.ad")){	//FAQ삭제
			   action = new FaqDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/GalleryDeleteAction.ad")){	//GALLERY삭제
			   action = new GalleryDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ReservationAddAction.ad")){	//예약추가
			   action = new ReservationAddAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/FaqAddAction.ad")){	//FAQ추가
			   action = new FaqAddAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ThemaAddAction.ad")){	//Thema추가
			   action = new ThemaAddAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 } else if (command.equals("/addReservetime.ad")){	//예약시간추가
			 	action = new ReserveTimeAdd();			 	
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
