package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.db.AdminDAO;

public class QnaDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		AdminDAO admindao = new AdminDAO();
		String Q_NUM = request.getParameter("Q_NUM");
		admindao.QnaDelete(Q_NUM);
		
		ActionForward forward = new ActionForward();
	   	forward.setRedirect(true);
   		forward.setPath("./Admin.ad");
   		return forward;
	}

}
