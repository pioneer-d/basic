package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.db.AdminDAO;

public class ReservationInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AdminDAO admindao = new AdminDAO();
		String RESERVATION_NUM = request.getParameter("RESERVATION_NUM");
		
		String []result = admindao.ReserInfo(RESERVATION_NUM);
		request.setAttribute("Info", result);	//info∑Œ ≥—∞‹¡‹
		
		ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./admin/reservationInfo.jsp");
   		return forward;
	}

}
