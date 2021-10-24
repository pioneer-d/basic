package com.or.two.mcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.two.dao.M_Dao;

public class M_MemberDelete implements M_Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();	//�̶� request�� Ű���̰�object�� �����͵��̴�. �׷��� Map�� ����. model�� request���� ������ ���� �����̶�� ����.
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//request������.
		String MEMBER_NICK = request.getParameter("MEMBER_NICK");
		
		M_Dao dao = new M_Dao();
		dao.memberBoardDelete(MEMBER_NICK);
		dao.memberDelete(MEMBER_NICK);

	}

}
