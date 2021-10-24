package com.or.two.mcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.two.dao.M_Dao;

public class M_MemberDelete implements M_Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();	//이때 request가 키값이고object가 데이터들이다. 그래서 Map을 쓴다. model의 request값을 꺼내기 위한 과정이라고 보자.
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//request꺼내기.
		String MEMBER_NICK = request.getParameter("MEMBER_NICK");
		
		M_Dao dao = new M_Dao();
		dao.memberBoardDelete(MEMBER_NICK);
		dao.memberDelete(MEMBER_NICK);

	}

}
