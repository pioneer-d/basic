package day1;

import java.util.Scanner;

public class Practice1_4 {	//page 30 ���콺 ��Ģ���� ������ �� ���ϱ�
	
	public static int gauss(int a) {
		
		int result = (1+a)*(a/2);	//¦���ϰ��
		if(a%2 != 0) {				//Ȧ�� �� ��� �߾Ӱ��� �������� ����.
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
