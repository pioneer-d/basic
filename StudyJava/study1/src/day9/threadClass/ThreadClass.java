package day9.threadClass;


public class ThreadClass extends Thread {
	
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("TreadClass¿Ã¥Ÿ.");
		
		for(int i = 0; i<10; i++) {
			
			System.out.println("i : "+i);
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}

}
