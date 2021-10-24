package com.or.two.bcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.two.dao.B_Dao;

public class B_WriteCommand implements B_Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();	//이때 request가 키값이고object가 데이터들이다. 그래서 Map을 쓴다. model의 request값을 꺼내기 위한 과정이라고 보자.
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//request꺼내기.
		
		String MEMBER_NICK = request.getParameter("MEMBER_NICK");		//이 값들을 dao에 보낼거임.
		String BOARD_TITLE = request.getParameter("BOARD_TITLE");
		String BOARD_CONTENT = request.getParameter("BOARD_CONTENT");
		
		
		B_Dao dao = new B_Dao();
		dao.write(MEMBER_NICK,BOARD_TITLE,BOARD_CONTENT);	//여기까지 하면 다시 controller로 이동.

	}

}
