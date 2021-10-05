package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		//핵심 기능이라함은 xml을 받아와 main에서 실행하는 메소드인가?
		
		Student st = ctx.getBean("student",Student.class);
		st.getStudentInfo();	//핵심 기능
		
		//이 메소드는 xml의 어떤 정보값을 불러오진 않지만, xml 객체의 메소드이다.
		st.test();	//핵심기능이라 인식
		
		//이 객체는 xml을 참조하지 않는 객체이다.
		Student st1 = new Student();
		st1.test();	//이것을 핵심기능이라 인식하지 않는다.
		
		Worker wk = ctx.getBean("worker",Worker.class);
		wk.getWorkerInfo();		//핵심기능
		
		ctx.close();
		
		//즉, xml의 정보를 받아오든 말든, xml의 객체를 받아와 실행하는 메소드는 모두 핵심기능이라 생각한다.
		//핵심기능이라 생각되는 메소드를 분별하려면 
		//<aop:pointcut expression="within(com.javalec.ex.*)" id="publicM" />
		//여기서 expression을 조정하면 된다.
		
	}

}
