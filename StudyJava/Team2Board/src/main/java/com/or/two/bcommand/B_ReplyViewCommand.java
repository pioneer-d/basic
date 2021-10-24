package com.or.two.bcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.two.dao.B_Dao;
import com.or.two.dto.B_Dto;

public class B_ReplyViewCommand implements B_Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();	//�̶� request�� Ű���̰�object�� �����͵��̴�. �׷��� Map�� ����. model�� request���� ������ ���� �����̶�� ����.
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//request������.
		String BOARD_NUM = request.getParameter("BOARD_NUM");
		
		B_Dao dao = new B_Dao();
		B_Dto dto = dao.reply_view(BOARD_NUM);
		
		model.addAttribute("reply_view",dto);

	}

}
