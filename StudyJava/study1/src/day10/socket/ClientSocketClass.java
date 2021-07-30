package day10.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketClass {
	
	Socket socket = null;
	PrintWriter writer;
	BufferedReader reader = null;
	
	public ClientSocketClass() {
		try {
			//들어갈 포트번호 입력
			socket = new Socket("localHost",2000);
			writer = new PrintWriter(socket.getOutputStream(),true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String str = null;
			BufferedReader sReader = new BufferedReader(new InputStreamReader(System.in));
			
			while((str = sReader.readLine())!=null) {
				writer.write(str);
				System.out.println("나의 입력 : "+str);
			}
			
			writer.close();
			reader.close();
			sReader.close();
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new ClientSocketClass();
	}

}
