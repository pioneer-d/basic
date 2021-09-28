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
public class MainController {	//이들 모두 url에 데이터를 입력한다.
	
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
	
	@RequestMapping("/member2")	////데이터 클래스를 활용한 데이터 처리2 (@ModelAttribute)
	public String member2(@ModelAttribute("reMember") Member member) {
		//데이터 클래스는 Member을 사용하지만, jsp에서 받을 때 사용하는 EL참조값은 reMember이다.
		return "member2";
	}
	
	@RequestMapping("/pathVariable/{id}")	//@PathVariable을 활용한 데이터 처리
	public String pathVariable(@PathVariable String id, Model model) {
		
		model.addAttribute("id",id);
		
		return "pathVariable";
		
	}
	
	
	//여기부터 요청방식
	@RequestMapping("/students/index")	//index jsp에서 값을 입력하고
	public String index() {
		return "students/index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "students/student")	//이때 value는 jsp의 action값
	public String student(HttpServletRequest http, Model model) {
		
		String name = http.getParameter("name");	//jsp의 name값으로 데이터 불러옴
		System.out.println(name);
		model.addAttribute("name",name);
		
		return "students/student";
	}
	
	//이런식으로 get,post방식 두가지 모두 사용가능.
	@RequestMapping(method = RequestMethod.POST, value = "students/student")	//이때 value는 jsp의 action값
	public ModelAndView student(HttpServletRequest http) {
		
		String name = http.getParameter("name");	//jsp의 name값으로 데이터 불러옴
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",name);
		mv.setViewName("students/student");
		
		return mv;
	}
	
	
	//여기부터 redirect
	@RequestMapping("/redirect")
	public String redirect(HttpServletRequest http, Model model) {
		
		String id = http.getParameter("id");
		
		if(id.equals("admin")) {
			model.addAttribute("id",id);	//이 작업을 해줘야 데이터 이동이 된다!
			return "redirect:redirectA";	//Controller로 다시 이동	이때 이 return부분이 최종 url값이 된다.
		}else {
			model.addAttribute("id",id);	
			return "redirect:redirectB";	//Controller로 다시 이동
		}
	}
	
	@RequestMapping("/redirectA")
	public String redirectA(HttpServletRequest http, Model model) {
		
		String id = http.getParameter("id");
		System.out.println(id); 	//이때 id값이 찍히면 OK
		model.addAttribute("id",id);
		
		return "redirect/redirectA";	
		//http://localhost:8181/ex/redirectA?id=admin 이렇게 url에 나온다.
	}
		
	@RequestMapping("/redirectB")
	public String redirectB(HttpServletRequest http, Model model) {
		
		String id = http.getParameter("id");
		System.out.println(id); 	//이때 id값이 찍히면 OK
		model.addAttribute("id",id);
		
		return "redirect/redirectB";
	}
	
	

}
