package com.or.two.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.or.two.mcommand.M_Command;
import com.or.two.mcommand.M_Command2;
import com.or.two.mcommand.M_JoinCommand;
import com.or.two.mcommand.M_LoginCommand;
import com.or.two.mcommand.M_MemberDelete;
import com.or.two.mcommand.M_MemberList;
import com.or.two.util.Constant;

	@Controller
	@RequestMapping("member/")	//맵핑 앞부분 경로 통일
	public class M_Controller {

	M_Command command = null;
	M_Command2 command2 = null;
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	@RequestMapping("/login")
	public String loginForm() {							//맨처음 로그인 화면
		
		return "member/loginForm";
	}
	
	@RequestMapping("/login2")
	public String loginForm2() {							//맨처음 로그인 화면
		
		return "member/loginForm2";
	}
	
	@RequestMapping("/joinForm")
	public String joinForm() {							//회원가입 페이지
		
		return "member/joinForm";
	}
	
	@RequestMapping("/joinCommand")
	public String joinCommand(HttpServletRequest request, Model model) {	//회원가입
		
		model.addAttribute("request",request);		//model에 request담기
		command = new M_JoinCommand();
		command.execute(model);
		
		return "redirect:login";
	}
	
	@RequestMapping("/loginCommand")
	public String loginCommand(HttpServletRequest request, Model model) {	//로그인 성공시 main으로
		
		model.addAttribute("request",request);
		command2 = new M_LoginCommand();
		command2.execute(model);	//
		
		if(command2.execute(model) == true) {
			return "member/main";
		}return "redirect:login2";
		
	}
	
	@RequestMapping("/memberList")
	public String memberList(Model model) {				//회원리스트로 이동
		
		command = new M_MemberList();
		command.execute(model);
		
		return "member/memberList";
	}
	
	@RequestMapping("/memberDelete")
	public String memberDelete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request",request);
		command = new M_MemberDelete();
		command.execute(model);
		
		return "redirect:memberList";
	}
}
