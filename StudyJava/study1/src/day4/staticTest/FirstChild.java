package day4.staticTest;

public class FirstChild {

	public void getMoney(int money) {

		if (PapaPouch.MONEY <= 0) {
			System.out.println("ù°�� ���� ���� ������ �����ϴ�.");
		}else {
		PapaPouch.MONEY = PapaPouch.MONEY - money; // static�� ��ü���� ���� �ٷ� ���� �����ϴ�.
		System.out.println("ù°�� "+money+"�� �޾ҽ��ϴ�.");
		}

	}

}
