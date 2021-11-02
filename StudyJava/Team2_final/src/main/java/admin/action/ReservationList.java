package admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.db.AdminDAO;

public class ReservationList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		AdminDAO admindao = new AdminDAO();
		ArrayList<String> result = admindao.allReservation();
		String reservation = "reservation";
		
		
		request.setAttribute("list", result);
		request.setAttribute("page", reservation);
		ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./admin/admin.jsp");
		return forward;
	}

}
