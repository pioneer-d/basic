package day4.extendSuper;

public class MainClass {	

	public static void main(String[] args) {
		
		ParentClass test = new ChildClass();
		//�θ�� �ڽ��� �����ڿ� ���� ��¹��� �ִµ�, ���⼭ �ڽ��� ��ü�� �����ص� �θ��� �����ڰ� ���� ȣ��ȴ�.
		//�ڽ��� �θ� ��ӹ��� ���̹Ƿ�, �ڽ��� ���� �θ�� ���ư� �θ� ���� ȣ���Ѵ�.
		//�׷��ٴ°� �ڽ��� �����ڿ��� super�� ���� ���ִ°ɱ�?
		
		test.method1();
		//�̶� �ڽ��� ������ �� method1�� �����ϸ� super�� �ֱ⶧���� �θ��� method1�� ���� ����ǰ� �� ���� �ڽ��� �������� method1�� ����ȴ�.
		
	}
	
}
