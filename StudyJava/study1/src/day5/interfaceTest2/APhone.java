package day5.interfaceTest2;

public class APhone implements ISpec {

	@Override
	public void canLTE() {
		System.out.println("A��� LTE�� �����մϴ�.");
	}

	@Override
	public void canSamsongPay() {
		System.out.println("A��� �Ｚ���̸� �����մϴ�.");		
	}

	@Override
	public void canCall() {
		System.out.println("A��� ��ȭ�� �����մϴ�.");		
	}

}
