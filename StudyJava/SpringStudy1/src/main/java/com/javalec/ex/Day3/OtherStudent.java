package com.javalec.ex.Day3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent{

	private String name;
	private int age;
	
	public OtherStudent(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@PostConstruct
	public void initMethod() {	//왜 자동으로 호출이 안되는거지
		System.out.println("PostConstruct 메소드");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("PreDestroy 메소드");
	}

}
