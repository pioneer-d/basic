package com.javalec.ex.Day1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
//		MyCalculator myCal = new MyCalculator();	//�̰��� ���� ��ü�� �����Ѱ�.
//		myCal.setCal(new Calculator());
//		
//		myCal.setFirst(10);
//		myCal.setSecond(2);
//		
//		myCal.add();
//		myCal.sub();
//		myCal.mul();
//		myCal.div();	�� ����� Spring�� ���� Ȱ������ ���� ���.
		
		String configLocation = "classpath:applicationCTX.xml";	//xml�� �ּ�
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);	//xml�Ľ� ����//	������ �����̳� ����
		MyCalculator myCal = ctx.getBean("myCal",MyCalculator.class);									//	������ �����̳ʿ��� ������Ʈ ������
										//�̺κ��� xml���� bean�±��� id���̴�. �޺κ��� Ÿ��
		//�̰��� ���� ��ü�� �����Ѱ��� �ƴ�! xml���� ��ü�� �������ְ� ����!
		
		myCal.add();
		myCal.sub();
		myCal.mul();
		myCal.div();
		
	}

}
