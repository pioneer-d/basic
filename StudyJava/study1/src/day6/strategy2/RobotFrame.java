package day6.strategy2;

public abstract class RobotFrame {	//이 추상클래스가 strategy1의 의문점들을 해결해준다!
	//이 클래스를 로봇들이 상속받으면 공통기능은 쓸 필요없고
	//개별기능들은 오버라이딩을 강제하여 빼먹지 않도록 도와준다!!!
	
	public RobotFrame() {
		// TODO Auto-generated constructor stub
	}
	
	public void defaultFunction() {	//공통기능
		System.out.println("기본적으로 걷고, 뛸 수 있습니다");
	}
	
	public void shape() {	//공통기능
		System.out.println("기본적으로 머리,몸통,다리 등이 있습니다");
		
	}
	
	//개별기능은 추상메소드로 빼서 이 클래스를 상속받는 클래스에서 오버라이딩을 강제한다!
	public abstract void actionFly();
	public abstract void actionMisail();
	public abstract void knife();


}