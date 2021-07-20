package day5.abstractTest2;

public abstract class LunchMenu {	//추상클래스 이해를 위한 식비 관리 프로그램
	
	//필수 식단
	public int meal;
	public int guk;
	
	//선택식단
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
