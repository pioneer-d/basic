package day9.inputOutput;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainClassOutput {
	
	public static void main(String[] args) {
		
		OutputStream os = null;
		
		try {
			//해당 파일이 없으면 만든다!
			os = new FileOutputStream("C:\\GitHub\\testOutput.txt");
			String str = "오늘은 날씨가 너무 덥다.";
			byte[] bs =  str.getBytes();	//String값을 byte로 반환
			os.write(bs);	//입력!
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {	//마지막에 닫아주기.
			try {
				if(os != null) os.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
	}

}
