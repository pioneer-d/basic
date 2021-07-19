package day2.loop;

public class WhileTest {	//while 기본예제
	public static void main(String[] args) {

		int i = 0;

		while(i<10) {	//조건식에 true가 들어가면 무한 루프가 된다.
			System.out.println("현재 i는 "+i);
			i++;	
		}
		
	}
}
