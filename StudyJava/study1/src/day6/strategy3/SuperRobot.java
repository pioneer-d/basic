package day6.strategy3;

import day6.strategy3.iinterface.*;

public class SuperRobot extends RobotFrame {

	public SuperRobot() {
		//여기서 개별기능을 default로 넣어줘도 되고
		//setter를 통해 입력해도 된다!
		//이 클래스만 생성자로 입력해주자.
		ifly = new FlyYes();
		imisail = new MisailYes();
		iknife = new KnifeLazer();
		//이때 변수들 앞에 super가 생략된거겠지?	실험해보니 맞다.
	}

	@Override
	public void shape() {
		System.out.println("SuperRobot 입니다. 기본적인 로봇 형태입니다.");
		
	}
	

}
