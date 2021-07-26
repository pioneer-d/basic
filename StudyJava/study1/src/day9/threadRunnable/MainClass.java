package day9.threadRunnable;

public class MainClass {	//Runnable�� ������ Ŭ���� thread���
	
	public static void main(String[] args) {
		
		ThreadTest tt = new ThreadTest();
		
		Thread thread = new Thread(tt,"A");
		//�Ű����� ���� Runnable�� ������ Ŭ����, �ڴ� Ŭ������ �̸��� ���Ƿ� �־��ִ� ����.
		
		thread.start();
		
		System.out.println(Thread.currentThread().getName());
		
		//������ ����� ���� main�� ���� ���ٵ�,
		//�̴� main thread�� start�� thread�� ���������� ���� ����.
		//start������ System.out.println(Thread.currentThread().getName());�� ������ �� ���� main�� ���µ�?
		
	}

}
