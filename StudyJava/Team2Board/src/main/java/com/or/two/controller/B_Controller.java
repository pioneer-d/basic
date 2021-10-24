package com.or.two.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.or.two.util.Constant;
import com.or.two.bcommand.B_Command;
import com.or.two.bcommand.B_Command2;
import com.or.two.bcommand.B_ContentCommand;
import com.or.two.bcommand.B_DeleteCommand;
import com.or.two.bcommand.B_ListCommand;
import com.or.two.bcommand.B_ModifyCommand;
import com.or.two.bcommand.B_ReplyCommand;
import com.or.two.bcommand.B_ReplyViewCommand;
import com.or.two.bcommand.B_WriteCommand;

@Controller
@RequestMapping("board/")
public class B_Controller {

	B_Command command;
	B_Command2 command2;
	private JdbcTemplate template;
	
	@Autowired	//자동으로 객체 주입을 해주는 역할!
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")		//게시물 리스트
	public String list(Model model) {
		
		command = new B_ListCommand();
		command.execute(model);
		
		return "board/list";
	}
	
	@RequestMapping("/list2")		//게시물 리스트(삭제 권한 없을경우)
	public String list2(Model model) {
		
		command = new B_ListCommand();
		command.execute(model);
		
		return "board/list2";
	}
	
	@RequestMapping("/list3")		//게시물 리스트(수정 권한 없을경우)
	public String list3(Model model) {
		
		command = new B_ListCommand();
		command.execute(model);
		
		return "board/list3";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {	//write.jsp로 이동.
		return "board/write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {	//write후 리스트로 이동
		
		model.addAttribute("request",request);	//request를 model에 담자.
		command = new B_WriteCommand();
		command.execute(model);	//model을 보냈다가 다시 오도록 만들어.(model에 request가 포함되어 있음.)
		
		return "redirect:list";	//다시 list로 보내주는거지. 그럼 또 list맵핑가서 db들렸다가 출력해주겠네.
	}
	
	@RequestMapping("/content_view")		//게시물 조회
	public String content_view(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new B_ContentCommand();
		command.execute(model);
		return "board/content_view";
	}
	
	@RequestMapping("/delete")			//게시물 삭제
	public String delete(HttpServletRequest request ,Model model) throws IOException {
		
		model.addAttribute("request",request);
		command2 = new B_DeleteCommand();
		command2.execute(model);
		
		if(command2.execute(model) == true) {
			return "redirect:list";
		}return "redirect:list2";
		
	}
	
	@RequestMapping("/reply_view")		//답글달기 준비
	public String reply_view(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new B_ReplyViewCommand();
		command.execute(model);
		
		return "board/reply_view";
	}
	
	@RequestMapping("/reply")			//답글달기
	public String reply(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new B_ReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/modify")			//수정하기
	public String modify(HttpServletRequest request, Model model) {
	model.addAttribute("request",request);
	command2 = new B_ModifyCommand();
	command2.execute(model);
	
	if(command2.execute(model) == true) {
		return "redirect:list";
	}
	
	return "redirect:list3";
	}
	
}
