package day1;

import java.util.Scanner;

public class Practice1_2 {	//page21 �߾Ӱ� ���ϱ�
	
	public static int medium(int a, int b, int c) {
		//������ ���� ��Ұ��� ������ 13�����̴�.
		if(a>=b) {
			if(b>=c) return b;
			else if(a<=c) return a;
			else return c;
		}else if(a>c) {		//a<b ����
			return a;
		}else if(b>=c) {	//a<b , a<c ����
			return c;
		}else {				//a<b , a<c , b<c ����
			return b;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("a�� �Է� : ");
		int a = sc.nextInt();
		System.out.print("b�� �Է� : ");
		int b = sc.nextInt();
		System.out.print("c�� �Է� : ");
		int c = sc.nextInt();
		
		System.out.println(Practice1_2.medium(a, b, c));
	}

}
