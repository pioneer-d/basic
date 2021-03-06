package day10.URLConnection;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class URLConnectionClass {
	
	public URLConnectionClass() {
		
		String code = null;
		System.out.println("파일화 할 주소를 입력하시오");	//https://www.naver.com/이거 입력했음.
		Scanner scanner = new Scanner(System.in);
		
		String address = scanner.next();
		
		try {
			
			URL url = new URL(address);	//url객체에 주소 입력
			URLConnection con = url.openConnection();	//주소와 연결
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));	//주소의 데이터 읽어오기
			FileWriter writer = new FileWriter("C:\\GitHub\\testhtml.html",false);
				
			//해당 주소의 소스를 내 로컬소스로 파일을 만들어 똑같이 구현한것.
			//마치 크롤링과 같다고 봐야할까?
			while((code = reader.readLine()) != null) {
				writer.write(code);
			}
			System.out.println("The end");
			
			writer.close();
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
