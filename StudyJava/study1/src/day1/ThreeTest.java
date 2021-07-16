package day1;

import java.util.Scanner;

public class ThreeTest {	//수를 입력받아 3의 배수인지 아닌지 판별하는 프로그램

	public static void main(String []args) {
		Scanner scanner = new Scanner(System.in);
		
		int i = scanner.nextInt();
		
		if(i%3 == 0) {
			System.out.println("3의 배수입니다");
		}else {
			System.out.println("3의 배수가 아닙니다.");
		}
	}
}
