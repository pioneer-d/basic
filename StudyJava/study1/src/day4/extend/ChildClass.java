package day4.extend;

public class ChildClass extends ParentClass  {	//상속의 이해
	
	//상속은 extends로 하며 한 클래스는 1개의 상속만 할 수 있다.
	//이 클래스는 ParentClass의 모든 데이터와 메소드를 사용할 수 있다.

	public ChildClass() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void getChange() {	//이것이 오버라이딩
		System.out.println("이건 자식이 바꾼다! 개편하자!");
	}
	
}
