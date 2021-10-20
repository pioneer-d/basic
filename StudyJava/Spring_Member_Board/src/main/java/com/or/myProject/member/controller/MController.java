package com.or.myProject.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.or.myProject.Constant;
import com.or.myProject.member.command.MCommand;

@Controller
@RequestMapping("/member")	//이 클래스의 모든 맵핑 앞줄을 member로 고정.
public class MController {
	
	MCommand command;
	
//	public JdbcTemplate template;
//	
//	@Autowired
//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//		Constant.template = this.template;
//	}

	//로그인 페이지
	@RequestMapping("/login")
	public String login(Model model) {
		
		return "/member/login";
	}
	
	//로그인 검사
	@RequestMapping("/loginConfirm")
	public String loginConfirm(Model model) {
		return "";
	}
	
	//회원가입 페이지
	@RequestMapping("/join")	
	public String join(Model model) {
		
		return "member/join";	//회원가입 완료 후 로그인 페이지로 이동
	}
	
	//회원가입 작성 후 모델
	@RequestMapping("/joinConfirm")
	public String joinConfirm(Model model) {
		
		
		
		return "redirect:login";
	}
	
	//로그인 성공후 페이지
	@RequestMapping("/main")
	public String main(Model model) {
		return "member/main";
	}
	
	//개인정보 확인 페이지
	@RequestMapping("/myInfo")
	public String myInfo(Model model) {
		return "member/myInfo";
	}
	
	//개인정보 수정 페이지
	@RequestMapping("/myInfoUpdate")
	public String myInfoUpdate(Model model) {
		return "member/myInfoUpdate";
	}
	
	//관리자의 사용자 정보 확인 페이지
	@RequestMapping("memberInfo")
	public String memberInfo(Model model) {
		return "member/memberInfo";
	}
	
	

}
