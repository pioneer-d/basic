package day9.synchronizedTest;

public class MainClass {	//��ü�� 1��, thread�� 2���� ���
	
	public static void main(String[] args) {	//����Ʈ�� threadNum�� ���� �ǰ� �ִٴ���!
		
		ThreadClass thread = new ThreadClass();
		
		Thread threadA = new Thread(thread,"A");
		Thread threadB = new Thread(thread,"B");
		
		threadA.start();
		threadB.start();
		
		
		
		
	}

}
