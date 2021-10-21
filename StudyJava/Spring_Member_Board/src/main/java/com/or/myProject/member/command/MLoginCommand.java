package com.or.myProject.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.myProject.member.dao.MDao;

public class MLoginCommand implements MCommand {

	@Override
	public void execute(Model model) {
		
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String m_Id = request.getParameter("id");
		String m_Pwd = request.getParameter("pwd");
		
		MDao dao = new MDao();
		String returnId = dao.login(m_Id, m_Pwd);
		
		request.getSession().setAttribute("m_Id",returnId);		//세션에 ID저장
	}

}
