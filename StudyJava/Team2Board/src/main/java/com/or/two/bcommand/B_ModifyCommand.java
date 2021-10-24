package com.or.two.bcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.or.two.dao.B_Dao;

public class B_ModifyCommand implements B_Command2 {

	@Override
	public boolean execute(Model model) {
		Map<String, Object> map = model.asMap();	//이때 request가 키값이고object가 데이터들이다. 그래서 Map을 쓴다. model의 request값을 꺼내기 위한 과정이라고 보자.
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//request꺼내기.
		
		String BOARD_NUM = request.getParameter("BOARD_NUM");
		String BOARD_TITLE = request.getParameter("BOARD_TITLE");
		String BOARD_CONTENT = request.getParameter("BOARD_CONTENT");
		
		String MEMBER_NICK = request.getParameter("MEMBER_NICK");	//게시물에 저장된 닉네임
		
		HttpSession httpSession = request.getSession(true);
		String MEMBER_NICK1 = (String) httpSession.getAttribute("nick");	//현재 로그인 되어있는 닉네임
		if(MEMBER_NICK.equals(MEMBER_NICK1)) {
			B_Dao dao = new B_Dao();
			dao.modify(BOARD_NUM, MEMBER_NICK1, BOARD_TITLE, BOARD_CONTENT);
			return true;
		}else {
			return false;
		}
	}

}
