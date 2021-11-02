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
		
		String RequestURI=request.getRequestURI();		// ��û���� ��ü URL ���
		String contextPath=request.getContextPath();	// ������Ʈ �̸������� URL
		String command=RequestURI.substring(contextPath.length());

		ActionForward forward=null;	//Action �������̽�. �������ε��Ͽ� �ϰ��� �ڵ��ϱ� ����.
		Action action=null;			//ActionForward�� Ŭ����. forward���,redirect�� �����Ͽ� ���� ����.

		if(command.equals("/Admin.ad")){	//������ ������
			forward= new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("./admin/admin.jsp");
			
		}else if(command.equals("/AdminLogin.ad")){		//�����ڷα���
			forward= new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("./admin/adminLogin.jsp");
			
		}else if(command.equals("/ReservationAddJsp.ad")){		//�����߰�
			forward= new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("./admin/reservationAdd.jsp");
		}else if(command.equals("/FaqAddJsp.ad")){		//FAQ�߰�
			forward= new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("./admin/faqAdd.jsp");
		}else if(command.equals("/ThemaAddJsp.ad")){		//Thema�߰�
			forward= new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("./admin/themaAdd.jsp");
		}else if(command.equals("/AdminLoginAction.ad")){	//�����ڷα���	
			   action = new AdminLoginAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ReservationList.ad")){		//����ȸ�� ����Ʈ
			   action = new ReservationList();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ThemaList.ad")){		//�׸�����Ʈ
			   action = new ThemaList();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/QnaList.ad")){		//QNA����Ʈ
			   action = new QnaList();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/FaqList.ad")){		//FAQ����Ʈ
			   action = new FaqList();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/SalesList.ad")){		//Sales����Ʈ
			   action = new SalesList();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/GalleryList.ad")){	//����������Ʈ	
			   action = new GalleryList();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ReservationInfoAction.ad")){	//����������ȸ 1��
			   action = new ReservationInfoAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/QnaInfoAction.ad")){	//QNA������ȸ 1��
			   action = new QnaInfoAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ThemaInfoAction.ad")){	//Thema������ȸ 1��
			   action = new ThemaInfoAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/FaqInfoAction.ad")){	//FAQ������ȸ 1��
			   action = new FaqInfoAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/GalleryInfoAction.ad")){	//Gallery������ȸ 1��
			   action = new GalleryInfoAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ReservationDeleteAction.ad")){	//�������
			   action = new ReservationDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ThemaDeleteAction.ad")){	//�׸�����
			   action = new ThemaDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/QnaDeleteAction.ad")){	//QNA����
			   action = new QnaDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/FaqDeleteAction.ad")){	//FAQ����
			   action = new FaqDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/GalleryDeleteAction.ad")){	//GALLERY����
			   action = new GalleryDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ReservationAddAction.ad")){	//�����߰�
			   action = new ReservationAddAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/FaqAddAction.ad")){	//FAQ�߰�
			   action = new FaqAddAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 }else if(command.equals("/ThemaAddAction.ad")){	//Thema�߰�
			   action = new ThemaAddAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		 } else if (command.equals("/addReservetime.ad")){	//����ð��߰�
			 	action = new ReserveTimeAdd();			 	
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
