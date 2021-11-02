package room.action;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.db.RoomBeans;
import room.db.RoomDAO;

public class ThemaRoom implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		RoomDAO roomdao = new RoomDAO();
		RoomBeans roombean = new RoomBeans();
		ActionForward forward = new ActionForward();
		Integer roomCode;
		String Time;
		String TimeS;
		String TimeE;
//		Date roomTimeS;
//		Date roomTimeE;
//		Timestamp stampS;
//		Timestamp stampE;
		//java.util.Date uroomDate;
		
		if(request.getParameter("rcode")==null)//방코드가 빈값이면 첫번째방 넣어줌
			if(request.getSession().getAttribute("rcode")==null) {
				roomCode=1;
			}else {
				roomCode=(Integer)request.getSession().getAttribute("rcode");
			}
		else {
			roomCode = Integer.parseInt(request.getParameter("rcode"));	//방코드
			//request.getSession().setAttribute("rcode", roomCode);
		}
			
		
		if(request.getParameter("rdate")==null) {	//날짜가 빈값이면 오늘 날짜 넣어줌
			if(request.getSession().getAttribute("rdate")==null) {
				Time=new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
			}else {
				Time=(String) request.getSession().getAttribute("rdate");
			}
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");			
			TimeS= Time+" 00:00:00";
			TimeE= Time+" 23:59:00";
			
//			stampS = java.sql.Timestamp.valueOf(TimeS);
//			stampE = java.sql.Timestamp.valueOf(TimeE);

//			uroomDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(TimeS);		//날짜변환
//			roomTimeS = new java.sql.Date(uroomDate.getTime());
//					(Date)uroomDate;
//			uroomDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(TimeE);
//			roomTimeE= new java.sql.Date(uroomDate.getTime());
		} else {
			Time = request.getParameter("rdate");
			//request.getSession().setAttribute("rdate", Time);
			TimeS = Time+" 00:00:00";	//날짜
			TimeE = Time+" 23:59:00";
//			uroomDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(TimeS);		//날짜변환
//			roomTimeS = new java.sql.Date(uroomDate.getTime());
//			uroomDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(TimeE);
//			roomTimeE = new java.sql.Date(uroomDate.getTime());
			
//			stampS = java.sql.Timestamp.valueOf(TimeS);
//			stampE = java.sql.Timestamp.valueOf(TimeE);			
		}
		
				
		ArrayList rtimeList = roomdao.reserveTime(roomCode, TimeS, TimeE);
		roombean = roomdao.room(roomCode);
		ArrayList<String> rnameList = roomdao.roomname();
		
		request.setAttribute("rnameList", rnameList);
		request.setAttribute("rtimeList", rtimeList);
		request.setAttribute("roomInfo", roombean);
		request.setAttribute("Date", Time);
		request.setAttribute("code", roomCode);
		
		System.out.println("check");
		forward.setRedirect(false);
   		forward.setPath("./newescape/hd.newescape.co.kr/room/room.jsp");
   		return forward;
	}

	
}
