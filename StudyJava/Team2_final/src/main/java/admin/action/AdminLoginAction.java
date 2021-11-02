package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String confirmId = "admin";
		String confirmPwd = "1234";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(confirmId.equals(id) && confirmPwd.equals(pwd)) {
			ActionForward forward= new ActionForward();
			forward.setRedirect(false);
	   		forward.setPath("/Admin.ad");
	   		return forward;
		}else {				//로그인 실패시
			ActionForward forward= new ActionForward();
			forward.setRedirect(true);
	   		forward.setPath("./Main.es");	//홈페이지로 다시 이동.
	   		return forward;
		}
		
		
		
	}

}
