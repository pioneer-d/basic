package com.javalec.ex;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {	//검증할 객체의 클래스 타입 정보 기입
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Student student = (Student)target;
		
		String name = student.getName();
		if(name == null || name.trim().isEmpty()) {
			System.out.println("이름을 입력안함");
			errors.rejectValue("name", "trouble");
		}
		
		int id = student.getId();
		if(id == 0) {
			System.out.println("id 입력안하거나 0임");
			errors.rejectValue("id", "trouble");
		}
		
	}
	

}
