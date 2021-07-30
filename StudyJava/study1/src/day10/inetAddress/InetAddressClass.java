package day10.inetAddress;

import java.net.InetAddress;
import java.util.Scanner;

public class InetAddressClass {
	
	Scanner scanner;
	
	public InetAddressClass() {
		System.out.println("Host name ют╥б");
		
		scanner = new Scanner(System.in);
		
		try {
			
			InetAddress inet = InetAddress.getByName(scanner.next());
			System.out.println("host name : "+inet.getHostName());
			System.out.println("host ip : "+inet.getHostAddress());
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
	
	

}
