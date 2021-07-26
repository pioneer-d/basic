package day9.synchronizedTest;

public class ThreadClass implements Runnable {

	int threadNum = 0;
	
	@Override	//여기에 synchronized를 넣어주면 먼저 들어온 thread가 실행되고 그 뒤에 다음 thread가 실행된다.
	public synchronized void run() {
		
		for(int i = 0; i<10; i++) {
			if(Thread.currentThread().getName().equals("A")) {
				threadNum++;
			}
			System.out.println("현재 thread : "+Thread.currentThread().getName()+" / threadNum : "+threadNum);
			System.out.println("====================");
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
