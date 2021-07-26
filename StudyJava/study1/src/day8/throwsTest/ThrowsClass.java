package day8.throwsTest;

public class ThrowsClass {
	
	public ThrowsClass() {
		actionC();
	}

	public void actionA() throws Exception  {	//�� �޼ҵ带 ȣ���� ������ ���ܸ� �Ѱܹ�����
		
		int[] arr = {1,2,3,4};
		System.out.println(arr[4]);
		
	}
	
	public void actionB() {
		System.out.println("actionB �޼ҵ� ���� �� actionA �޼ҵ� ȣ��");
		
		try {
			actionA();
		} catch (Exception e) {
			System.out.println("actionA�� ȣ���� actionB���� ����ó��.");
			System.out.println(e.getMessage());
		}
		System.out.println("actionA�� ���ܸ� �̰����� ó��");
		System.out.println("actionB �޼ҵ� ����");
		
	}
	
	public void actionC() {
		System.out.println("actionC �޼ҵ� ���� �� actionB �޼ҵ� ȣ��");
		actionB();
		System.out.println("actionC �޼ҵ� ����");
	}
}