package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import admin.db.AdminDAO;

public class SalesList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AdminDAO admindao = new AdminDAO();
		ArrayList<String> result = admindao.allSales();
		request.setAttribute("list", result);
		
		ArrayList<String> result2 = admindao.allSales2();	
		request.setAttribute("list2", result2);	
		
		String sales = "sales";
		request.setAttribute("page", sales);
		
		ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./admin/admin.jsp");
		return forward;
		
	}

}
