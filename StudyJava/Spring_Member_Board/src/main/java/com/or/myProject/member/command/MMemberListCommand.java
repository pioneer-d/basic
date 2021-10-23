package com.or.myProject.member.command;

import java.util.List;

import org.springframework.ui.Model;

import com.or.myProject.member.dao.MDao;

public class MMemberListCommand implements MCommand {

	@Override
	public void execute(Model model) {

		MDao dao = new MDao();
		List<String> list = dao.memberList();
		
		model.addAttribute("member_list",list);
	}

}
