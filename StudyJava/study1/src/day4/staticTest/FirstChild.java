package day4.staticTest;

public class FirstChild {

	public void getMoney(int money) {

		if (PapaPouch.MONEY <= 0) {
			System.out.println("첫째가 받을 돈이 지갑에 없습니다.");
		}else {
		PapaPouch.MONEY = PapaPouch.MONEY - money; // static은 객체생성 없이 바로 접근 가능하다.
		System.out.println("첫째가 "+money+"원 받았습니다.");
		}

	}

}
