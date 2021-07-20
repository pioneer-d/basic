package day5.interfaceTest2;

public class APhone implements ISpec {

	@Override
	public void canLTE() {
		System.out.println("A사는 LTE를 지원합니다.");
	}

	@Override
	public void canSamsongPay() {
		System.out.println("A사는 삼성페이를 지원합니다.");		
	}

	@Override
	public void canCall() {
		System.out.println("A사는 통화를 지원합니다.");		
	}

}
