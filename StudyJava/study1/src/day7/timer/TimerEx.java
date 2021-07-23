package day7.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerEx {
	
	public TimerEx() throws InterruptedException{
		//예외처리인데 추후에 더 알아보자.
		
		System.out.println("시작");
		Timer timer = new Timer(true);
		
		TimerTask t1 = new TimerTask1();
		TimerTask t2 = new TimerTask2();
		
		timer.schedule(t1, 2000);	//2초후 실행
		timer.schedule(t2, 10000);
		
		Thread.sleep(11000);
		System.out.println("종료");
		
	}


}
