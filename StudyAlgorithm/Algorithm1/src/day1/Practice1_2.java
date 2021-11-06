package day1;

import java.util.Scanner;

public class Practice1_2 {	//page21 중앙값 구하기
	
	public static int medium(int a, int b, int c) {
		//세개의 값의 대소관계 조합은 13가지이다.
		if(a>=b) {
			if(b>=c) return b;
			else if(a<=c) return a;
			else return c;
		}else if(a>c) {		//a<b 기준
			return a;
		}else if(b>=c) {	//a<b , a<c 기준
			return c;
		}else {				//a<b , a<c , b<c 기준
			return b;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("a값 입력 : ");
		int a = sc.nextInt();
		System.out.print("b값 입력 : ");
		int b = sc.nextInt();
		System.out.print("c값 입력 : ");
		int c = sc.nextInt();
		
		System.out.println(Practice1_2.medium(a, b, c));
	}

}
