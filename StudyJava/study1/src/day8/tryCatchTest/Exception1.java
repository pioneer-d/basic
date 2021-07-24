package day8.tryCatchTest;

public class Exception1 {		//예외처리의 필요성
	
	public static void main(String[] args) {
		
		int i = 10;
		int j = 0;
		
		System.out.println("i+j : "+i+j);
		System.out.println("i-j : "+(i-j));
		System.out.println("i*j : "+i*j);
		System.out.println("i/j : "+i/j);	//이 값이 0이기 때문에 프로세스가 멈춘다.
		//만약 이값이 중간에 있으면 나중에 올 계산들을 볼 수가 없이 중간에 끊긴다.
		//그러므로 예외처리를 하여 넘어가게 하고 프로세스가 끊기지 않도록 해야한다.
		
	}

}
