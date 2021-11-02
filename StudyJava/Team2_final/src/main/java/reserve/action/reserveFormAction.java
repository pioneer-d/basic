package reserve.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.db.RoomBeans;
import room.db.RoomDAO;

public class reserveFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RoomDAO roomdao = new RoomDAO();
		ActionForward forward = new ActionForward();
		
		Integer roomCode = Integer.parseInt(request.getParameter("rcode"));
		String rdate = request.getParameter("rdate");
		
		RoomBeans rbean = roomdao.room(roomCode);
		//String name = rbean.getROOMNAME();
		int price=20000;
		if(rbean.getROOMTIME()==75)
			price=25000;
		else if(rbean.getROOMTIME()==60)
			price=22000;
		
		String date = rdate.substring(0,10);
		String time = rdate.substring(11,16);
		
		//request.setAttribute("rcode", roomCode);
		request.setAttribute("rdate", rdate);
		request.setAttribute("setdate", date);
		request.setAttribute("settime", time);
		request.setAttribute("price", price);
		request.setAttribute("rbean", rbean);
		//request.setAttribute("name", name);
		
		forward.setRedirect(false);
		forward.setPath("./newescape/hd.newescape.co.kr/reserve/reserve.jsp");
		return forward;
	}

}
