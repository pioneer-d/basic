package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {	//xml을 대신하는 클래스. proxy관련 기능은 xml에서 하기에 xml에서 연결
	
	@Pointcut("within(com.javalec.ex.*)")
	private void pointcutMethod() {
		//범위 지정하는 annotation
		//Before같은 annotation에는 쓰이지 않는다.
	}
	
	@Around("pointcutMethod()")	//Pointcut을 메소드명으로 가져온다
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
			System.out.println(signatureStr + "경과시간 : "+ (et - st));
		}
	}
	
	@Before("within(com.javalec.ex.*)")	//pointcut이 필요하지 않고 직접 범위를 입력.
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}

//	@Pointcut("execution(public void get*(..))")
	//public void인 모든 get메소드
//	@Pointcut("execution(* com.javalec.ex.*.*())")
	//com.javalec.ex 패키지에 파라미터가 없는 모든 메소드
//	@Pointcut("execution(* com.javalec.ex..*.*())")
	//com.javalec.ex 패키지 & com.javalec.ex 하위 패키지에 파라미터가 없는 모든 메소드
//	@Pointcut("execution(* com.javalec.ex.Worker.*())")
	//com.javalec.ex.Worker 안의 모든 메소드
	

//	@Pointcut("within(com.javalec.ex.*")
	//com.javalec.ex 패키지 안에 있는 모든 메소드
//	@Pointcut("within(com.javalec.ex..*")
	//com.javalec.ex 패키지 및 하위 패키지 안에 있는 모든 메소드
//	@Pointcut("within(com.javalec.ex.Worker")
	//con.or.sl.Worker의 모든 메소드
//	@Pointcut("within(com.javalec.ex.*)")	
	
//	@Pointcut("bean(student)")
	//student 빈에만 적용 (얘가 빈인것은 xml이 지정해주고 있음)
//	@Pointcut("bean(*ker)")
	//~ker로 끝나는 빈에만 적용
	
	
}
