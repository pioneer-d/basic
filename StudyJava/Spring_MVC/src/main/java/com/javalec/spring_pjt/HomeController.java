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
//�̰��� @RequestMapping�� ���̸� �ٸ� ��� ������ �⺻���� �ȴ�.
//��, return������ �״�� view��θ� �Է��Ͽ����ϰ�, RequestMapping���� ����ȭ �� �� �ִ�.
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
	
	//�����͸� ���� �ʰ�, ������ �̵��� �� ���.
	@RequestMapping("/board/view")	//���⼭ ���� == ��û���
	public String view() {			//�޼ҵ� ���¸� ����� �޼ҵ���� ���������.(���� �ʿ�� ����.)
		
		return "board/view";
	}
	
	//model�� ���� �־� �̵���ų ���
	@RequestMapping("/board/content")
	public String content(Model model) {
		
		model.addAttribute("id",30);
		return "board/content";
		
	}
	
	
	//model and view��ü�� ���� ������ �̵�
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",30);
		mv.setViewName("board/reply");	//�ٸ��͵�� �ٸ��� ��ü�ȿ� ��θ� �־��ְ� �� ��ü�� return���ش�
		
		return mv;
	}
	
	
}




















