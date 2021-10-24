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
	//이미 Constant에 template가 저장되어 있으니 또 autowired로 받을 필요 x
	
	@RequestMapping("list")
	public String list(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "board/list";
	}

}
