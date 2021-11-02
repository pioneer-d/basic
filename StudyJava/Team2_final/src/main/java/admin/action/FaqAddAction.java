package admin.action;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.db.AdminDAO;
import admin.db.FaqBean;

public class FaqAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AdminDAO admindao=new AdminDAO();
		FaqBean faqdata=new FaqBean();
	   	ActionForward forward=new ActionForward();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	   	
   		boolean result=false;
	   	
   		faqdata.setFAQ_NUM(Integer.parseInt(request.getParameter("FAQ_NUM")));	//Bean에 먼저 저장
   		faqdata.setFAQ_TITLE(request.getParameter("FAQ_TITLE"));
   		faqdata.setFAQ_CONTENT(request.getParameter("FAQ_CONTENT"));
   		
   		result=admindao.FaqInsert(faqdata);	//DB에 입력
   		
   		if(result==false){
   			System.out.println("등록 실패");
   			return null;
   		}
   		System.out.println("등록 완료");
	   	
   		forward.setRedirect(true);
   		forward.setPath("./Admin.ad");
   		return forward;
	}

}
