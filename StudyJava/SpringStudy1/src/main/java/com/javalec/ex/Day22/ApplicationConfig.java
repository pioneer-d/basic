package com.javalec.ex.Day22;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	//�̸� ���� DI���� �ϴ� Ŭ�������� ���.
public class ApplicationConfig {
	
	@Bean
	public Student student1() {
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("�ڵ�");
		hobby.add("������");
		
		Student student = new Student("���ؿ�",24,hobby);
		student.setHeight(170);
		student.setWeight(62);
		
		return student;
	}

}
