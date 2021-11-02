package room.action;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.db.RoomBeans;
import room.db.RoomDAO;

public class RoomListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RoomDAO roomdao = new RoomDAO();
		ActionForward forward = new ActionForward();
		Integer roomCode;
		String Time;
		String TimeS;
		String TimeE;
		ArrayList rtimeList;
		ArrayList roomList;
		ArrayList rtimeListAll;
		RoomBeans rbeans = null;
		
		//roomCode = Integer.parseInt(request.getParameter("theme")); // ���ڵ�
				if (request.getParameter("rdate") == null) { // ��¥�� ���̸� ���� ��¥ �־���
			Time = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		} else {
			Time = request.getParameter("rdate");

		}
		TimeS = Time + " 00:00:00";
		TimeE = Time + " 23:59:00";
		
		roomList = roomdao.roomList();
		if (request.getParameter("theme") == null||Integer.parseInt(request.getParameter("theme"))==0){		// ���ڵ尡 ���̸� ù��°�� �־���
			
			roomCode = null;
			
			rtimeListAll = new ArrayList();		//����ð��� ���� list�� list�� ����
			for(int i =1;i<=roomList.size();i++) {
				rtimeList = roomdao.reserveTime(i, TimeS, TimeE);
				rtimeListAll.add(rtimeList);
			}
			
			
		
		} else {								//���ڵ忡 ���� ����ִٸ�
						
			roomCode = Integer.parseInt(request.getParameter("theme")); // ���ڵ�
			
			//roomList = roomdao.roomList();
			
			rtimeListAll=roomdao.reserveTime(roomCode, TimeS, TimeE);
			
			rbeans = roomdao.room(roomCode);
			
			request.setAttribute("rbeans", rbeans);
		}

		ArrayList<String> rnameList = roomdao.roomname();

		
//		request.setAttribute("rnameList", rnameList);
		request.setAttribute("roomList", roomList);
		request.setAttribute("rtimeList", rtimeListAll);
		request.setAttribute("Date", Time);
		request.setAttribute("code", roomCode);

		System.out.println("check");
		forward.setRedirect(false);
		forward.setPath("./newescape/hd.newescape.co.kr/reserve/index.jsp");
		return forward;
	}

}
