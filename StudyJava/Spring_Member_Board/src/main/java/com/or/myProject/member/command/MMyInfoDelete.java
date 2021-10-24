package com.or.myProject.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.or.myProject.member.dao.MDao;

public class MMyInfoDelete implements MCommand {

	@Override
	public void execute(Model model) {
		
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("m_Id");
		
		MDao dao = new MDao();
		dao.deleteM(id);
		
	}

}
