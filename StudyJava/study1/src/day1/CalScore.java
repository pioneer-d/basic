package day1;

import java.util.Scanner;

public class CalScore {	//if문 활용하며 점수를 할당받아 평균을 확인하고 비교하기.

	public static void main(String []args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("국어점수를 입력하시오");
		double kor = scanner.nextDouble();
		
		System.out.println("수학점수를 입력하시오");
		double mat = scanner.nextDouble();
		
		System.out.println("영어점수를 입력하시오");
		double eng = scanner.nextDouble();
		
		double ave = (kor+mat+eng)/3;
		
		System.out.println("평균 점수는 "+ave+"점 입니다");
		
		if(kor>ave) {
			System.out.println("국어점수는 평균보다 높습니다");
		}else if(kor == ave) {
			System.out.println("국어점수는 평균과 같습니다");
		}else {
			System.out.println("국어점수는 평균보다 낮습니다");
		}
		
		if(mat>ave) {
			System.out.println("수학점수는 평균보다 높습니다");
		}else if(mat == ave) {
			System.out.println("수학점수는 평균과 같습니다");
		}else {
			System.out.println("수학점수는 평균보다 낮습니다");
		}
		
		if(eng>ave) {
			System.out.println("영어점수는 평균보다 높습니다");
		}else if(eng == ave) {
			System.out.println("영어점수는 평균과 같습니다");
		}else {
			System.out.println("영어점수는 평균보다 낮습니다");
		}
		
	}
}
