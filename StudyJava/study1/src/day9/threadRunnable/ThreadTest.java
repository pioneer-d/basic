package day9.threadRunnable;

public class ThreadTest implements Runnable {

	@Override
	public void run() {	//RunnableŬ������ �����ϸ� run�޼ҵ带 ������ �ؾ��Ѵ�.

		System.out.println(Thread.currentThread().getName()); //���� ����ǰ� �ִ� thread���. static
		//MainClass���� A�� �̸��� ���Ƿ� �־��־��� ������ A�� ��µ� ���̴�.
		System.out.println("ThreadTestClass�̴�");
		
		for(int i = 0; i<10; i++) {
			System.out.println("i : "+i);
			try {
				Thread.sleep(500);	//0.5�� thread ���߱�
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			if(i == 9) {
				System.out.println("thread����");
			}
		}
		
	}

}