package com.javalec.ex.Day33;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware,InitializingBean{
	
	private Environment env;
	private String adminId;
	private String adminPw;
	
	@Override	//EnvironmentAware의 오버라이딩
	public void setEnvironment(Environment environment) {	//이 빈이 생성될때 바로 실행됨.
		System.out.println("setEnvironment()");
		setEnv(environment);	//env받아옴
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {	//받아온 env를 이곳에 입력시킴. 그럼 xml에서 이 value들을 사용 가능하다.
		System.out.println("afterPropertiesSet()");
		setAdminId(env.getProperty("admin.id"));
		setAdminPw(env.getProperty("admin.pw"));
	}
	
	public Environment getEnv() {
		return env;
	}
	public void setEnv(Environment env) {
		this.env = env;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

}
