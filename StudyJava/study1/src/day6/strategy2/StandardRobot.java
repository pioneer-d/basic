package day6.strategy2;

public class StandardRobot extends RobotFrame {
	
	public StandardRobot() {
		System.out.println("StandardRobot 입니다.");
	}

	@Override
	public void actionFly() {
		System.out.println("이 로봇은 날 수 있습니다.");
		
	}

	@Override
	public void actionMisail() {
		System.out.println("이 로봇은 미사일이 없습니다.");
		
	}

	@Override
	public void knife() {
		System.out.println("이 로봇은 목검이 있습니다.");
		
	}
	
}
