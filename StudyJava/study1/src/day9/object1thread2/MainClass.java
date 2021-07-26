package day9.object1thread2;

public class MainClass {	//객체는 1개, thread는 2개인 경우
	
	public static void main(String[] args) {	//포인트가 threadNum이 공유 되고 있다는점!
		
		ThreadClass thread = new ThreadClass();
		
		Thread threadA = new Thread(thread,"A");
		Thread threadB = new Thread(thread,"B");
		
		threadA.start();
		threadB.start();
		
		
		
		
	}

}
