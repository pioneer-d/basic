package com.or.myProject.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.or.myProject.Constant;
import com.or.myProject.member.command.MCommand;

@Controller
@RequestMapping("/member")	//�� Ŭ������ ��� ���� ������ member�� ����.
public class MController {
	
	MCommand command;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	//�α��� ������
	@RequestMapping("/login")
	public String login(Model model) {
		
		return "/member/login";
	}
	
	//ȸ������ ������
	@RequestMapping("/join")	
	public String join(Model model) {
		
		return "member/join";	//ȸ������ �Ϸ� �� �α��� �������� �̵�
	}
	
	//�α��� ������ ������
	@RequestMapping("/main")
	public String main(Model model) {
		return "member/main";
	}
	
	//�������� Ȯ�� ������
	@RequestMapping("/myInfo")
	public String myInfo(Model model) {
		return "member/myInfo";
	}
	
	//�������� ���� ������
	@RequestMapping("/myInfoUpdate")
	public String myInfoUpdate(Model model) {
		return "member/myInfoUpdate";
	}
	
	//�������� ����� ���� Ȯ�� ������
	@RequestMapping("memberInfo")
	public String memberInfo(Model model) {
		return "member/memberInfo";
	}
	
	

}
