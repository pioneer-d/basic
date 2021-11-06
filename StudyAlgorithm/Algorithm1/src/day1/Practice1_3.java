package day1;

import java.util.Scanner;

public class Practice1_3 {	//page 27 n까지의 합 구하기
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("n입력 : ");
		int n = sc.nextInt();
		
		int i = 1;
		int sum = 0;
		
		//while문 사용
		while(i<=n) {
			sum += i;
			i++;
		}
		System.out.println("n까지의 합 : "+sum);
		
		//for문 사용
		int sum2 = 0;
		for(int j = 1; j<=n; j++) {
			sum2 +=j;
			System.out.print(j);
			if(j<n) {
				System.out.print(" + ");
			}
		}
		System.out.print(" = "+sum2);
	}

}
