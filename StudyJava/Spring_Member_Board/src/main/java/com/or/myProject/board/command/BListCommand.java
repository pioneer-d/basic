package com.or.myProject.board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.or.myProject.board.dao.BDao;
import com.or.myProject.board.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		ArrayList<BDto> dto = dao.list();
		System.out.println(dto);
		model.addAttribute("list", dto);
	}

}
