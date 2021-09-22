package com.javalec.ex.Day33;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class Main {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();	//envȯ�� ����
		MutablePropertySources propertySources = env.getPropertySources();	//envȯ�� ��������
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));	//�ܺο��� env�Է�
			System.out.println(env.getProperty("admin.id"));	//�Էµ� env�κ��� ����
			System.out.println(env.getProperty("admin.pw"));
			
			GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;	//envȯ�� �״�� �Է�
			gCtx.load("applicationCTXDay33.xml");
			gCtx.refresh();

			AdminConnection admin = gCtx.getBean("adminConnection",AdminConnection.class);
			System.out.println("admin.id : "+ admin.getAdminId());
			System.out.println("admin.pw : "+ admin.getAdminPw());
			
			gCtx.close();
			ctx.close();
			
		} catch (Exception e) {
			
//			GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;	//envȯ�� �״�� �Է�
//			gCtx.load("applicationCTXDay33.xml");
//			gCtx.refresh();
//
//			AdminConnection admin = gCtx.getBean("adminConnection",AdminConnection.class);
//			System.out.println("admin.id : "+ admin.getAdminId());
//			System.out.println("admin.pw : "+ admin.getAdminPw());
//			
//			gCtx.close();
//			ctx.close();
		}
	}

}
