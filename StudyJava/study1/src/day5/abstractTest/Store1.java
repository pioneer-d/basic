package day5.abstractTest;

public class Store1 extends HeadStore {
	
	public Store1() {
		// TODO Auto-generated constructor stub
	}
	
	//����� �� �� Ŭ������ Ŀ���� ���ٵΰ�, ctrl + 1�� ������ �ѹ��� ��� �޼ҵ� �������̵� ����
	@Override
	public void chicken() {	//�߻�Ŭ������ �� �������̵��� �ؾ߸� �Ѵ�.
		System.out.println("���� ������ 2���� �Դϴ�.");
		
	}@Override
	public void coffee() {
		System.out.println("���� ������ 2���� �Դϴ�.");
		
	}@Override
	public void pizza() {
		System.out.println("���� ������ 2���� �Դϴ�.");
		
	}
	
//	@Override
//	public void test() {	//�Ϲ� �޼ҵ嵵 �������̵��� �����ϴ�.
//		System.out.println("�Ϲݸ޼ҵ嵵 �������̵��� �����Ѱ�?");
//	}

}