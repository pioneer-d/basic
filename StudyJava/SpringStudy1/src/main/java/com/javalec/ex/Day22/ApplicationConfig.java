package com.javalec.ex.Day22;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	//이를 통해 DI역할 하는 클래스임을 명시.
public class ApplicationConfig {
	
	@Bean
	public Student student1() {
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("코딩");
		hobby.add("배드민턴");
		
		Student student = new Student("동준영",24,hobby);
		student.setHeight(170);
		student.setWeight(62);
		
		return student;
	}

}
