package day9.synchronizedTest;

public class ThreadClass implements Runnable {

	int threadNum = 0;
	
	@Override	//���⿡ synchronized�� �־��ָ� ���� ���� thread�� ����ǰ� �� �ڿ� ���� thread�� ����ȴ�.
	public synchronized void run() {
		
		for(int i = 0; i<10; i++) {
			if(Thread.currentThread().getName().equals("A")) {
				threadNum++;
			}
			System.out.println("���� thread : "+Thread.currentThread().getName()+" / threadNum : "+threadNum);
			System.out.println("====================");
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
