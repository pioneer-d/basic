package day6.strategy3;

import day6.strategy3.iinterface.*;

public class MainClass {
	
	public static void main(String[] args) {
		
		SuperRobot superR = new SuperRobot();
		superR.shape();
		superR.defaultFunction();
		//�� Ŭ������ ������ɵ��� �����ڷ� �Է��� �Ǿ��ִ�!
		//������� �޼ҵ常 ȣ���ϸ� �ȴ�.
		superR.getFly();
		superR.getMisail();
		superR.getKnife();
		
		System.out.println("");
		
		StandardRobot standardR = new StandardRobot();
		standardR.shape();
		standardR.defaultFunction();
		standardR.setIfly(new FlyYes());	//�̷��� setter�� �̿��� ��ü�� �Է����־ �ȴ�!
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
