package com.or.myProject.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.myProject.member.dao.MDao;

public class MMemberModifyCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String mail = request.getParameter("mail");
		String intro = request.getParameter("introduce");
		
		MDao dao = new MDao();
		
		dao.myInfoUpdate(id, pwd, mail, intro);
		
	}

}
