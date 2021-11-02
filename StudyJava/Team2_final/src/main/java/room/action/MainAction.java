package room.action;

import room.db.RoomBeans;
import room.db.RoomDAO;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RoomDAO roomdao = new RoomDAO();
		ActionForward forward = new ActionForward();

		ArrayList roomlist = roomdao.roomList();		
		
		request.setAttribute("roomList", roomlist);

		forward.setRedirect(false);
		forward.setPath("./newescape/hd.newescape.co.kr/home/main.jsp");
		return forward;
	}

}
