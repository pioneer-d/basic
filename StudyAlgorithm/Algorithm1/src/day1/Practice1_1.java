package day1;

import java.util.Scanner;

public class Practice1_1 {	//page13 ������ �ִ� ���ϱ�
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("a�� �Է�");
		int a = scanner.nextInt();
		System.out.println("b�� �Է�");
		int b = scanner.nextInt();
		System.out.println("c�� �Է�");
		int c = scanner.nextInt();
		
		int max = a;
		
		if(b > max) max = b;
		if(c > max) max = c;
		
		System.out.println(max);
		
		System.out.println(Practice1_1.max(a, b, c));	//�޼ҵ� ȣ��
		
	}

	public static int max(int a, int b, int c) {	//�޼ҵ�ȭ
		
		int max = a;
		if(b > max) max = b;
		if(c > max) max = c;
		return max;
	}
}
