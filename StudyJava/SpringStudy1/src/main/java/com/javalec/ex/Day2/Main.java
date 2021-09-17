package com.javalec.ex.Day2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		StudentInfo sIf = ctx.getBean("sIf",StudentInfo.class);		//생성자를 통한 주입
		sIf.getStudentInfo();
		
		Student student = ctx.getBean("student2",Student.class);	//활용버전
		sIf.setStudent(student);
		sIf.getStudentInfo();
		
		ctx.close();

	}

}
