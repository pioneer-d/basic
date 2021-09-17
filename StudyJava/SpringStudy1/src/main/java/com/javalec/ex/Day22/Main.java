package com.javalec.ex.Day22;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		//xml이 아닌 Class를 통한 DI방법.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student student = ctx.getBean("student1",Student.class);
		System.out.println("이름 : "+student.getName());
		System.out.println("나이 : "+student.getAge());
		System.out.println("취미 : "+student.getHobby());
		System.out.println("키 : "+student.getHeight());
		System.out.println("몸무게 : "+student.getWeight());
		
		ctx.close();
	}

}
