package day6.singleton;

public class FirstClass {	
	
	public FirstClass() {
	
	//��ü������ �ƴ� static�޼ҵ带 ȣ���Ͽ� ��ü�� �ҷ��´�.
	SingletonClass singleton = SingletonClass.getSingle();
	
	System.out.println("FirstClass�Դϴ�.");
	
	System.out.println(singleton.getI());	//10���� ������ �Ǿ��ִ�.
	singleton.setI(200);
	System.out.println(singleton.getI());	
	//200���� �����ߴ�.	�ٸ� Ŭ�������� �� ��ü�� �ҷ��͵� ���� ��ü�� �����ϴ� ���̹Ƿ� ������ i�� 200�� ���̴�.
	
	System.out.println("");
	
	
	}
}
