package com.or.two.bcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.two.dao.B_Dao;

public class B_ReplyCommand implements B_Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();	//이때 request가 키값이고object가 데이터들이다. 그래서 Map을 쓴다. model의 request값을 꺼내기 위한 과정이라고 보자.
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//request꺼내기.
		
		String BOARD_NUM = request.getParameter("BOARD_NUM");
		String MEMBER_NICK = request.getParameter("MEMBER_NICK");
		String BOARD_TITLE = request.getParameter("BOARD_TITLE");
		String BOARD_CONTENT = request.getParameter("BOARD_CONTENT");
		String BOARD_GROUP = request.getParameter("BOARD_GROUP");
		String BOARD_STEP = request.getParameter("BOARD_STEP");
		String BOARD_INDENT = request.getParameter("BOARD_INDENT");
		
		B_Dao dao = new B_Dao();
		dao.reply(BOARD_NUM, MEMBER_NICK, BOARD_TITLE, BOARD_CONTENT, BOARD_GROUP, BOARD_STEP, BOARD_INDENT);

	}

}
