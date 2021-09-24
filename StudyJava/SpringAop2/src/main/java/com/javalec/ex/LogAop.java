package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {	//xml�� ����ϴ� Ŭ����. proxy���� ����� xml���� �ϱ⿡ xml���� ����
	
	@Pointcut("within(com.javalec.ex.*)")
	private void pointcutMethod() {
		//���� �����ϴ� annotation
		//Before���� annotation���� ������ �ʴ´�.
	}
	
	@Around("pointcutMethod()")	//Pointcut�� �޼ҵ������ �����´�
	public Object loggerAop(ProceedingJoinPoint joinpoint)throws Throwable{
		
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		}finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "is finished.");
			System.out.println(signatureStr + "����ð� : "+ (et - st));
		}
	}
	
	@Before("within(com.javalec.ex.*)")	//pointcut�� �ʿ����� �ʰ� ���� ������ �Է�.
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}

//	@Pointcut("execution(public void get*(..))")
	//public void�� ��� get�޼ҵ�
//	@Pointcut("execution(* com.javalec.ex.*.*())")
	//com.javalec.ex ��Ű���� �Ķ���Ͱ� ���� ��� �޼ҵ�
//	@Pointcut("execution(* com.javalec.ex..*.*())")
	//com.javalec.ex ��Ű�� & com.javalec.ex ���� ��Ű���� �Ķ���Ͱ� ���� ��� �޼ҵ�
//	@Pointcut("execution(* com.javalec.ex.Worker.*())")
	//com.javalec.ex.Worker ���� ��� �޼ҵ�
	

//	@Pointcut("within(com.javalec.ex.*")
	//com.javalec.ex ��Ű�� �ȿ� �ִ� ��� �޼ҵ�
//	@Pointcut("within(com.javalec.ex..*")
	//com.javalec.ex ��Ű�� �� ���� ��Ű�� �ȿ� �ִ� ��� �޼ҵ�
//	@Pointcut("within(com.javalec.ex.Worker")
	//con.or.sl.Worker�� ��� �޼ҵ�
//	@Pointcut("within(com.javalec.ex.*)")	
	
//	@Pointcut("bean(student)")
	//student �󿡸� ���� (�갡 ���ΰ��� xml�� �������ְ� ����)
//	@Pointcut("bean(*ker)")
	//~ker�� ������ �󿡸� ����
	
	
}
