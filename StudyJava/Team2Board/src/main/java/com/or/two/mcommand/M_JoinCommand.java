package com.or.two.mcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.two.dao.M_Dao;

public class M_JoinCommand implements M_Command {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();	//이때 request가 키값이고object가 데이터들이다.
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//request꺼내기.

		String MEMBER_ID = request.getParameter("MEMBER_ID");
		String MEMBER_PWD = request.getParameter("MEMBER_PWD");
		String MEMBER_EMAIL = request.getParameter("MEMBER_EMAIL");
		String MEMBER_NICK = request.getParameter("MEMBER_NICK");
		int MEMBER_TEL = (Integer.parseInt(request.getParameter("MEMBER_TEL")));
		
		
		System.out.println(MEMBER_ID);
		System.out.println(MEMBER_PWD);
		System.out.println(MEMBER_EMAIL);
		System.out.println(MEMBER_NICK);
		System.out.println(MEMBER_TEL);
		
		M_Dao dao = new M_Dao();
		dao.memberInsert(MEMBER_ID,MEMBER_PWD,MEMBER_EMAIL,MEMBER_NICK,MEMBER_TEL);


	}

}
