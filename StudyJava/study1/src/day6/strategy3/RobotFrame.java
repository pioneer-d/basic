package day6.strategy3;

import day6.strategy3.iinterface.*;


public abstract class RobotFrame {
	//strategy2의 불편함을 한번더 해결.
	
	//인터페이스의 데이터타입을 변수로 받고, 상속받은 여러 개별기능을 넣는다.
	IFly ifly;			//개별기능들도 부품화하여 더욱더 유연하게!
	IMisail imisail;	//이 변수들도 각각의 로봇들에 입력될 수 있지만, 이 RobotFrame으로 통일시켜 코드를 간략화한다!
	IKnife iknife;
	
	public RobotFrame() {
		// TODO Auto-generated constructor stub
	}
	
	public void defaultFunction() {	//공통기능
		System.out.println("기본적으로 걷고, 뛸 수 있습니다");
	}
	
	public abstract void shape();	//형태만 추상메소드로 남기고

	
	public void setIfly(IFly ifly) {	//매개변수로 IFly가 데이터타입인 객체가 들어오면 이 클래스의 변수에 넣고 메소드로 실행시키는 구조다!
		this.ifly = ifly;
	}

	public void setImisail(IMisail imisail) {
		this.imisail = imisail;
	}

	public void setIknife(IKnife iknife) {
		this.iknife = iknife;
	}
	
	public void getFly() {
		//왜 이런형태냐면
		//setter로든, 로봇들의 생성자로든 IFly가 데이터타입인 객체가 이 클래스(this)의 변수로 저장이 돼있기 때문에
		//그 변수, 즉 this.ifly의 메소드를 실행시키면 된다.(FlyNO든 FlyYes든 fly메소드가 있다)
		//ex) 매개변수로 new FlyYes()가 setter로 들어온다면 이 클래스의 ifly 즉 this.ifly가 FlyYes객체가 된다.
		//FlyYes의 클래스를 보면 알겠지만 fly인터페이스의 fly메소드를 재정의했기 때문에 재정의한 메소드가 실행되는 것이다!
		//결국 this.ifly.fly()는 FlyYes.fly()와 일치한다고 보면 되겠다!
		this.ifly.fly();
	}
	
	public void getMisail() {
		this.imisail.misail();
	}
	
	public void getKnife() {
		this.iknife.knife();
	}
	
	
	
	
	
	
	
	
	
	
	


}