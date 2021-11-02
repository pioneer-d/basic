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
		
		//roomCode = Integer.parseInt(request.getParameter("theme")); // 방코드
				if (request.getParameter("rdate") == null) { // 날짜가 빈값이면 오늘 날짜 넣어줌
			Time = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		} else {
			Time = request.getParameter("rdate");

		}
		TimeS = Time + " 00:00:00";
		TimeE = Time + " 23:59:00";
		
		roomList = roomdao.roomList();
		if (request.getParameter("theme") == null||Integer.parseInt(request.getParameter("theme"))==0){		// 방코드가 빈값이면 첫번째방 넣어줌
			
			roomCode = null;
			
			rtimeListAll = new ArrayList();		//예약시간을 담은 list를 list로 묶기
			for(int i =1;i<=roomList.size();i++) {
				rtimeList = roomdao.reserveTime(i, TimeS, TimeE);
				rtimeListAll.add(rtimeList);
			}
			
			
		
		} else {								//방코드에 값이 들어있다면
						
			roomCode = Integer.parseInt(request.getParameter("theme")); // 방코드
			
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
