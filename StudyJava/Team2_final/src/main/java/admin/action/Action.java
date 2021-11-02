package admin.action;

import javax.servlet.http.*;

public interface Action {
	
	public ActionForward execute(HttpServletRequest request,
			   HttpServletResponse response) throws Exception;	  
		/*
	    * 추상메소드
	    * 서블릿을 일관되게 사용하기 위한 (get, post)
	    * throws 로 예외처리
	    * Action을 클래스로 받으면
	    * 어떤 방식(action)이던 간에 전송방식과 URI가 넘어가야하므로 ActionForward가 리턴타입이다.
	    */
}
