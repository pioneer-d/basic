package com.or.myProject.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.or.myProject.board.command.BCommand;
import com.or.myProject.board.command.BListCommand;
import com.or.myProject.board.command.BViewContent;
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
		command = new BViewContent();
		command.execute(model);
		return "board/viewContent";
	}
	
	//글수정
	
	//글삭제
	
	//글답변



}
