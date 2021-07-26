package day9.threadClass;

public class MainClass {	//Runnable을 구현하지 않고 Thread클래스를 상속한 thread
	
	public static void main(String[] args) {
		
		Thread thread = new ThreadClass();
		//ThreadClass thread = new ThreadClass(); 이렇게 해도 되고! 어차피 상속하고 있으므로 데이터 타입은 같다.
		thread.setName("B");
		thread.start();
		
		System.out.println(Thread.currentThread().getName());
		
	}

}
