package day4.extendSuper;

public class ChildClass extends ParentClass {	//super의 이해
	
	public ChildClass() {
		System.out.println("ChildClass의 생성자 호출!");
	}
	
	@Override
	public void method1() {
		super.method1();	//이때 super는 this(자기객체)와 다르게 상위 객체를 찾는 키워드!
		System.out.println("자식이 재정의 한 메소드!");
		
		//super로 부모의 객체로 가서 method1을 실행 한 다음 다시 돌아와 자식이 재정의한 메소드를 실행하는 구조이다.
	}

}
