package day3;

public class Class2 {	//간단한 객체 생성 및 생성자 활용

	public static void main(String[] args) {
		
		Class1 c1 = new Class1();
		Class1 c2 = new Class1();
		//현재 Class1의 생성자 안에는 Sysout이 있다.
		
		System.out.println(c1.equals(c2));	//이 둘은 같은 클래스를 참조하지만 다른 객체이다.
	}
	
}
