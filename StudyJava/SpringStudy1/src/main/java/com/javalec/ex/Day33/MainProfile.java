package com.javalec.ex.Day33;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainProfile {

	public static void main(String[] args) {
		
		String config = null;
		Scanner sc = new Scanner(System.in);	//dev, run 둘중 하나 입력
		
		String str = sc.next();
		if(str.equals("dev")) {
			config = str;
		}else if(str.equals("run")) {
			config = str;
		}
		
		sc.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);	//profile입력
		ctx.load("classpath:applicationCTXDay33Profile.xml","classpath:applicationCTXDay33Profile2.xml");
		
		ServerInfo si = ctx.getBean("serverInfo",ServerInfo.class);
		System.out.println("ip : "+si.getIp());
		System.out.println("port : "+si.getPort());
		
		ctx.close();
		
		
	}
	
}
