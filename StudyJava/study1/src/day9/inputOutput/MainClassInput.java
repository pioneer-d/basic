package day9.inputOutput;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainClassInput {
	
	public static void main(String[] args) {
		
		try {	//입출력은 보통 예외처리를 해야 가능하다.
			//FileInputStream은 InputStream을 상속받은 클래스 중 하나.
		InputStream is = new FileInputStream("C:\\GitHub\\testInput.txt");
		while(true) {
			int i = is.read();	//읽는다!
			System.out.println("데이터 : "+i);	//해당 데이터를 byte로 반환하여 읽은 것은 출력하기.
			if(i == -1)break;
			//데이터가 없을 경우 -1을 리턴하기 때문에 -1에서 break한다.
		}
		
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
