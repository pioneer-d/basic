package com.javalec.ex.Day4;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	//핵심기능에 필요한 공통기능(메소드)임!
	//xml에서 설정하여 다른 필요한 곳에서 사용할 수 있도록 설정.
	//이 기능은 다른 핵심기능이 실행되는 시간을 구하는 메소드
	public Object loggerAop(ProceedingJoinPoint joinpoint)throws Throwable{
		
		//joinpoint.getSignature().toShortString()
		//joinpoint = 진행중인 핵심기능 부분
		//getSignature = 호출되는 메소드의 정보를 구함
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "is start");
		long st = System.currentTimeMillis();	//시작시점 시간 구하기
		
		try {
			//이때 핵심기능을 하는 메소드가 실행됨
			//그러므로 이 코드 전후로 공통기능을 위한 코드를 위치시키면 됨.
			Object obj = joinpoint.proceed();
			return obj;
		}finally {
			long et = System.currentTimeMillis();	//종료시점 시간 구하기
			System.out.println(signatureStr + "is finished");
			System.out.println(signatureStr + "경과시간 :"+(et-st));
		}
		
	}

}
