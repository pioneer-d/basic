package day6.strategy1;

public class MainClass {	//strategy2�� ���ϸ� ����. �� ��Ű���� ��ȿ������ �ڵ��� �����ִ� �����̴�.
	//�����ɵ��� ���� ������ɵ��� ������ �ʰ� ������ ����� ������..?��� �ǹ��� ����!
	//strategy2 ��Ű���� ������.

	public static void main(String[] args) {
		
		SuperRobot superR = new SuperRobot();
		superR.defaultFunction();
		superR.shape();
		superR.actionFly();
		superR.actionMisail();
		superR.knife();
		
		System.out.println("");
		
		StandardRobot standardR = new StandardRobot();
		standardR.defaultFunction();
		standardR.shape();
		standardR.actionFly();
		standardR.actionMisail();
		standardR.knife();
		
		System.out.println("");
		
		LowRobot lowR = new LowRobot();
		lowR.defaultFunction();
		lowR.shape();
		lowR.actionFly();
		lowR.actionMisail();
		lowR.knife();
		
	}
	
}
