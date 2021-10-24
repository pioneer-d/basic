package com.or.two.mcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.or.two.dao.M_Dao;
import com.or.two.dto.M_Dto;

public class M_LoginCommand implements M_Command2 {

	@Override
	public boolean execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");

		String MEMBER_ID = request.getParameter("id");
		String MEMBER_PWD = request.getParameter("pwd");

		M_Dao dao = new M_Dao();
		M_Dto nick = dao.membercheck(MEMBER_ID);
		String result = null;

		if(nick == null) {
			return false;
		}
		
		if(nick.getMEMBER_ID().equals(MEMBER_ID) && nick.getMEMBER_PWD().equals(MEMBER_PWD)) {
			result = nick.getMEMBER_NICK();
			System.out.println(result);		//닉네임 출력
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("nick", result);	//세션에 닉네임 등록
			return true;
		}else{
			return false;
		}
	}




}
