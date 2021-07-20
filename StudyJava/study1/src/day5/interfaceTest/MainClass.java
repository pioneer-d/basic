package day5.interfaceTest;

public class MainClass {
	
	public static void main(String[] args) {
		
		//두개의 interface를 상속하는 클래스가 객체타입인 경우
		InterfaceImplementClass inter = new InterfaceImplementClass();
		
		//두개의 interface의 메소드를 모두 사용 가능하다.
		inter.method1();
		inter.method2();
		
		//하나의 인터페이스가 객체타입인 경우
		Interface1 inter1 = new InterfaceImplementClass();
		
		//객체가 두가지의 인터페이스를 상속할지언정, 객체타입의 메소드만 사용 가능하다.
		inter1.method1();
//		inter1.method2();	에러!
		
		//이것도 바로위의 사례와 같다.
		Interface2 inter2 = new InterfaceImplementClass();
		
	}

}
