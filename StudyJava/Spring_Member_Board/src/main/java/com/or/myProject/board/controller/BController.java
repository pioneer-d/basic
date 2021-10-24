package com.or.myProject.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.or.myProject.board.command.BCommand;
import com.or.myProject.board.command.BListCommand;

@Controller
@RequestMapping("/board")
public class BController {
	
	BCommand command;
	//�̹� Constant�� template�� ����Ǿ� ������ �� autowired�� ���� �ʿ� x
	
	@RequestMapping("list")
	public String list(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "board/list";
	}

}
