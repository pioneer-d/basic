package com.javalec.ex;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {	//������ ��ü�� Ŭ���� Ÿ�� ���� ����
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Student student = (Student)target;
		
		String name = student.getName();
		if(name == null || name.trim().isEmpty()) {
			System.out.println("�̸��� �Է¾���");
			errors.rejectValue("name", "trouble");
		}
		
		int id = student.getId();
		if(id == 0) {
			System.out.println("id �Է¾��ϰų� 0��");
			errors.rejectValue("id", "trouble");
		}
		
	}
	

}
