package com.or.myProject.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.or.myProject.board.command.BCommand;
import com.or.myProject.board.command.BDeleteCommand;
import com.or.myProject.board.command.BListCommand;
import com.or.myProject.board.command.BModifyCommand;
import com.or.myProject.board.command.BViewContentCommand;
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
	
	@RequestMapping("list2")	//���� �� ����Ʈ
	public String list2(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "board/list2";
	}
	
	@RequestMapping("list3")	//���� �� ����Ʈ
	public String list3(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "board/list3";
	}
	
	@RequestMapping("write")	//���ۼ� �������� �̵�
	public String write(Model model) {
		return "board/write";
	}
	
	@RequestMapping("writeInsert")	//���ۼ� �Ϸ�� db�Է�
	public String writeInsert(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new BWriteCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	//1���� �� �ڼ��� ����
	@RequestMapping("viewContent")
	public String viewContent(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new BViewContentCommand();
		command.execute(model);
		return "board/viewContent";
	}
	
	//�� �������� Ȯ��
	@RequestMapping("modifyConfirm")
	public String modifyConfirm(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new BViewContentCommand();
		command.execute(model);		
		return "board/modify";
	}
	
	//�� �����Ϸ�
	@RequestMapping("modify")
	public String modify(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new BModifyCommand();
		command.execute(model);
		return "redirect:list2";
	}
	
	//�� �����Ϸ�
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new BDeleteCommand();
		command.execute(model);
		return "redirect:list3";
	}
	
	
	//�۴亯
	
}
