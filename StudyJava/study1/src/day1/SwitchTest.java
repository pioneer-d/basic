package day1;

import java.util.Scanner;

public class SwitchTest {	//Switch���� Ȱ���Ͽ� �Է¹��� ���ڰ� Ȧ������ ¦������ �Ǻ��ϱ�

	public static void main(String []args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������ �Է��Ͻÿ�");
		int i = scanner.nextInt();
		
		int what = i%2;
		
		switch(what) {
		case 1: System.out.println("¦���� �ƴմϴ�"); break;
		case 0: System.out.println("¦�� �Դϴ�"); break;
		default:System.out.println("�𸣰ڽ��ϴ�"); break;
		}
		
		
	}
}
