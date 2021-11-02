package reserve.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reserve.db.ReserveBeans;
import reserve.db.ReserveDAO;

public class ReserveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("EUC-KR");
		
		boolean result=false;
		ReserveBeans rbeans = new ReserveBeans();
		ReserveDAO reservedao = new ReserveDAO();
		
		rbeans.setSUBSCRIBER_NAME(request.getParameter("name"));
		rbeans.setSUBSCRIBER_EMAIL(request.getParameter("email"));
		String tel = request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3");
		rbeans.setSUBSCRIBER_TEL(tel);
		rbeans.setRESERVATION_PEOPLE(Integer.parseInt(request.getParameter("player")));
		String date = request.getParameter("rdate")+" "+request.getParameter("rtime");
		rbeans.setRESERVATION_TIME(date);
		int price = Integer.parseInt(request.getParameter("player"))*Integer.parseInt(request.getParameter("price"));
		rbeans.setPAYMENT_AMOUNT(price);
		rbeans.setROOMNUM(Integer.parseInt(request.getParameter("theme")));
		rbeans.setPAYMENT_METHOD(request.getParameter("payway"));
		
		result=reservedao.addReserve(rbeans);
		reservedao.reserveStatus(rbeans);
		
		if(result==false){
   			System.out.println("예약 실패");
   			return null;
   		}
   		System.out.println("예약 완료");
		
		forward.setRedirect(true);
   		forward.setPath("./escapeRoom.rm");
   		return forward;
	}

}
