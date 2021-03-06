package day4.extend2;

public class MainClass {	//객체타입에 대한 설명
	
	public static void main(String[] args) { //상속을 받으면 상위 클래스와 타입이 같아질 수 있다!
		
		HeadStore store = new HeadStore();
		
		HeadStore store1 = new Store1();
		//앞의 HeadStore는 객체타입을 명시하는 것이다.
		//이때 Store1은 HeadStore를 상속받고 있으니 HeadStore의 타입을 받아도 된다!
		//타입이 HeadStore일뿐 객체는 Store1로 생성!
		
		HeadStore store2 = new Store2();
		
		//부모의 메소드들
		store.chicken();
		store.pizza();
		store.coffee();
		
		System.out.println("");
		//자식의 메소드들(chicken이 재정의 되었음)
		store1.chicken();
		store1.pizza();
		store1.coffee();
		
		System.out.println("");
		//자식의 메소드들(pizza가 재정의 되었음)
		store2.chicken();
		store2.pizza();
		store2.coffee();
		
		
	}
}
