package day6.singleton;

public class SingletonClass {	//�̱��� ���� �����ϱ�
	
	//�� ������ �޼ҵ带 ���� ��ü�� �������ִ� �����̴�.
	private static SingletonClass SINGLETON_CLASS_INSTANCE;
	public int i = 10;
	
	private SingletonClass() {	//�����ڸ� private�� �����Ͽ� ��ü������ ���´�.
		//��ü������ ���� ��ü�� �������� ����°��� ����
		//static�޼ҵ带 ���� ��ü�� �����Ͽ� �� Ŭ������ �������� ���� �ֵ��� �ϴ°��� ������.
		
	}
	
	public static SingletonClass getSingle() {
		
		if(SINGLETON_CLASS_INSTANCE == null) {	//FirstClass���� �� �޼ҵ带 ȣ���Ҷ� ��ü�� �Էµɰ�.
			SINGLETON_CLASS_INSTANCE = new SingletonClass();
		}	//��� �̷� �ʿ���� �ʵ尪���� new�س����� �����ʳ�..
		
		return SINGLETON_CLASS_INSTANCE;	//SecondClass������ �̹� FirstClass�� ��ü�� �Է������Ƿ� �ٷ� return���� �ð�.
		//����Ÿ���� �� Ŭ���� ��ü�̰�, ������ �� Ŭ���� ��ü�̴�.
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	

}
