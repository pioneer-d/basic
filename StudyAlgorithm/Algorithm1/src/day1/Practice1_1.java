package day1;

import java.util.Scanner;

public class Practice1_1 {	//page13 세값의 최댓값 구하기
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("a값 입력");
		int a = scanner.nextInt();
		System.out.println("b값 입력");
		int b = scanner.nextInt();
		System.out.println("c값 입력");
		int c = scanner.nextInt();
		
		int max = a;
		
		if(b > max) max = b;
		if(c > max) max = c;
		
		System.out.println(max);
		
		System.out.println(Practice1_1.max(a, b, c));	//메소드 호출
		
	}

	public static int max(int a, int b, int c) {	//메소드화
		
		int max = a;
		if(b > max) max = b;
		if(c > max) max = c;
		return max;
	}
}
