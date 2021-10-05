package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		//�ٽ� ����̶����� xml�� �޾ƿ� main���� �����ϴ� �޼ҵ��ΰ�?
		
		Student st = ctx.getBean("student",Student.class);
		st.getStudentInfo();	//�ٽ� ���
		
		//�� �޼ҵ�� xml�� � �������� �ҷ����� ������, xml ��ü�� �޼ҵ��̴�.
		st.test();	//�ٽɱ���̶� �ν�
		
		//�� ��ü�� xml�� �������� �ʴ� ��ü�̴�.
		Student st1 = new Student();
		st1.test();	//�̰��� �ٽɱ���̶� �ν����� �ʴ´�.
		
		Worker wk = ctx.getBean("worker",Worker.class);
		wk.getWorkerInfo();		//�ٽɱ��
		
		ctx.close();
		
		//��, xml�� ������ �޾ƿ��� ����, xml�� ��ü�� �޾ƿ� �����ϴ� �޼ҵ�� ��� �ٽɱ���̶� �����Ѵ�.
		//�ٽɱ���̶� �����Ǵ� �޼ҵ带 �к��Ϸ��� 
		//<aop:pointcut expression="within(com.javalec.ex.*)" id="publicM" />
		//���⼭ expression�� �����ϸ� �ȴ�.
		
	}

}
