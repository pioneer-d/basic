package day6.strategy1;

public class StandardRobot {

	public StandardRobot() {
		System.out.println("StandardRobot�Դϴ�.");
	}
	
	public void defaultFunction() {	//��� �κ��� ���� ���	�Ź� �κ����� ������ �Է��ؾ��ϳ�...?��� �ǹ��� ����� ����
		System.out.println("�⺻������ �Ȱ�, �� �� �ֽ��ϴ�");
	}
	
	public void shape() {	//��� �κ��� ����	�Ź� �κ����� ������ �Է��ؾ��ϳ�...?��� �ǹ��� ����� ����
		System.out.println("�⺻������ �Ӹ�,����,�ٸ� ���� �ֽ��ϴ�");
		
	}
	
	public void actionFly() {	//�κ����� �ٸ� �޼ҵ�. ��û���� ���� �κ��� ����ٰ� �� �޼ҵ���� �Է��ϴ� ���� ������� ��¼��..?��� �ǹ����� ����� ����.
		System.out.println("�� �κ��� �� �� �ֽ��ϴ�");
	}
	
	public void actionMisail() {	//�κ����� �ٸ� �޼ҵ�. ��û���� ���� �κ��� ����ٰ� �� �޼ҵ���� �Է��ϴ� ���� ������� ��¼��..?��� �ǹ����� ����� ����.
		System.out.println("�� �κ��� �̻����� �����ϴ�");
		
	}
	
	public void knife() {	//�κ����� �ٸ� �޼ҵ�. ��û���� ���� �κ��� ����ٰ� �� �޼ҵ���� �Է��ϴ� ���� ������� ��¼��..?��� �ǹ����� ����� ����.
		System.out.println("�� �κ��� ����� �ֽ��ϴ�");
		
	}
	
}
