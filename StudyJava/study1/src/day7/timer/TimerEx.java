package day7.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerEx {
	
	public TimerEx() throws InterruptedException{
		//����ó���ε� ���Ŀ� �� �˾ƺ���.
		
		System.out.println("����");
		Timer timer = new Timer(true);
		
		TimerTask t1 = new TimerTask1();
		TimerTask t2 = new TimerTask2();
		
		timer.schedule(t1, 2000);	//2���� ����
		timer.schedule(t2, 10000);
		
		Thread.sleep(11000);
		System.out.println("����");
		
	}


}
