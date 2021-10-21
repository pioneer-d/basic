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
	
	//�α��� �˻�
	@RequestMapping("/loginConfirm")		//form���� �޾ƿ��� ���� request���
	public String loginConfirm(HttpServletRequest request, Model model) {
		
		model.addAttribute(request);
		
		return "";
	}
	
	//ȸ������ ������
	@RequestMapping("/join")	
	public String join(Model model) {
		
		return "member/join";	//ȸ������ �Ϸ� �� �α��� �������� �̵�
	}
	
	//ȸ������ �ۼ� �� ��
	@RequestMapping("/joinConfirm")
	public String joinConfirm(HttpServletRequest request,Model model) {
		
		model.addAttribute("request",request);
		command = new MJoinCommand();
		command.execute(model);
		
		return "redirect:login";
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
