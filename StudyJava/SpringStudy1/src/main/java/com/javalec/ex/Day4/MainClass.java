package com.javalec.ex.Day4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTXDay4.xml");
		
		Student sd = ctx.getBean("student",Student.class);
		sd.getStudentInfo();
		
		Worker wk = ctx.getBean("worker",Worker.class);
		wk.getWorkerInfo();
		
		ctx.close();
		
	}

}
