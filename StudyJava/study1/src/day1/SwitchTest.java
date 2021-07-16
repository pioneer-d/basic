package day1;

import java.util.Scanner;

public class SwitchTest {	//Switch문을 활용하여 입력받은 숫자가 홀수인지 짝수인지 판별하기

	public static void main(String []args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수를 입력하시오");
		int i = scanner.nextInt();
		
		int what = i%2;
		
		switch(what) {
		case 1: System.out.println("짝수가 아닙니다"); break;
		case 0: System.out.println("짝수 입니다"); break;
		default:System.out.println("모르겠습니다"); break;
		}
		
		
	}
}
