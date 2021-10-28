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
	
	@RequestMapping("list")	//모든 글 보기
	public String list(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "board/list";
	}
	
	@RequestMapping("list2")	//수정 후 리스트
	public String list2(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "board/list2";
	}
	
	@RequestMapping("list3")	//삭제 후 리스트
	public String list3(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "board/list3";
	}
	
	@RequestMapping("write")	//글작성 페이지로 이동
	public String write(Model model) {
		return "board/write";
	}
	
	@RequestMapping("writeInsert")	//글작성 완료시 db입력
	public String writeInsert(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new BWriteCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	//1개의 글 자세히 보기
	@RequestMapping("viewContent")
	public String viewContent(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new BViewContentCommand();
		command.execute(model);
		return "board/viewContent";
	}
	
	//글 수정권한 확인
	@RequestMapping("modifyConfirm")
	public String modifyConfirm(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new BViewContentCommand();
		command.execute(model);		
		return "board/modify";
	}
	
	//글 수정완료
	@RequestMapping("modify")
	public String modify(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new BModifyCommand();
		command.execute(model);
		return "redirect:list2";
	}
	
	//글 삭제완료
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new BDeleteCommand();
		command.execute(model);
		return "redirect:list3";
	}
	
	
	//글답변
	
}
