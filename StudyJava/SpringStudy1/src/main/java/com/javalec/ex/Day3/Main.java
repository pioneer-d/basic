package com.javalec.ex.Day3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {	//생명주기 및 scope
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();	//생성
		
		ctx.load("classpath:applicationCTXDay3.xml");	//설정
		
		ctx.refresh();
		
		//사용
		Student st = ctx.getBean("student",Student.class);
		System.out.println("이름 : "+st.getName());
		System.out.println("나이 : "+st.getAge());
		
		Student st1 = ctx.getBean("student",Student.class);
		st1.setName("김승기");
		st1.setAge(23);
		System.out.println("이름 : "+st1.getName());
		System.out.println("나이 : "+st1.getAge());
		
		System.out.println(st == st1);
		//지금것 이렇게 사용을 하면 다른 객체로 인식 하겠지만, 
		//xml에서 객체를 생성하고 주입하는 방식이기 때문에 같은 객체이다.
		
		ctx.close();	//종료
		
	}

}
