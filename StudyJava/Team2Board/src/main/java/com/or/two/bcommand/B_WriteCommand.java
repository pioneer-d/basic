package com.or.two.bcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.two.dao.B_Dao;

public class B_WriteCommand implements B_Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();	//�̶� request�� Ű���̰�object�� �����͵��̴�. �׷��� Map�� ����. model�� request���� ������ ���� �����̶�� ����.
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//request������.
		
		String MEMBER_NICK = request.getParameter("MEMBER_NICK");		//�� ������ dao�� ��������.
		String BOARD_TITLE = request.getParameter("BOARD_TITLE");
		String BOARD_CONTENT = request.getParameter("BOARD_CONTENT");
		
		
		B_Dao dao = new B_Dao();
		dao.write(MEMBER_NICK,BOARD_TITLE,BOARD_CONTENT);	//������� �ϸ� �ٽ� controller�� �̵�.

	}

}
