package day5.abstractTest2;

public class MainClass {
	
	public static void main(String[] args) {
		
		LunchMenu child1 = new Child1(LunchPrice.MEAL, LunchPrice.GUK, LunchPrice.ICECREAM, LunchPrice.COFFEE, LunchPrice.MILK);
		LunchMenu child2 = new Child2(LunchPrice.MEAL, LunchPrice.GUK, LunchPrice.ICECREAM, LunchPrice.COFFEE, LunchPrice.MILK);
		
		System.out.println(child1.calculrate()+"원 입니다");
		System.out.println(child2.calculrate()+"원 입니다");
		
		
	}

}
