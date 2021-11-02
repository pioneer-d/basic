package faq.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.db.FaqDAO;

public class FaqListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FaqDAO faqdao = new FaqDAO();
		ArrayList<String> Num = faqdao.allFaqNum();
		ArrayList<String> Title = faqdao.allFaqTitle();
		ArrayList<String> Content = faqdao.allFaqContent();

		request.setAttribute("Num", Num);
		request.setAttribute("Title", Title);
		request.setAttribute("Content", Content);	

		ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./newescape/hd.newescape.co.kr/customer/faq.jsp");
		return forward;
	}
}