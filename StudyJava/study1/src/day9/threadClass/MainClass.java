package day9.threadClass;

public class MainClass {	//Runnable�� �������� �ʰ� ThreadŬ������ ����� thread
	
	public static void main(String[] args) {
		
		Thread thread = new ThreadClass();
		//ThreadClass thread = new ThreadClass(); �̷��� �ص� �ǰ�! ������ ����ϰ� �����Ƿ� ������ Ÿ���� ����.
		thread.setName("B");
		thread.start();
		
		System.out.println(Thread.currentThread().getName());
		
	}

}