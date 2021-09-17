package com.javalec.ex.Day22;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		//xml�� �ƴ� Class�� ���� DI���.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student student = ctx.getBean("student1",Student.class);
		System.out.println("�̸� : "+student.getName());
		System.out.println("���� : "+student.getAge());
		System.out.println("��� : "+student.getHobby());
		System.out.println("Ű : "+student.getHeight());
		System.out.println("������ : "+student.getWeight());
		
		ctx.close();
	}

}
