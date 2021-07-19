package day2.loop;

public class ForTest2 {		//for문을 활용하여 1부터 10까지의 합 구해보기
	public static void main(String[] args) {
		
		int sum = 0;
		for(int i = 1; i<11; i++) {
			System.out.println(sum);
			sum += i;
			//sum =+i 이것은 sum = +i(양의 정수) 이것과 같다.
		}
		
		System.out.println(sum);
	}

}
