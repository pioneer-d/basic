package day1;

import java.util.Scanner;

public class Practice1_3 {	//page 27 n������ �� ���ϱ�
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("n�Է� : ");
		int n = sc.nextInt();
		
		int i = 1;
		int sum = 0;
		
		//while�� ���
		while(i<=n) {
			sum += i;
			i++;
		}
		System.out.println("n������ �� : "+sum);
		
		//for�� ���
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
