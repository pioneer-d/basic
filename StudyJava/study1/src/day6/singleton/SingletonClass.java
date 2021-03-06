package day6.singleton;

public class SingletonClass {	//싱글톤 패턴 이해하기
	
	//이 변수가 메소드를 통해 객체를 전달해주는 변수이다.
	private static SingletonClass SINGLETON_CLASS_INSTANCE;
	public int i = 10;
	
	private SingletonClass() {	//생성자를 private로 선언하여 객체생성을 막는다.
		//객체생성을 통해 객체를 여러개로 만드는것을 막고
		//static메소드를 통해 객체를 전달하여 이 클래스를 전역으로 쓸수 있도록 하는것이 목적임.
		
	}
	
	public static SingletonClass getSingle() {
		
		if(SINGLETON_CLASS_INSTANCE == null) {	//FirstClass에서 이 메소드를 호출할때 객체가 입력될것.
			SINGLETON_CLASS_INSTANCE = new SingletonClass();
		}	//사실 이럴 필요없이 필드값에서 new해놓으면 되지않나..
		
		return SINGLETON_CLASS_INSTANCE;	//SecondClass에서는 이미 FirstClass가 객체를 입력했으므로 바로 return으로 올것.
		//리턴타입이 이 클래스 자체이고, 변수고 이 클래스 자체이다.
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	

}
