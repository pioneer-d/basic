package day6.strategy2;

public abstract class RobotFrame {	//�� �߻�Ŭ������ strategy1�� �ǹ������� �ذ����ش�!
	//�� Ŭ������ �κ����� ��ӹ����� �������� �� �ʿ����
	//������ɵ��� �������̵��� �����Ͽ� ������ �ʵ��� �����ش�!!!
	
	public RobotFrame() {
		// TODO Auto-generated constructor stub
	}
	
	public void defaultFunction() {	//������
		System.out.println("�⺻������ �Ȱ�, �� �� �ֽ��ϴ�");
	}
	
	public void shape() {	//������
		System.out.println("�⺻������ �Ӹ�,����,�ٸ� ���� �ֽ��ϴ�");
		
	}
	
	//��������� �߻�޼ҵ�� ���� �� Ŭ������ ��ӹ޴� Ŭ�������� �������̵��� �����Ѵ�!
	public abstract void actionFly();
	public abstract void actionMisail();
	public abstract void knife();


}