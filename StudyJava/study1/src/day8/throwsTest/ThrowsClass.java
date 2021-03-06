package day8.throwsTest;

public class ThrowsClass {
	
	public ThrowsClass() {
		actionC();
	}

	public void actionA() throws Exception  {	//이 메소드를 호출한 곳으로 예외를 넘겨버린다
		
		int[] arr = {1,2,3,4};
		System.out.println(arr[4]);
		
	}
	
	public void actionB() {
		System.out.println("actionB 메소드 시작 및 actionA 메소드 호출");
		
		try {
			actionA();
		} catch (Exception e) {
			System.out.println("actionA를 호출한 actionB에서 예외처리.");
			System.out.println(e.getMessage());
		}
		System.out.println("actionA의 예외를 이곳에서 처리");
		System.out.println("actionB 메소드 종료");
		
	}
	
	public void actionC() {
		System.out.println("actionC 메소드 시작 및 actionB 메소드 호출");
		actionB();
		System.out.println("actionC 메소드 종료");
	}
}
