package com.javalec.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {	//�̵� ��� url�� �����͸� �Է��Ѵ�.
	
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
	
	@RequestMapping("/member2")	////������ Ŭ������ Ȱ���� ������ ó��2 (@ModelAttribute)
	public String member2(@ModelAttribute("reMember") Member member) {
		//������ Ŭ������ Member�� ���������, jsp���� ���� �� ����ϴ� EL�������� reMember�̴�.
		return "member2";
	}
	
	@RequestMapping("/pathVariable/{id}")	//@PathVariable�� Ȱ���� ������ ó��
	public String pathVariable(@PathVariable String id, Model model) {
		
		model.addAttribute("id",id);
		
		return "pathVariable";
		
	}
	
	
	//������� ��û���
	@RequestMapping("/students/index")	//index jsp���� ���� �Է��ϰ�
	public String index() {
		return "students/index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "students/student")	//�̶� value�� jsp�� action��
	public String student(HttpServletRequest http, Model model) {
		
		String name = http.getParameter("name");	//jsp�� name������ ������ �ҷ���
		System.out.println(name);
		model.addAttribute("name",name);
		
		return "students/student";
	}
	
	//�̷������� get,post��� �ΰ��� ��� ��밡��.
	@RequestMapping(method = RequestMethod.POST, value = "students/student")	//�̶� value�� jsp�� action��
	public ModelAndView student(HttpServletRequest http) {
		
		String name = http.getParameter("name");	//jsp�� name������ ������ �ҷ���
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",name);
		mv.setViewName("students/student");
		
		return mv;
	}
	
	
	//������� redirect
	@RequestMapping("/redirect")
	public String redirect(HttpServletRequest http, Model model) {
		
		String id = http.getParameter("id");
		
		if(id.equals("admin")) {
			model.addAttribute("id",id);	//�� �۾��� ����� ������ �̵��� �ȴ�!
			return "redirect:redirectA";	//Controller�� �ٽ� �̵�	�̶� �� return�κ��� ���� url���� �ȴ�.
		}else {
			model.addAttribute("id",id);	
			return "redirect:redirectB";	//Controller�� �ٽ� �̵�
		}
	}
	
	@RequestMapping("/redirectA")
	public String redirectA(HttpServletRequest http, Model model) {
		
		String id = http.getParameter("id");
		System.out.println(id); 	//�̶� id���� ������ OK
		model.addAttribute("id",id);
		
		return "redirect/redirectA";	
		//http://localhost:8181/ex/redirectA?id=admin �̷��� url�� ���´�.
	}
		
	@RequestMapping("/redirectB")
	public String redirectB(HttpServletRequest http, Model model) {
		
		String id = http.getParameter("id");
		System.out.println(id); 	//�̶� id���� ������ OK
		model.addAttribute("id",id);
		
		return "redirect/redirectB";
	}
	
	

}
