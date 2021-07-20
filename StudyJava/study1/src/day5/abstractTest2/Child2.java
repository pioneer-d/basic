package day5.abstractTest2;

public class Child2 extends LunchMenu {

	public Child2(int meal, int guk, int iceCream, int coffee, int milk) {
		super(meal, guk, iceCream, coffee, milk);
		// TODO Auto-generated constructor stub
	}

	//이 클래스에서는 선택 식단 중 iceCream과 milk를 선택한다.
	@Override
	public int calculrate() {
		System.out.println("밥, 국, 아이스크림, 우유를 선택하셨습니다.");
		return meal + guk + iceCream + milk;
	}

}
