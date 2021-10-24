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
			System.out.println(result);		//�г��� ���
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("nick", result);	//���ǿ� �г��� ���
			return true;
		}else{
			return false;
		}
	}




}
