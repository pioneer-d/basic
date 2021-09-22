package com.javalec.ex.Day33;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class Main {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();	//env환경 생성
		MutablePropertySources propertySources = env.getPropertySources();	//env환경 가져오기
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));	//외부에서 env입력
			System.out.println(env.getProperty("admin.id"));	//입력된 env로부터 추출
			System.out.println(env.getProperty("admin.pw"));
			
			GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;	//env환경 그대로 입력
			gCtx.load("applicationCTXDay33.xml");
			gCtx.refresh();

			AdminConnection admin = gCtx.getBean("adminConnection",AdminConnection.class);
			System.out.println("admin.id : "+ admin.getAdminId());
			System.out.println("admin.pw : "+ admin.getAdminPw());
			
			gCtx.close();
			ctx.close();
			
		} catch (Exception e) {
			
//			GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;	//env환경 그대로 입력
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
