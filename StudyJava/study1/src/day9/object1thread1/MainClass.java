package day9.object1thread1;

public class MainClass {	//��ü�� 1��, thread�� 2���� ���
	
	public static void main(String[] args) {	//����Ʈ�� threadNum�� ���� �ǰ� �ִٴ���!
		
		ThreadClass thread1 = new ThreadClass();
		ThreadClass thread2 = new ThreadClass();
		
		
		Thread threadA = new Thread(thread1,"A");
		Thread threadB = new Thread(thread2,"B");
		
		threadA.start();
		threadB.start();
		
		
		
		
	}

}
