package com.or.myProject.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.or.myProject.member.dao.MDao;
import com.or.myProject.member.dto.MDto;

public class MMyInfoCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		HttpSession session = request.getSession();
		String m_Id = (String)session.getAttribute("m_Id");
		
		MDto dto;
		MDao dao = new MDao();
		
		dto = dao.myInfo(m_Id);
		model.addAttribute("User", dto);
	}

}
