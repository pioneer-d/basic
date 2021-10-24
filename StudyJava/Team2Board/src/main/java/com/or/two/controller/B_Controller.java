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
	
	@Autowired	//�ڵ����� ��ü ������ ���ִ� ����!
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")		//�Խù� ����Ʈ
	public String list(Model model) {
		
		command = new B_ListCommand();
		command.execute(model);
		
		return "board/list";
	}
	
	@RequestMapping("/list2")		//�Խù� ����Ʈ(���� ���� �������)
	public String list2(Model model) {
		
		command = new B_ListCommand();
		command.execute(model);
		
		return "board/list2";
	}
	
	@RequestMapping("/list3")		//�Խù� ����Ʈ(���� ���� �������)
	public String list3(Model model) {
		
		command = new B_ListCommand();
		command.execute(model);
		
		return "board/list3";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {	//write.jsp�� �̵�.
		return "board/write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {	//write�� ����Ʈ�� �̵�
		
		model.addAttribute("request",request);	//request�� model�� ����.
		command = new B_WriteCommand();
		command.execute(model);	//model�� ���´ٰ� �ٽ� ������ �����.(model�� request�� ���ԵǾ� ����.)
		
		return "redirect:list";	//�ٽ� list�� �����ִ°���. �׷� �� list���ΰ��� db��ȴٰ� ������ְڳ�.
	}
	
	@RequestMapping("/content_view")		//�Խù� ��ȸ
	public String content_view(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new B_ContentCommand();
		command.execute(model);
		return "board/content_view";
	}
	
	@RequestMapping("/delete")			//�Խù� ����
	public String delete(HttpServletRequest request ,Model model) throws IOException {
		
		model.addAttribute("request",request);
		command2 = new B_DeleteCommand();
		command2.execute(model);
		
		if(command2.execute(model) == true) {
			return "redirect:list";
		}return "redirect:list2";
		
	}
	
	@RequestMapping("/reply_view")		//��۴ޱ� �غ�
	public String reply_view(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new B_ReplyViewCommand();
		command.execute(model);
		
		return "board/reply_view";
	}
	
	@RequestMapping("/reply")			//��۴ޱ�
	public String reply(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new B_ReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/modify")			//�����ϱ�
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
