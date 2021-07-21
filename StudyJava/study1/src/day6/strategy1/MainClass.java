package day6.strategy1;

public class MainClass {	//strategy2와 비교하며 보자. 이 패키지는 비효율적인 코딩을 보여주는 예시이다.
	//공통기능들은 묶고 개별기능들은 빼먹지 않고 나오는 방법은 없을까..?라는 의문이 생김!
	//strategy2 패키지로 가보자.

	public static void main(String[] args) {
		
		SuperRobot superR = new SuperRobot();
		superR.defaultFunction();
		superR.shape();
		superR.actionFly();
		superR.actionMisail();
		superR.knife();
		
		System.out.println("");
		
		StandardRobot standardR = new StandardRobot();
		standardR.defaultFunction();
		standardR.shape();
		standardR.actionFly();
		standardR.actionMisail();
		standardR.knife();
		
		System.out.println("");
		
		LowRobot lowR = new LowRobot();
		lowR.defaultFunction();
		lowR.shape();
		lowR.actionFly();
		lowR.actionMisail();
		lowR.knife();
		
	}
	
}
