package day5.abstractTest;

public class Store1 extends HeadStore {
	
	public Store1() {
		// TODO Auto-generated constructor stub
	}
	
	//상속을 한 뒤 클래스에 커서를 갖다두고, ctrl + 1을 누르면 한번에 모든 메소드 오버라이딩 가능
	@Override
	public void chicken() {	//추상클래스는 꼭 오버라이딩을 해야만 한다.
		System.out.println("저희 매장은 2만원 입니다.");
		
	}@Override
	public void coffee() {
		System.out.println("저희 매장은 2만원 입니다.");
		
	}@Override
	public void pizza() {
		System.out.println("저희 매장은 2만원 입니다.");
		
	}
	
//	@Override
//	public void test() {	//일반 메소드도 오버라이딩이 가능하다.
//		System.out.println("일반메소드도 오버라이딩이 가능한가?");
//	}

}
