package day5.abstractTest2;

public abstract class LunchMenu {	//�߻�Ŭ���� ���ظ� ���� �ĺ� ���� ���α׷�
	
	//�ʼ� �Ĵ�
	public int meal;
	public int guk;
	
	//���ýĴ�
	public int iceCream;
	public int coffee;
	public int milk;
	
	public LunchMenu(int meal, int guk, int iceCream, int coffee, int milk) {
		this.meal = meal;
		this.guk = guk;
		this.iceCream = iceCream;
		this.coffee = coffee;
		this.milk = milk;
	}
	
	public abstract int calculrate();

}
