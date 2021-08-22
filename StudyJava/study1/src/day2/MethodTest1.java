package day2;

import java.util.Scanner;

public class MethodTest1 {		//객체지향언어를 이해하기 위한 메소드 만들기

	
	public static void main(String[] args) {	//결국도 main도 하나의 메소드이다. 단, 이 클래스와는 관련이 없다고 생각하자.
		
		Scanner scanner = new Scanner(System.in);
		

		System.out.println("확인 할 구구단의 정수를 입력하시오.");
		int gugu = scanner.nextInt();
		
//		gugudan(gugu);	//이때 gugudan메소드를 그냥 가져오려면 static을 사용해야한다.
		MethodTest1 method1 = new MethodTest1();
		method1.gugudan(gugu);
		//이렇게 호출하기만 하면 만들어 놓은 틀을 계속적으로 사용할 수 있다. 절차지향이라면 모든 구구단에 대해 만들어 둬야하는 끔찍한...
		
	
	}
	
	public void gugudan(int i) {	//메인 클래스 밖에 있다.
		for(int j = 1; j<10; j++) {
			System.out.println(i+"*"+j+"="+(i*j));
		}
	}

}
