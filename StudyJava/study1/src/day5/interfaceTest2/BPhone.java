package day5.interfaceTest2;

public class BPhone implements ISpec {

	@Override
	public void canLTE() {
		System.out.println("B��� LTE�� �����մϴ�.");		
	}

	@Override
	public void canSamsongPay() {
		System.out.println("B��� �Ｚ���̸� �������� �ʽ��ϴ�.");			
	}

	@Override
	public void canCall() {
		System.out.println("B��� ��ȭ�� �����մϴ�.");			
	}

}
