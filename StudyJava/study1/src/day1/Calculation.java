package day1;

public class Calculation {	//간단하게 연산자에 대해 알아보자

	public static void main(String []args) {
		int i = 10;
		int j = 5;
		
		//산술연산
		System.out.println("덧셈 = "+(i + j));
		System.out.println("뺄셈 = "+(i - j));
		System.out.println("나눗셈 = "+(i/j));
		System.out.println("나눈 나머지 = "+(i%j));
		
		//증감연산
		System.out.println(i++);	//이것은 출력하면 10이라고 뜬다. 출력이라는 실행 뒤 증가를 하는것.
		System.out.println(j--);	//이것도 마찬가지.
		
		System.out.println(i);		//여기부터 i는 11이 되는것이다.
		System.out.println(j);		//이것도 마찬가지.
		
		//논리연산자
		System.out.println(i==j);
		System.out.println(i>j && i>=j);	//둘다 맞아야
		System.out.println(i>j || i<j);		//둘중 하나만 맞아야
		System.out.println(i<j);
		
	}
}
