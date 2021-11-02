package admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.db.AdminDAO;

public class ReserveTimeAdd implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		AdminDAO admindao = new AdminDAO();
		String ROOMNUM = request.getParameter("ROOMNUM");
		String day = request.getParameter("day");			//입력받은 날짜
		String ROOMRESERVETIME = request.getParameter("ROOMRESERVETIME");
		int rnum = Integer.parseInt(ROOMNUM);
		
		String[] array = ROOMRESERVETIME.split("/");
		ArrayList<String> date = new ArrayList<String>();
		for(String a : array) {
			String d = day+" "+a;
			date.add(d);
		}
		
		admindao.addTime(date, rnum);
		
		String[] result = admindao.ThemaInfo(ROOMNUM);
		request.setAttribute("Info", result);	//info로 넘겨줌
		
	   	forward.setRedirect(false);
   		forward.setPath("./admin/themaInfo.jsp");
   		return forward;
	}


}
//
//
//
//	forward.setRedirect(false);
//	forward.setPath("./admin/themaInfo.jsp");
//	
