package day6.singleton;

public class FirstClass {	
	
	public FirstClass() {
	
	//객체생성이 아닌 static메소드를 호출하여 객체를 불러온다.
	SingletonClass singleton = SingletonClass.getSingle();
	
	System.out.println("FirstClass입니다.");
	
	System.out.println(singleton.getI());	//10으로 설정이 되어있다.
	singleton.setI(200);
	System.out.println(singleton.getI());	
	//200으로 변경했다.	다른 클래스에서 이 객체를 불러와도 같은 객체를 공유하는 것이므로 여전히 i는 200일 것이다.
	
	System.out.println("");
	
	
	}
}
