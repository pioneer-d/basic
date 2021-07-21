package day6.strategy2;

public class SuperRobot extends RobotFrame {

	public SuperRobot() {
		System.out.println("SuperRobot �Դϴ�.");
	}
	
	@Override
	public void actionFly() {
		System.out.println("�� �κ��� �� �� �ֽ��ϴ�.");
		
	}

	@Override
	public void actionMisail() {
		System.out.println("�� �κ��� �̻����� �ֽ��ϴ�.");
		
	}

	@Override
	public void knife() {
		System.out.println("�� �κ��� ���������� �ֽ��ϴ�.");
		
	}

}
