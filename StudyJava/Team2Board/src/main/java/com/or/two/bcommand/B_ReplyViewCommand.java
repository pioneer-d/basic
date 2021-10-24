package com.or.two.bcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.two.dao.B_Dao;
import com.or.two.dto.B_Dto;

public class B_ReplyViewCommand implements B_Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();	//이때 request가 키값이고object가 데이터들이다. 그래서 Map을 쓴다. model의 request값을 꺼내기 위한 과정이라고 보자.
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//request꺼내기.
		String BOARD_NUM = request.getParameter("BOARD_NUM");
		
		B_Dao dao = new B_Dao();
		B_Dto dto = dao.reply_view(BOARD_NUM);
		
		model.addAttribute("reply_view",dto);

	}

}
