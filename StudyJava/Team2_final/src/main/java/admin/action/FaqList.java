package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import admin.db.AdminDAO;

public class FaqList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AdminDAO admindao = new AdminDAO();
		ArrayList<String> result = admindao.allFaq();
		String faq = "faq";
		
		
		request.setAttribute("list", result);
		request.setAttribute("page", faq);
		ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./admin/admin.jsp");
		return forward;
	}

}
