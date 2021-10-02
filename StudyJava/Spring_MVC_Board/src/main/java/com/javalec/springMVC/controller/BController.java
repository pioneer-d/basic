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
	
	BCommand command;	//���� �ϰ�, �ʱ�ȭ�� ����Ҷ����� �ٸ��͵� ���(��� �̸� �����ϰ� �����Ƿ� ������ Ÿ���� ������ �� ����)
	
	@RequestMapping("/list")	//��� �� �ҷ�����
	public String list(Model model) {
		
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")	//�� �ۼ� �������� �̵�
	public String write_view(Model model) {	//model�� ���� �ʿ��Ѱ�?
		
		return "write_view";
	}
	
	@RequestMapping("/write")		//�ۼ��� ���� ������ �ø��� ���� ��ġ�� �ٽ� list�� �̵�
	public String write(HttpServletRequest request, Model model) {
						//form�� ���� �޾ƿ��� ������ HttpServletRequest��ü ���
		model.addAttribute("request",request);
		
		command = new BWriteCommanad();
		command.execute(model);
		
		return "redirect:list";
	}

	@RequestMapping("/content_view")		//�� 1�� �ڼ��� ����
	public String content_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request",request);
		
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/modify")			//�� �����ϱ�
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request",request);
		
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}

	@RequestMapping("/reply_view")		//�亯����
	public String reply_view(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")		//�亯�ޱ�
	public String reply(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		
		command = new BReplyCommand();
		command.execute(model);
		
		return "reply";
	}
	
	@RequestMapping("/delete")		//�� �����ϱ�
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
		
	}
}
