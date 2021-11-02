package room.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reserve.action.reserveFormAction;

public class RoomFrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;

		 
		if (command.equals("/room.rm")) {		//방
			action = new ThemaRoom();
			try {
				//System.out.println("에러체크 1 ");
				forward = action.execute(request, response);
				//System.out.println("에러체크 2 ");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (command.equals("/roomList.rm")) {		//예약하기 - 선택
			action = new RoomListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (command.equals("/escapeRoom.rm")) {		//메인홈
			action = new MainAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (command.equals("/about.rm")) {		//about
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./newescape/hd.newescape.co.kr/about/index.jsp");

		} else if (command.equals("/agreement.rm")) {		//about
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./newescape/hd.newescape.co.kr/customer/agreement.jsp");

		} else if (command.equals("/privacy.rm")) {		//about
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./newescape/hd.newescape.co.kr/customer/privacy.jsp");

		}
		
		

		if (forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
}

