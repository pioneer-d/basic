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
	
//	@RequestMapping(value = "/insertCheck", method = RequestMethod.GET)	//방법1
//	public String insertCheck(Student student, BindingResult result) {
//		
//		String page = "insertGood";	//유효성 검사를 정상적으로 마칠경우
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result);
//		
//		if(result.hasErrors()) {	//에러를 가지고 있는경우
//			page = "insertBad";
//		}
//		return page;
//	}
	
	@RequestMapping(value = "/insertCheck", method = RequestMethod.GET)	//방법2 Spring 활용
	public String insertCheck(@Validated Student student, BindingResult result) {
		
		String page = "insertGood";	//유효성 검사를 정상적으로 마칠경우
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		
		if(result.hasErrors()) {	//에러를 가지고 있는경우
			page = "insertBad";
		}
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}

}
