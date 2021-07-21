package day6.singleton;

public class SecondClass {
	
	public SecondClass() {
		
	SingletonClass singleton = SingletonClass.getSingle();	//FirstClass와 공유하는 객체
	
	System.out.println("SecondClass 입니다");
	
	System.out.println(singleton.getI());	
	//원래는 10이지만
	//FirstClass에서 200으로 변경했고, 같은 객체이므로 여전히 200으로 나올것이다.
	
	}
}
