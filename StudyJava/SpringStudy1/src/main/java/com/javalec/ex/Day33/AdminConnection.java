package com.javalec.ex.Day33;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware,InitializingBean{
	
	private Environment env;
	private String adminId;
	private String adminPw;
	
	@Override	//EnvironmentAware�� �������̵�
	public void setEnvironment(Environment environment) {	//�� ���� �����ɶ� �ٷ� �����.
		System.out.println("setEnvironment()");
		setEnv(environment);	//env�޾ƿ�
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {	//�޾ƿ� env�� �̰��� �Է½�Ŵ. �׷� xml���� �� value���� ��� �����ϴ�.
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
