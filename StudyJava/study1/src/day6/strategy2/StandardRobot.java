package day6.strategy2;

public class StandardRobot extends RobotFrame {
	
	public StandardRobot() {
		System.out.println("StandardRobot �Դϴ�.");
	}

	@Override
	public void actionFly() {
		System.out.println("�� �κ��� �� �� �ֽ��ϴ�.");
		
	}

	@Override
	public void actionMisail() {
		System.out.println("�� �κ��� �̻����� �����ϴ�.");
		
	}

	@Override
	public void knife() {
		System.out.println("�� �κ��� ����� �ֽ��ϴ�.");
		
	}
	
}
