package day1;

import java.util.Scanner;

public class CalScore {	//if�� Ȱ���ϸ� ������ �Ҵ�޾� ����� Ȯ���ϰ� ���ϱ�.

	public static void main(String []args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���������� �Է��Ͻÿ�");
		double kor = scanner.nextDouble();
		
		System.out.println("���������� �Է��Ͻÿ�");
		double mat = scanner.nextDouble();
		
		System.out.println("���������� �Է��Ͻÿ�");
		double eng = scanner.nextDouble();
		
		double ave = (kor+mat+eng)/3;
		
		System.out.println("��� ������ "+ave+"�� �Դϴ�");
		
		if(kor>ave) {
			System.out.println("���������� ��պ��� �����ϴ�");
		}else if(kor == ave) {
			System.out.println("���������� ��հ� �����ϴ�");
		}else {
			System.out.println("���������� ��պ��� �����ϴ�");
		}
		
		if(mat>ave) {
			System.out.println("���������� ��պ��� �����ϴ�");
		}else if(mat == ave) {
			System.out.println("���������� ��հ� �����ϴ�");
		}else {
			System.out.println("���������� ��պ��� �����ϴ�");
		}
		
		if(eng>ave) {
			System.out.println("���������� ��պ��� �����ϴ�");
		}else if(eng == ave) {
			System.out.println("���������� ��հ� �����ϴ�");
		}else {
			System.out.println("���������� ��պ��� �����ϴ�");
		}
		
	}
}