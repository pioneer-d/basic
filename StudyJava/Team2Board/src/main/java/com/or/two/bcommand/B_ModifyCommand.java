package com.or.two.bcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.or.two.dao.B_Dao;

public class B_ModifyCommand implements B_Command2 {

	@Override
	public boolean execute(Model model) {
		Map<String, Object> map = model.asMap();	//�̶� request�� Ű���̰�object�� �����͵��̴�. �׷��� Map�� ����. model�� request���� ������ ���� �����̶�� ����.
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//request������.
		
		String BOARD_NUM = request.getParameter("BOARD_NUM");
		String BOARD_TITLE = request.getParameter("BOARD_TITLE");
		String BOARD_CONTENT = request.getParameter("BOARD_CONTENT");
		
		String MEMBER_NICK = request.getParameter("MEMBER_NICK");	//�Խù��� ����� �г���
		
		HttpSession httpSession = request.getSession(true);
		String MEMBER_NICK1 = (String) httpSession.getAttribute("nick");	//���� �α��� �Ǿ��ִ� �г���
		if(MEMBER_NICK.equals(MEMBER_NICK1)) {
			B_Dao dao = new B_Dao();
			dao.modify(BOARD_NUM, MEMBER_NICK1, BOARD_TITLE, BOARD_CONTENT);
			return true;
		}else {
			return false;
		}
	}

}
