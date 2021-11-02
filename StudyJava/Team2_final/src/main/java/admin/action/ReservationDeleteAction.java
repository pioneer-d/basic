package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.db.AdminDAO;

public class ReservationDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		AdminDAO admindao = new AdminDAO();
		String RESERVATION_NUM = request.getParameter("RESERVATION_NUM");
		admindao.ReservationDelete(RESERVATION_NUM);
		
		
		ActionForward forward = new ActionForward();
	   	forward.setRedirect(true);
   		forward.setPath("./Admin.ad");
   		return forward;
	}

}
