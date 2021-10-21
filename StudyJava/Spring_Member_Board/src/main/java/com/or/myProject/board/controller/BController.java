package com.or.myProject.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BController {
	
	@RequestMapping("member/board/list")
	public String list(Model model) {
		return "board/list";
	}

}
