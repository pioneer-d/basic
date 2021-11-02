package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.db.AdminDAO;

public class QnaInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AdminDAO admindao = new AdminDAO();
		String Q_NUM = request.getParameter("Q_NUM");
		
		String []result = admindao.QnaInfo(Q_NUM);
		request.setAttribute("Info", result);	//info�� �Ѱ���
		
		ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./admin/qnaInfo.jsp");
   		return forward;
	}

}
