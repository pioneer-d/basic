package com.or.two.mcommand;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.or.two.dao.M_Dao;
import com.or.two.dto.M_Dto;

public class M_MemberList implements M_Command {

	@Override
	public void execute(Model model) {
		M_Dao dao = new M_Dao();
		ArrayList<M_Dto> dto = dao.memberlist();
		model.addAttribute("list",dto);
	}

}
