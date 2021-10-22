package com.or.myProject.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.or.myProject.Constant;
import com.or.myProject.member.command.MCommand;
import com.or.myProject.member.command.MJoinCommand;
import com.or.myProject.member.command.MLoginCommand;
import com.or.myProject.member.command.MMyInfoCommand;

@Controller
public class MController {
	
	MCommand command;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	//로그인 페이지
	@RequestMapping("/member/login")
	public String login(Model model) {
		
		return "/member/login";
	}
	
	//로그인 검사
	@RequestMapping("/member/loginConfirm")		//form값을 받아오기 위해 request사용
	public String loginConfirm(HttpServletRequest request, Model model) {
		
		model.addAttribute("request",request);
		command = new MLoginCommand();
		command.execute(model);
		
		return "member/main";
	}
	
	//로그인 실패시
	@RequestMapping("/member/loginFail")
	public String loginFail(Model model) {
		return "redirect:login";
	}
	
	//회원가입 페이지
	@RequestMapping("/member/join")	
	public String join(Model model) {
		
		return "member/join";	//회원가입 완료 후 로그인 페이지로 이동
	}
	
	//회원가입 작성 후 DB입력
	@RequestMapping("/member/joinConfirm")
	public String joinConfirm(HttpServletRequest request,Model model) {
		
		model.addAttribute("request",request);
		command = new MJoinCommand();
		command.execute(model);
		
		return "redirect:login";
	}
	
	//로그인 성공후 페이지
	@RequestMapping("/member/main")
	public String main(Model model) {
		
		return "member/main";
	}
	
	//개인정보 확인 페이지
	@RequestMapping("/member/myInfo")
	public String myInfo(HttpServletRequest request, Model model) {
		//session내용이 request에 담겨있는가?
		model.addAttribute("request", request);	//session이 request객체에 담겨 사용되는지?
		command = new MMyInfoCommand();
		command.execute(model);
		return "member/myInfo";
	}
	
	//개인정보 수정 페이지
	@RequestMapping("/member/myInfoUpdate")
	public String myInfoUpdate(HttpServletRequest request, Model model) {
		//session내용이 request에 담겨있는가?
		model.addAttribute("request", request);	//session이 request객체에 담겨 사용되는지?
		command = new MMyInfoCommand();
		command.execute(model);
		return "member/myInfoUpdate";
	}
	
	//개인정보 수정 완료
	@RequestMapping("member/myInfoConfirm")
	public String myInfoConfirm(HttpServletRequest request, Model model) {
		
		return "member/main";
	}
	
	//관리자의 사용자 정보 확인 페이지
	@RequestMapping("/member/memberInfo")
	public String memberInfo(Model model) {
		return "member/memberInfo";
	}
	
	//board로 이동
	@RequestMapping("/member/board")
	public String board(Model model) {
		System.out.println("여기는 오나");
		return "redirect:board/list";	//url다시 관리해야함 member부분 삭제해야.
	}
	

}
