package day9.threadRunnable;

public class MainClass {	//Runnable을 구현한 클래스 thread방식
	
	public static void main(String[] args) {
		
		ThreadTest tt = new ThreadTest();
		
		Thread thread = new Thread(tt,"A");
		//매개변수 앞은 Runnable을 구현한 클래스, 뒤는 클래스의 이름을 임의로 넣어주는 변수.
		
		thread.start();
		
		System.out.println(Thread.currentThread().getName());
		
		//실제로 출력을 보면 main이 먼저 올텐데,
		//이는 main thread와 start한 thread가 독립적으로 돌기 때문.
		//start했지만 System.out.println(Thread.currentThread().getName());이 실행이 더 빨라서 main이 나온듯?
		
	}

}
