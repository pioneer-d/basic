package day8.tryCatchTest;

public class TryCatch1 {

	public static void main(String[] args) {

		int i = 10;
		int j = 0;

		System.out.println("i+j : " + i + j);
		System.out.println("i-j : " + (i - j));
		System.out.println("i*j : " + i * j);
		try {	//오류가 나는 곳을 try로 묶고 catch로 처리를 한다. 
			System.out.println("i/j : " + i / j);
		} catch (Exception e) {		//catch문이 여러개가 올 수 있다.
			System.out.println(e.getMessage());	//e.getMessage는 무슨 오류인지 출력하는 메소드
			e.printStackTrace();	//이건 오류 더 자세히 보는 매소드
			
		}finally {	//try와 catch문이 실행되지 않아도 무조건 실행되는 메소드이다.
					//문제가 발생하든 안하든 무조건 실행된다.
			System.out.println("무조건 실행되는 메소드");
			
		}
	}

}
