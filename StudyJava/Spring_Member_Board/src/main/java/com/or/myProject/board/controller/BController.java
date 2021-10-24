package com.or.myProject.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.or.myProject.board.command.BCommand;
import com.or.myProject.board.command.BListCommand;
import com.or.myProject.board.command.BWriteCommand;

@Controller
@RequestMapping("/board")
public class BController {
	
	BCommand command;
	
	@RequestMapping("list")	//��� �� ����
	public String list(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "board/list";
	}
	
	@RequestMapping("write")	//���ۼ� �������� �̵�
	public String write(Model model) {
		return "board/write";
	}
	
	@RequestMapping("writeInsert")
	public String writeInsert(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new BWriteCommand();
		command.execute(model);
		return "redirect:list";
	}



}
