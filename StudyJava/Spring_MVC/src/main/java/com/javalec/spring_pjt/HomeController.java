package com.javalec.spring_pjt;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
//이곳에 @RequestMapping을 붙이면 다른 모든 맵핑의 기본값이 된다.
//단, return값에는 그대로 view경로를 입력하여야하고, RequestMapping값만 간소화 할 수 있다.
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//데이터를 담지 않고, 페이지 이동만 할 경우.
	@RequestMapping("/board/view")	//여기서 맵핑 == 요청경로
	public String view() {			//메소드 형태를 만들고 메소드명은 사용자정의.(같을 필요는 없다.)
		
		return "board/view";
	}
	
	//model에 값을 넣어 이동시킬 경우
	@RequestMapping("/board/content")
	public String content(Model model) {
		
		model.addAttribute("id",30);
		return "board/content";
		
	}
	
	
	//model and view객체를 통한 페이지 이동
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",30);
		mv.setViewName("board/reply");	//다른것들과 다르게 객체안에 경로를 넣어주고 그 객체를 return해준다
		
		return mv;
	}
	
	
}




















