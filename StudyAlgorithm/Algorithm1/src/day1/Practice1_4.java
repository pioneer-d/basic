package day1;

import java.util.Scanner;

public class Practice1_4 {	//page 30 가우스 법칙으로 정수의 합 구하기
	
	public static int gauss(int a) {
		
		int result = (1+a)*(a/2);	//짝수일경우
		if(a%2 != 0) {				//홀수 일 경우 중앙값이 더해지지 않음.
			result += (a+1)/2;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		System.out.println(Practice1_4.gauss(a));
	}
}
