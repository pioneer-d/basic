package com.javalec.ex.Day3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {	//�����ֱ� �� scope
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();	//����
		
		ctx.load("classpath:applicationCTXDay3.xml");	//����
		
		ctx.refresh();
		
		//���
		Student st = ctx.getBean("student",Student.class);
		System.out.println("�̸� : "+st.getName());
		System.out.println("���� : "+st.getAge());
		
		Student st1 = ctx.getBean("student",Student.class);
		st1.setName("��±�");
		st1.setAge(23);
		System.out.println("�̸� : "+st1.getName());
		System.out.println("���� : "+st1.getAge());
		
		System.out.println(st == st1);
		//���ݰ� �̷��� ����� �ϸ� �ٸ� ��ü�� �ν� �ϰ�����, 
		//xml���� ��ü�� �����ϰ� �����ϴ� ����̱� ������ ���� ��ü�̴�.
		
		ctx.close();	//����
		
	}

}
