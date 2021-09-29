package com.javalec.ex;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = "/insert")
	public String insert() {
		return "insert";
	}
	
//	@RequestMapping(value = "/insertCheck", method = RequestMethod.GET)	//���1
//	public String insertCheck(Student student, BindingResult result) {
//		
//		String page = "insertGood";	//��ȿ�� �˻縦 ���������� ��ĥ���
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result);
//		
//		if(result.hasErrors()) {	//������ ������ �ִ°��
//			page = "insertBad";
//		}
//		return page;
//	}
	
	@RequestMapping(value = "/insertCheck", method = RequestMethod.GET)	//���2 Spring Ȱ��
	public String insertCheck(@Validated Student student, BindingResult result) {
		
		String page = "insertGood";	//��ȿ�� �˻縦 ���������� ��ĥ���
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		
		if(result.hasErrors()) {	//������ ������ �ִ°��
			page = "insertBad";
		}
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}

}
