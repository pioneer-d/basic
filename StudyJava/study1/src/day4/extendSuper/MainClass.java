package day4.extendSuper;

public class MainClass {	

	public static void main(String[] args) {
		
		ParentClass test = new ChildClass();
		//부모와 자식의 생성자에 각각 출력문이 있는데, 여기서 자식의 객체를 생성해도 부모의 생성자가 먼저 호출된다.
		//자식이 부모를 상속받은 것이므로, 자식을 거쳐 부모로 돌아가 부모를 먼저 호출한다.
		//그렇다는건 자식의 생성자에는 super가 생략 돼있는걸까?
		
		test.method1();
		//이때 자식이 재정의 한 method1을 실행하면 super가 있기때문에 부모의 method1이 먼저 실행되고 그 다음 자식이 재정의한 method1이 실행된다.
		
	}
	
}
