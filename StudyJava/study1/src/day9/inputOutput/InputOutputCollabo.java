package day9.inputOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class InputOutputCollabo {	//입출력 동시에 하는 클래스!
	
	public static void main(String[] args) {
		
		InputStream is = null;
		OutputStream os = null;
		
		try {
		is = new FileInputStream("C:\\GitHub\\testInOut.txt");
		os = new FileOutputStream("C:\\GitHub\\testInOut_copy.txt");
		
		while(true) {
			int i = is.read();	// 1byte씩 읽기 (byte[5] 이거면 5byte씩 읽을거임.)
			System.out.println(i);
			if(i == -1) break;
			os.write(i);		// 읽은대로 입력하기.	 (write(byte[5],int,int) 이런 식이면 배열로 담고 마지막 남은 자리 없애는 방식임.)
		}
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		} finally {
			try {
				if(is != null) is.close();
				if(os != null) os.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
