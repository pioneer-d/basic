package day6.strategy2;

public class MainClass {
	
	public static void main(String[] args) {
		//개별기능까지 전부 부품화할 순 없을까...?라는 의문점이 든다면 strategy3패키지를 보자.
		
		//방법1 데이터타입을 자기자신으로 객체를 생성한다.
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
		
		System.out.println("=============================");
		
		//방법2 데이터타입을 RobotFrame으로 통일한다.
		RobotFrame superR1 = new SuperRobot();
		RobotFrame standardR1 = new StandardRobot();
		RobotFrame lowR1 = new LowRobot();
		
		RobotFrame[] rf = {superR1,standardR1,lowR1};
		
		for(int i = 0; i<rf.length; i++) {
			rf[i].defaultFunction();
			rf[i].shape();
			rf[i].actionFly();
			rf[i].actionMisail();
			rf[i].knife();
		}
		
	}

}
