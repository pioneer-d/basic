package day1;

import java.util.Scanner;

public class ThreeTest {	//���� �Է¹޾� 3�� ������� �ƴ��� �Ǻ��ϴ� ���α׷�

	public static void main(String []args) {
		Scanner scanner = new Scanner(System.in);
		
		int i = scanner.nextInt();
		
		if(i%3 == 0) {
			System.out.println("3�� ����Դϴ�");
		}else {
			System.out.println("3�� ����� �ƴմϴ�.");
		}
	}
}
