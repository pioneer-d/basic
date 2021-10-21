package com.or.myProject.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.myProject.member.dao.MDao;
import com.or.myProject.member.dto.MDto;

public class MJoinCommand implements MCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		MDto dto;
		MDao dao = new MDao();
		
		String m_Id = request.getParameter("id");
		String m_Pwd = request.getParameter("pwd");
		String m_Email = request.getParameter("mail");
		String m_Name = request.getParameter("name");
		int m_Num1 = Integer.parseInt(request.getParameter("num"));	
		int m_Num2 = Integer.parseInt(request.getParameter("num2"));
		String m_Intro = request.getParameter("introduce");
		
		dto = new MDto(m_Id, m_Pwd, m_Email, m_Name, m_Num1, m_Num2, m_Intro);
		dao.join(dto);
		
	}

}
