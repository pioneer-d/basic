package day6.strategy3;

import day6.strategy3.iinterface.*;

public class SuperRobot extends RobotFrame {

	public SuperRobot() {
		//���⼭ ��������� default�� �־��൵ �ǰ�
		//setter�� ���� �Է��ص� �ȴ�!
		//�� Ŭ������ �����ڷ� �Է�������.
		ifly = new FlyYes();
		imisail = new MisailYes();
		iknife = new KnifeLazer();
		//�̶� ������ �տ� super�� �����ȰŰ���?	�����غ��� �´�.
	}

	@Override
	public void shape() {
		System.out.println("SuperRobot �Դϴ�. �⺻���� �κ� �����Դϴ�.");
		
	}
	

}
