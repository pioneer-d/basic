package com.javalec.ex.Day4;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	//�ٽɱ�ɿ� �ʿ��� ������(�޼ҵ�)��!
	//xml���� �����Ͽ� �ٸ� �ʿ��� ������ ����� �� �ֵ��� ����.
	//�� ����� �ٸ� �ٽɱ���� ����Ǵ� �ð��� ���ϴ� �޼ҵ�
	public Object loggerAop(ProceedingJoinPoint joinpoint)throws Throwable{
		
		//joinpoint.getSignature().toShortString()
		//joinpoint = �������� �ٽɱ�� �κ�
		//getSignature = ȣ��Ǵ� �޼ҵ��� ������ ����
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "is start");
		long st = System.currentTimeMillis();	//���۽��� �ð� ���ϱ�
		
		try {
			//�̶� �ٽɱ���� �ϴ� �޼ҵ尡 �����
			//�׷��Ƿ� �� �ڵ� ���ķ� �������� ���� �ڵ带 ��ġ��Ű�� ��.
			Object obj = joinpoint.proceed();
			return obj;
		}finally {
			long et = System.currentTimeMillis();	//������� �ð� ���ϱ�
			System.out.println(signatureStr + "is finished");
			System.out.println(signatureStr + "����ð� :"+(et-st));
		}
		
	}

}
