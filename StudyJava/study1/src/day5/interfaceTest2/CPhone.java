package day5.interfaceTest2;

public class CPhone implements ISpec {

	@Override
	public void canLTE() {
		System.out.println("C��� LTE�� �������� �ʽ��ϴ�.");			
	}

	@Override
	public void canSamsongPay() {
		System.out.println("C��� �Ｚ���̸� �������� �ʽ��ϴ�.");			
	}

	@Override
	public void canCall() {
		System.out.println("C��� ��ȭ�� �����մϴ�.");			
	}

}
