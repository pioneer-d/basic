package day5.interfaceTest2;

public class BPhone implements ISpec {

	@Override
	public void canLTE() {
		System.out.println("B사는 LTE를 지원합니다.");		
	}

	@Override
	public void canSamsongPay() {
		System.out.println("B사는 삼성페이를 지원하지 않습니다.");			
	}

	@Override
	public void canCall() {
		System.out.println("B사는 통화를 지원합니다.");			
	}

}
