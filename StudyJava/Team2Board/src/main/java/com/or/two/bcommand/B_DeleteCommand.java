package com.or.two.bcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.or.two.dao.B_Dao;

import java.util.Map;

public class B_DeleteCommand implements B_Command2 {

	@Override
	public boolean execute(Model model) {
		Map<String, Object> map = model.asMap();	//이때 request가 키값이고object가 데이터들이다. 그래서 Map을 쓴다. model의 request값을 꺼내기 위한 과정이라고 보자.
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//request꺼내기.
		String BOARD_NUM = request.getParameter("BOARD_NUM");
		String MEMBER_NICK = request.getParameter("MEMBER_NICK");	//게시물에 저장된 닉네임
		
		HttpSession httpSession = request.getSession(true);
		String MEMBER_NICK1 = (String) httpSession.getAttribute("nick");	//현재 로근인 되어있는 닉네임
		
		if(MEMBER_NICK.equals(MEMBER_NICK1) || MEMBER_NICK1.equals("관리자")) {	//관리자이거나 로그인되어있는 닉네임과 게시물 닉네임이 같은 경우
			B_Dao dao = new B_Dao();
			dao.delete(BOARD_NUM);
			return true;
		}else {
			return false;
		}
		
		
		
	}

//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		String BOARD_NUM = request.getParameter("BOARD_NUM");
//		String MEMBER_NICK = request.getParameter("MEMBER_NICK");	//게시물에 저장된 닉네임
//		
//		HttpSession httpSession = request.getSession(true);
//		String MEMBER_NICK1 = (String) httpSession.getAttribute("nick");	//현재 로근인 되어있는 닉네임
//		
//		System.out.println(MEMBER_NICK);
//		System.out.println(MEMBER_NICK1);
//		
//		if(MEMBER_NICK.equals(MEMBER_NICK1) || MEMBER_NICK1.equals("admin")) {
//			B_Dao dao = new B_Dao();
//			dao.delete(BOARD_NUM);
//		}else {
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('삭제할 권한이 없습니다.)");
//			out.println("location.href='board/list';");
//			out.println("</script>");
//			out.close();
//		}
//		
//		
//	}
		
		
	}

