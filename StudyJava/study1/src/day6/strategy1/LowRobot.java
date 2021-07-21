package day6.strategy1;

public class LowRobot {
	
	public LowRobot() {
		System.out.println("LowRobot입니다.");
	}
	

	public void defaultFunction() {	//모든 로봇이 갖는 기능	매번 로봇만들 때마다 입력해야하나...?라는 의문이 생기는 지점
		System.out.println("기본적으로 걷고, 뛸 수 있습니다");
	}
	
	public void shape() {	//모든 로봇의 형태	매번 로봇만들 때마다 입력해야하나...?라는 의문이 생기는 지점
		System.out.println("기본적으로 머리,몸통,다리 등이 있습니다");
		
	}
	
	public void actionFly() {	//로봇마다 다른 메소드. 엄청나게 많은 로봇을 만들다가 이 메소드들을 입력하는 것을 까먹으면 어쩌지..?라는 의문점이 생기는 지점.
		System.out.println("이 로봇은 날 수 없습니다");
	}
	
	public void actionMisail() {	//로봇마다 다른 메소드. 엄청나게 많은 로봇을 만들다가 이 메소드들을 입력하는 것을 까먹으면 어쩌지..?라는 의문점이 생기는 지점.
		System.out.println("이 로봇은 미사일이 없습니다");
		
	}
	
	public void knife() {	//로봇마다 다른 메소드. 엄청나게 많은 로봇을 만들다가 이 메소드들을 입력하는 것을 까먹으면 어쩌지..?라는 의문점이 생기는 지점.
		System.out.println("이 로봇은 검이 없습니다");
		
	}
}
