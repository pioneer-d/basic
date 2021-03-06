package day9.threadRunnable;

public class ThreadTest implements Runnable {

	@Override
	public void run() {	//Runnable클래스를 구현하면 run메소드를 재정의 해야한다.

		System.out.println(Thread.currentThread().getName()); //현재 실행되고 있는 thread출력. static
		//MainClass에서 A로 이름을 임의로 넣어주었기 때문에 A가 출력될 것이다.
		System.out.println("ThreadTestClass이다");
		
		for(int i = 0; i<10; i++) {
			System.out.println("i : "+i);
			try {
				Thread.sleep(500);	//0.5초 thread 멈추기
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			if(i == 9) {
				System.out.println("thread종료");
			}
		}
		
	}

}
