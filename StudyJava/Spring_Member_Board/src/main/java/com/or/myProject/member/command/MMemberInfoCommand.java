package com.or.myProject.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.myProject.member.dao.MDao;
import com.or.myProject.member.dto.MDto;

public class MMemberInfoCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String m_Id = request.getParameter("m_Id");
		MDto dto;
		MDao dao = new MDao();
		
		dto = dao.myInfo(m_Id);	//일반 사용자가 가져오는 model그대로 가져다 씀
		model.addAttribute("User", dto);
		
		
	}

}
