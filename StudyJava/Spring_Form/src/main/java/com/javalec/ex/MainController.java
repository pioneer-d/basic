package com.javalec.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {	//이들 모두 url에 데이터를 입력한다. Get방식의 incoding이 필요.(Server에서 함)
	
	@RequestMapping("/httpServletRequest")//HttpServletRequest를 활용한 데이터 처리
	//(기본적으로 views폴더는 default이다. servlet-context에서 지정했기때문.)
	public String httpServletRequest(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");	//데이터 받아옴
		String pw = httpServletRequest.getParameter("pw");
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "httpServletRequest";
	}
	
	@RequestMapping("/requestParam")	//@RequestParam을 활용한 데이터 처리
	public String requestParam(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "requestParam";
		
	}
	
	@RequestMapping("/member")	//데이터 클래스를 활용한 데이터 처리
	public String member(Member member) {
		//이때 IE에서 실행하지 말고, chrome에서 실행하자
		return "member";
	}
	
	@RequestMapping("/pathVariable/{id}")	//@PathVariable을 활용한 데이터 처리
	public String pathVariable(@PathVariable String id, Model model) {
		
		model.addAttribute("id",id);
		
		return "pathVariable";
		
	}
	
	
	

}
