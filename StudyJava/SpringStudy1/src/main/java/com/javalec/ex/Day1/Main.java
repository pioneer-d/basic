package com.javalec.ex.Day1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
//		MyCalculator myCal = new MyCalculator();	//이것은 직접 객체를 생성한것.
//		myCal.setCal(new Calculator());
//		
//		myCal.setFirst(10);
//		myCal.setSecond(2);
//		
//		myCal.add();
//		myCal.sub();
//		myCal.mul();
//		myCal.div();	이 방법은 Spring을 전혀 활용하지 않은 기법.
		
		String configLocation = "classpath:applicationCTX.xml";	//xml의 주소
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);	//xml파싱 과정//	스프링 컨테이너 생성
		MyCalculator myCal = ctx.getBean("myCal",MyCalculator.class);									//	스프링 컨테이너에서 컴포넌트 가져옴
										//이부분이 xml파일 bean태그의 id값이다. 뒷부분은 타입
		//이것은 직접 객체를 생성한것이 아님! xml에서 객체를 주입해주고 있음!
		
		myCal.add();
		myCal.sub();
		myCal.mul();
		myCal.div();
		
	}

}
