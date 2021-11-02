package admin.action;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.db.AdminDAO;
import admin.db.ReservationBean;


public class ReservationAddAction extends ActionForward implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AdminDAO admindao=new AdminDAO();
	   	ReservationBean reservationdata=new ReservationBean();
	   	ActionForward forward=new ActionForward();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	   	
   		boolean result=false;
   		boolean result2=false;
   		
   		reservationdata.setRESERVATION_STATUS(request.getParameter("RESERVATION_STATUS"));	//Bean에 먼저 저장
   		reservationdata.setSUBSCRIBER_NAME(request.getParameter("SUBSCRIBER_NAME"));
   		reservationdata.setSUBSCRIBER_TEL(request.getParameter("SUBSCRIBER_TEL"));
   		reservationdata.setSUBSCRIBER_EMAIL(request.getParameter("SUBSCRIBER_EMAIL"));
   		reservationdata.setRESERVATION_PEOPLE(Integer.parseInt(request.getParameter("RESERVATION_PEOPLE")));
   		reservationdata.setPAYMENT_AMOUNT(Integer.parseInt(request.getParameter("PYAMENT_AMOUNT")));
   		reservationdata.setPAYMENT_METHOD(request.getParameter("PAYMENT_METHOD"));
   		reservationdata.setRESERVATION_TIME(request.getParameter("RESERVATION_TIME"));
   		reservationdata.setROOM_NUM(Integer.parseInt(request.getParameter("ROOM_NUM")));
   		
   		result=admindao.ReservationInsert(reservationdata);	//DB에 입력
   		result2=admindao.ReservationInsert2(reservationdata);//DB에 입력
   		
   		if(result==false || result2==false){
   			System.out.println("등록 실패");
   			return null;
   		}
   		System.out.println("등록 완료");
	   	
   		forward.setRedirect(true);
   		forward.setPath("./Admin.ad");
   		return forward;
	}

}
