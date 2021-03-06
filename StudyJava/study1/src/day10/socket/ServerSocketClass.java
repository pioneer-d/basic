package day10.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerSocketClass {
	
	ServerSocket serverSocket = null;
	Socket socket = null;
	PrintWriter writer;
	BufferedReader reader = null;
	String lineStr;		//Client의 입력
	
	public ServerSocketClass() {
		
		try {
			
			//포트번호 설정. 서버소켓 만들기
			serverSocket = new ServerSocket(2000);
			
			while(true) {
				//clinet의 요청 대기
				socket = serverSocket.accept();
				System.out.println("Client 요청");
				
				writer = new PrintWriter(socket.getOutputStream(),true);	//쓰기 준비
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));	//읽기 준비
				
				while((lineStr = reader.readLine())!= null) {	//읽어온 값이 null이 아닌경우
					writer.write(lineStr);	//소켓에 쓰기?
					System.out.println("Client의 input : "+lineStr);
				}
				
				writer.close();
				reader.close();
				socket.close();
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public static void main(String[] args) {
		new ServerSocketClass();
	}
	
	
	

}
