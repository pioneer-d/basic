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
import com.or.myProject.member.command.MMemberDeleteCommand;
import com.or.myProject.member.command.MMemberListCommand;
import com.or.myProject.member.command.MMemberInfoCommand;
import com.or.myProject.member.command.MMyInfoCommand;
import com.or.myProject.member.command.MMyInfoDelete;
import com.or.myProject.member.command.MMyInfoUpdateCommand;

@Controller
@RequestMapping("/member")
public class MController {
	
	MCommand command;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	//�α��� ������
	@RequestMapping("login")
	public String login(Model model) {
		
		return "/member/login";
	}
	
	//�α��� �˻�
	@RequestMapping("loginConfirm")		//form���� �޾ƿ��� ���� request���
	public String loginConfirm(HttpServletRequest request, Model model) {
		
		model.addAttribute("request",request);
		command = new MLoginCommand();
		command.execute(model);
		
		return "member/main";
	}
	
	//�α��� ���н�
	@RequestMapping("loginFail")
	public String loginFail(Model model) {
		return "redirect:login";
	}
	
	//ȸ������ ������
	@RequestMapping("join")	
	public String join(Model model) {
		return "member/join";	//ȸ������ �Ϸ� �� �α��� �������� �̵�
	}
	
	//ȸ������ �ۼ� �� DB�Է�
	@RequestMapping("joinConfirm")
	public String joinConfirm(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command = new MJoinCommand();
		command.execute(model);
		return "redirect:login";
	}
	
	//�α��� ������ ������
	@RequestMapping("main")
	public String main(Model model) {
		return "member/main";
	}
	
	//�������� Ȯ�� ������
	@RequestMapping("myInfo")
	public String myInfo(HttpServletRequest request, Model model) {
		//session������ request�� ����ִ°�?
		model.addAttribute("request", request);	//session�� request��ü�� ��� ���Ǵ���?
		command = new MMyInfoCommand();
		command.execute(model);
		return "member/myInfo";
	}
	
	//�������� ���� ������
	@RequestMapping("myInfoUpdate")
	public String myInfoUpdate(HttpServletRequest request, Model model) {
		//session������ request�� ����ִ°�? �����׷���
		model.addAttribute("request", request);
		command = new MMyInfoCommand();
		command.execute(model);
		return "member/myInfoUpdate";
	}
	
	//�������� ���� �Ϸ�
	@RequestMapping("myInfoConfirm")
	public String myInfoConfirm(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new MMyInfoUpdateCommand();
		command.execute(model);
		return "member/main";
	}
	
	//�������� ����� ����Ʈ ������
	@RequestMapping("memberInfo")
	public String memberInfo(Model model) {
		command = new MMemberListCommand();
		command.execute(model);
		return "member/memberInfo";
	}
	
	//�������� ����� ���� ������
	@RequestMapping("memberModify")
	public String memberModify(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new MMemberInfoCommand();
		command.execute(model);
		return "member/memberModify";
	}
	
	//�������� ����� ���� �Ϸ�
	@RequestMapping("memberInfoUpdateConfirm")
	public String memberInfoUpdateConfirm(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new MMyInfoUpdateCommand();
		command.execute(model);
		return "member/main";
	}
	
	//�����ڰ� ȸ��Ż��
	@RequestMapping("memberInfoDelete")
	public String memberInfoDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new MMemberDeleteCommand();
		command.execute(model);
		
		return "member/main";
	}
	
	//����ڰ� ȸ��Ż��
	@RequestMapping("myInfoDelete")
	public String myInfoDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new MMyInfoDelete();
		command.execute(model);
		
		return "member/login";
	}
	

}
