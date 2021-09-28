package com.javalec.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {	//�̵� ��� url�� �����͸� �Է��Ѵ�. Get����� incoding�� �ʿ�.(Server���� ��)
	
	@RequestMapping("/httpServletRequest")//HttpServletRequest�� Ȱ���� ������ ó��
	//(�⺻������ views������ default�̴�. servlet-context���� �����߱⶧��.)
	public String httpServletRequest(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");	//������ �޾ƿ�
		String pw = httpServletRequest.getParameter("pw");
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "httpServletRequest";
	}
	
	@RequestMapping("/requestParam")	//@RequestParam�� Ȱ���� ������ ó��
	public String requestParam(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "requestParam";
		
	}
	
	@RequestMapping("/member")	//������ Ŭ������ Ȱ���� ������ ó��
	public String member(Member member) {
		//�̶� IE���� �������� ����, chrome���� ��������
		return "member";
	}
	
	@RequestMapping("/pathVariable/{id}")	//@PathVariable�� Ȱ���� ������ ó��
	public String pathVariable(@PathVariable String id, Model model) {
		
		model.addAttribute("id",id);
		
		return "pathVariable";
		
	}
	
	
	

}
