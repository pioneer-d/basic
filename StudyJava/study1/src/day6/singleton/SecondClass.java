package day6.singleton;

public class SecondClass {
	
	public SecondClass() {
		
	SingletonClass singleton = SingletonClass.getSingle();	//FirstClass�� �����ϴ� ��ü
	
	System.out.println("SecondClass �Դϴ�");
	
	System.out.println(singleton.getI());	
	//������ 10������
	//FirstClass���� 200���� �����߰�, ���� ��ü�̹Ƿ� ������ 200���� ���ð��̴�.
	
	}
}
