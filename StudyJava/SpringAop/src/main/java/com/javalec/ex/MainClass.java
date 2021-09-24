package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student st = ctx.getBean("student",Student.class);
		st.getStudentInfo();
		
		Worker wk = ctx.getBean("worker",Worker.class);
		wk.getWorkerInfo();
		
		ctx.close();
		
	}

}
