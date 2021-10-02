package com.javalec.springMVC.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.springMVC.command.BCommand;
import com.javalec.springMVC.command.BContentCommand;
import com.javalec.springMVC.command.BDeleteCommand;
import com.javalec.springMVC.command.BListCommand;
import com.javalec.springMVC.command.BModifyCommand;
import com.javalec.springMVC.command.BReplyCommand;
import com.javalec.springMVC.command.BReplyViewCommand;
import com.javalec.springMVC.command.BWriteCommanad;

@Controller
public class BController {
	
	BCommand command;	//선언만 하고, 초기화는 사용할때마다 다른것들 사용(모두 이를 구현하고 있으므로 데이터 타입을 공유할 수 있음)
	
	@RequestMapping("/list")	//모든 글 불러오기
	public String list(Model model) {
		
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")	//글 작성 페이지로 이동
	public String write_view(Model model) {	//model이 굳이 필요한가?
		
		return "write_view";
	}
	
	@RequestMapping("/write")		//작성된 글을 서버에 올리는 과정 마치고 다시 list로 이동
	public String write(HttpServletRequest request, Model model) {
						//form의 값을 받아오기 때문에 HttpServletRequest객체 사용
		model.addAttribute("request",request);
		
		command = new BWriteCommanad();
		command.execute(model);
		
		return "redirect:list";
	}

	@RequestMapping("/content_view")		//글 1개 자세히 보기
	public String content_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request",request);
		
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/modify")			//글 수정하기
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request",request);
		
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}

	@RequestMapping("/reply_view")		//답변보기
	public String reply_view(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")		//답변달기
	public String reply(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		
		command = new BReplyCommand();
		command.execute(model);
		
		return "reply";
	}
	
	@RequestMapping("/delete")		//글 삭제하기
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
		
	}
}
