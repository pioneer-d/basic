package reserve.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import reserve.db.*;

public class ReserveSearchAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ReserveDAO reservedao = new ReserveDAO();
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("EUC-KR");
		
		//입력받은 이름과 전화번호
		String name = request.getParameter("name");
		String tel1 = request.getParameter("phone1");
		String tel2 = request.getParameter("phone2");
		String tel3 = request.getParameter("phone3");
		String tel = tel1+"-"+tel2+"-"+tel3;
		String content = "";
		
		ArrayList reserveList = reservedao.searchReserve(name, tel);
		
		if(reserveList == null) {
			content="<br>고객님의 정보로 예약된 내용이 없습니다.";
		} else {
			for(int i=0; i<reserveList.size(); i++) {
				ReserveBeans rbeans = (ReserveBeans)reserveList.get(i);
				String rname = reservedao.searchRoomname(rbeans.getROOMNUM());
				String rtime = rbeans.getRESERVATION_TIME();
				int rpeople = rbeans.getRESERVATION_PEOPLE();
				
				content += "<br>"+rtime+" - "+rname+"("+ Integer.toString(rpeople)+"명)";
			}
		}
		
		request.setAttribute("name", name);
		request.setAttribute("tel1", tel1);
		request.setAttribute("tel2", tel2);
		request.setAttribute("tel3", tel3);
		request.setAttribute("content", content);
		
		forward.setRedirect(false);
		forward.setPath("./newescape/hd.newescape.co.kr/reserve/searchResult.jsp");
		return forward;
	}

}
