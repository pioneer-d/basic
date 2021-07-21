package day6.strategy3;

import day6.strategy3.iinterface.*;

public class MainClass {
	
	public static void main(String[] args) {
		
		SuperRobot superR = new SuperRobot();
		superR.shape();
		superR.defaultFunction();
		//이 클래스는 개별기능들이 생성자로 입력이 되어있다!
		//개별기능 메소드만 호출하면 된다.
		superR.getFly();
		superR.getMisail();
		superR.getKnife();
		
		System.out.println("");
		
		StandardRobot standardR = new StandardRobot();
		standardR.shape();
		standardR.defaultFunction();
		standardR.setIfly(new FlyYes());	//이렇게 setter를 이용해 객체를 입력해주어도 된다!
		standardR.getFly();
		standardR.setImisail(new MisailNo());
		standardR.getMisail();
		standardR.setIknife(new KnifeWood());
		standardR.getKnife();
		
		System.out.println("");
		
		LowRobot lowR = new LowRobot();
		lowR.shape();
		lowR.defaultFunction();
		lowR.setIfly(new FlyNo());
		lowR.getFly();
		lowR.setImisail(new MisailNo());
		lowR.getMisail();
		lowR.setIknife(new KnifeNo());
		lowR.getKnife();
		
	}

}
