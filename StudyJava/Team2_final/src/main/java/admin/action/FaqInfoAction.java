package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.db.AdminDAO;

public class FaqInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AdminDAO admindao = new AdminDAO();
		String FAQ_NUM = request.getParameter("FAQ_NUM");
		
		String []result = admindao.FaqInfo(FAQ_NUM);
		request.setAttribute("Info", result);	//info∑Œ ≥—∞‹¡‹
		
		ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./admin/faqInfo.jsp");
   		return forward;
	}

}
