package day6.strategy3;

import day6.strategy3.iinterface.*;


public abstract class RobotFrame {
	//strategy2�� �������� �ѹ��� �ذ�.
	
	//�������̽��� ������Ÿ���� ������ �ް�, ��ӹ��� ���� ��������� �ִ´�.
	IFly ifly;			//������ɵ鵵 ��ǰȭ�Ͽ� ������ �����ϰ�!
	IMisail imisail;	//�� �����鵵 ������ �κ��鿡 �Էµ� �� ������, �� RobotFrame���� ���Ͻ��� �ڵ带 ����ȭ�Ѵ�!
	IKnife iknife;
	
	public RobotFrame() {
		// TODO Auto-generated constructor stub
	}
	
	public void defaultFunction() {	//������
		System.out.println("�⺻������ �Ȱ�, �� �� �ֽ��ϴ�");
	}
	
	public abstract void shape();	//���¸� �߻�޼ҵ�� �����

	
	public void setIfly(IFly ifly) {	//�Ű������� IFly�� ������Ÿ���� ��ü�� ������ �� Ŭ������ ������ �ְ� �޼ҵ�� �����Ű�� ������!
		this.ifly = ifly;
	}

	public void setImisail(IMisail imisail) {
		this.imisail = imisail;
	}

	public void setIknife(IKnife iknife) {
		this.iknife = iknife;
	}
	
	public void getFly() {
		//�� �̷����³ĸ�
		//setter�ε�, �κ����� �����ڷε� IFly�� ������Ÿ���� ��ü�� �� Ŭ����(this)�� ������ ������ ���ֱ� ������
		//�� ����, �� this.ifly�� �޼ҵ带 �����Ű�� �ȴ�.(FlyNO�� FlyYes�� fly�޼ҵ尡 �ִ�)
		//ex) �Ű������� new FlyYes()�� setter�� ���´ٸ� �� Ŭ������ ifly �� this.ifly�� FlyYes��ü�� �ȴ�.
		//FlyYes�� Ŭ������ ���� �˰����� fly�������̽��� fly�޼ҵ带 �������߱� ������ �������� �޼ҵ尡 ����Ǵ� ���̴�!
		//�ᱹ this.ifly.fly()�� FlyYes.fly()�� ��ġ�Ѵٰ� ���� �ǰڴ�!
		this.ifly.fly();
	}
	
	public void getMisail() {
		this.imisail.misail();
	}
	
	public void getKnife() {
		this.iknife.knife();
	}
	
	
	
	
	
	
	
	
	
	
	


}